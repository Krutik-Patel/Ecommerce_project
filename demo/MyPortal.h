#ifndef MYPORTAL_H
#define MYPORTAL_H

#include<bits/stdc++.h>
using namespace std;
#include "Portal.h"
#include "MyProduct.h"
#include "SortProduct.h"

class MyPortal : public Portal{
    public :
    MyPortal();

    void processUserCommand(string);

    void checkResponse();

    //setters and getters
    int getPortalId();

    void setPortalId(int);

    // private methods to use in class itself
    private :  
    vector<string> stringSplit(string);

    //private data members
    private :
    vector<pair<int, vector<string>>> pendingRequests;
    int currentRequestId;
    int portalId;
};

#endif