#include<bits/stdc++.h>
using namespace std;
#include "SortProduct.h"

//implementation of sorting functions required to sort the product objects
bool SortProduct::sortName(MyProduct p1, MyProduct p2){
    return p1.getProductName() < p2.getProductName();
}

bool SortProduct::sortUniqueName(MyProduct p1, MyProduct p2){
    return p1.getProductUniqueName() < p2.getProductUniqueName();
}

bool SortProduct::sortPrice(MyProduct p1, MyProduct p2){
    return p1.getPrice() < p2.getPrice();
}

bool SortProduct::sortQuantity(MyProduct p1, MyProduct p2){
    return p1.getQuantityAvailable() < p2.getQuantityAvailable();
}
