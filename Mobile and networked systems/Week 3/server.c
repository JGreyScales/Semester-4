#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <stdio.h>
#include <unistd.h>

#define INVALID_SOCKET -1
#define SOCKET_ERROR -1

int main()
{
    struct sockaddr_in SvrAddr;
    int WelcomeSocket, ConnectionSocket;

    //Data buffers
    char RxBuffer[128] = {};

    //create welcoming socket at port and bind local address
    if ((WelcomeSocket = socket(AF_INET, SOCK_STREAM, 0)) == INVALID_SOCKET)
    {
        printf("ERROR:  Failed to create WelcomeSocket\n");
        return 0;
    }

    SvrAddr.sin_family = AF_INET;
    SvrAddr.sin_addr.s_addr = INADDR_ANY;
    SvrAddr.sin_port = htons(27000);

    if ((bind(WelcomeSocket, (struct sockaddr*)&SvrAddr, sizeof(SvrAddr))) == SOCKET_ERROR)
    {
        printf("ERROR:  Failed to bind WelcomeSocket\n");
        close(WelcomeSocket);
        return 0;
    }

    //Specify the maximum number of clients that can be queued
    if (listen(WelcomeSocket, 1) == SOCKET_ERROR)
    {
        printf("ERROR:  Failed to start Listening Port\n");
        close(WelcomeSocket);
        return 0;
    }

    printf("Waiting for client connection\n");
    ConnectionSocket = SOCKET_ERROR;

    while (1)
    {
        //wait for an incoming connection from a client
        if ((ConnectionSocket = accept(WelcomeSocket, NULL, NULL)) == SOCKET_ERROR)
        {
            printf("oops!  Something went wrong\n");
            return 0;
        }
        else
        {
            printf("Connection Established\n");

            /***********************************
            * TBD - Insert your Lab 6 code here*
            ************************************/

            close(ConnectionSocket);
        }
    }

    return 1;
}
