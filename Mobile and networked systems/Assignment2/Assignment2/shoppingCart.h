#ifndef SHOPPING_CART_H
#define SHOPPING_CART_H

#include <map>
#include <string>
#include <fstream>
#include <iostream>

class shoppingCart
{
private:
    static inline const char delimiter = '=';
    static std::map<std::string, int> shoppingCartContainer;

public:
    static inline const std::string storageFile = "shoppingCart.txt";

    static void addItem(const std::string &key, int value);
    static void setItem(const std::string &key, int value);
    static void resetContainer();
    static bool writeToStorage(); 
    static bool readFromStorage();
};

#endif // SHOPPING_CART_H