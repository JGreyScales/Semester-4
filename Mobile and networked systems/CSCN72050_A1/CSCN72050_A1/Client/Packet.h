#pragma once
#include <iostream>
#include <cstring>

const int EmptyPktSize = 6;   // Header (2) + CRC (2) + overhead (2)

class Packet
{
    struct Header
    {
        unsigned char Source : 4;
        unsigned char LineNumber : 4;
        unsigned char Length;
    } Head;

    char* Data;
    unsigned int CRC;     // only lower 16 bits used
    char* TxBuffer;

public:
    // Default constructor
    Packet() : Data(nullptr), TxBuffer(nullptr), CRC(0)
    {
        memset(&Head, 0, sizeof(Head));
        Head.Source = 2;
    }

    // Construct packet from raw buffer (received from socket)
    Packet(char* src) : Data(nullptr), TxBuffer(nullptr)
    {
        // Copy header
        memcpy(&Head, src, 2);

        // Copy data
        if (Head.Length > 0)
        {
            Data = new char[Head.Length + 1];
            memcpy(Data, src + 2, Head.Length);
            Data[Head.Length] = '\0';
        }

        // Copy CRC (2 bytes)
        memcpy(&CRC, src + 2 + Head.Length, 2);
    }

    void SetLineNumber(int value)
    {
        Head.LineNumber = value;
    }

    // Set packet data
    void SetData(char* srcData, int Size)
    {
        delete[] Data;
        Data = nullptr;

        if (Size > 0)
        {
            Head.Length = static_cast<unsigned char>(Size);
            Data = new char[Size + 1];
            memcpy(Data, srcData, Size);
            Data[Size] = '\0';
        }

        CRC = CalculateCRC();
    }

    // Serialize packet into transmit buffer
    char* SerializeData(int& TotalSize)
    {
        if (TxBuffer)
            delete[] TxBuffer;

        TotalSize = EmptyPktSize + Head.Length;
        TxBuffer = new char[TotalSize];

        // Header
        memcpy(TxBuffer, &Head, 2);

        // Data
        memcpy(TxBuffer + 2, Data, Head.Length);

        // CRC (2 bytes)
        memcpy(TxBuffer + 2 + Head.Length, &CRC, 2);

        return TxBuffer;
    }

    // Simple 16-bit checksum CRC (slide-deck typical)
    unsigned int CalculateCRC()
    {
        unsigned int crc = 0;

        // Header bytes
        unsigned char* h = reinterpret_cast<unsigned char*>(&Head);
        crc += h[0];
        crc += h[1];

        // Data bytes
        for (int i = 0; i < Head.Length; i++)
            crc += static_cast<unsigned char>(Data[i]);

        return crc & 0xFFFF;   // 16-bit CRC
    }

    void Display(std::ostream& os)
    {
        os << std::dec;
        os << "Source:  " << (int)Head.Source << std::endl;
        os << "LineNum: " << (int)Head.LineNumber << std::endl;
        os << "Length:  " << (int)Head.Length << std::endl;
        os << "Msg:     " << (Data ? Data : "") << std::endl;
        os << "CRC:     " << std::hex << (CRC & 0xFFFF) << std::endl;
    }
};
