#ifndef MYPRODUCT_H
#define MYPRODUCT_H

#include<bits/stdc++.h>
using namespace std;

class MyProduct{
    public :
    MyProduct();

    //getters
    string getProductName();

    string getProductUniqueName();

    float getPrice();

    int getQuantityAvailable();

    //setters
    void setProductName(string);

    void setProductUniqueName(string);

    void setPrice(float);

    void setQuantityAvailable(int);

    private :
    string productName;
    string productUniqueName;
    float price;
    int quantityAvailable;
};

#endif