#ifndef SORTPRODUCT_H
#define SORTPRODUCT_H

#include<bits/stdc++.h>
using namespace std;
#include "MyProduct.h"

class SortProduct{
    public :
    
    //function for sorting products according to name
    static bool sortName(MyProduct, MyProduct);

    //function for sorting products according to unique name
    static bool sortUniqueName(MyProduct, MyProduct);

    //function for sorting products according to price
    static bool sortPrice(MyProduct, MyProduct);

    //function for sorting products according to quantity
    static bool sortQuantity(MyProduct, MyProduct);

};

#endif
