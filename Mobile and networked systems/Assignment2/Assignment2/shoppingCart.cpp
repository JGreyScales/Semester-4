#include "shoppingCart.h"

std::map<std::string, int> shoppingCart::shoppingCartContainer;

// I was going to ues this approach at first, but it was easier to let the client
// be authorative and just use setItem and override previous
void shoppingCart::addItem(const std::string &key, int value)
{
    int currentVal = shoppingCart::shoppingCartContainer[key];
    shoppingCart::shoppingCartContainer[key] = value + currentVal;
    writeToStorage();
}

void shoppingCart::setItem(const std::string &key, int value)
{
    shoppingCart::shoppingCartContainer[key] = value;
    writeToStorage();
}

void shoppingCart::resetContainer()
{
    shoppingCart::shoppingCartContainer.clear();
    writeToStorage();
}

bool shoppingCart::writeToStorage()
{
    std::ofstream outFile(shoppingCart::storageFile);
    if (!outFile)
        return false;

    for (const std::pair<std::string, int> &item : shoppingCart::shoppingCartContainer)
    {
        outFile << item.first << shoppingCart::delimiter << item.second << '\n';
    }

    return true;
}

bool shoppingCart::readFromStorage()
{
    std::ifstream inFile(shoppingCart::storageFile);
    if (!inFile)
        return false;

    std::string line;
    while (std::getline(inFile, line))
    {
        size_t delimiterPos = line.find(shoppingCart::delimiter);

        // If delimiter doesn't exist in the string
        if (delimiterPos != std::string::npos)
        {
            try
            {
                std::string key = line.substr(0, delimiterPos);
                int value = std::stoi(line.substr(delimiterPos + 1));
                shoppingCart::setItem(key, value);
            }
            catch (const std::exception &e)
            {
                continue;
            }
        }
    }

    return true;
}