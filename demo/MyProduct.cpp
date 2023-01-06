#include<bits/stdc++.h>
using namespace std;
#include "MyProduct.h"


MyProduct::MyProduct(){
    productName = "";
    productUniqueName = "";
    price = 0;
    quantityAvailable = 0;
}

//getters
string MyProduct::getProductName(){
    return productName;
}
string MyProduct::getProductUniqueName(){
    return productUniqueName;
}
float MyProduct::getPrice(){
    return price;
}
int MyProduct::getQuantityAvailable(){
    return quantityAvailable;
}

//setters
void MyProduct::setProductName(string productName){
    this->productName = productName;
}
void MyProduct::setProductUniqueName(string productUniqueName){
    this->productUniqueName = productUniqueName;
}
void MyProduct::setPrice(float price){
    this->price = price;
}
void MyProduct::setQuantityAvailable(int quantityAvailable){
    this->quantityAvailable = quantityAvailable;
}
