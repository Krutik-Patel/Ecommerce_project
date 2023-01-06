#ifndef SORTPRODUCT_H
#define SORTPRODUCT_H

#include<bits/stdc++.h>
using namespace std;
#include "MyProduct.h"

class SortProduct{
    public :
    static bool sortName(MyProduct, MyProduct);

    static bool sortUniqueName(MyProduct, MyProduct);

    static bool sortPrice(MyProduct, MyProduct);

    static bool sortQuantity(MyProduct, MyProduct);

};

#endif