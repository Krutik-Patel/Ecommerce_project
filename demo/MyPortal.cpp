#include<bits/stdc++.h>
using namespace std;
#include "./MyPortal.h"


MyPortal::MyPortal():Portal(){
    currentRequestId = 1;
    portalId = "1";
}

void MyPortal::processUserCommand(string command){
    vector<string> commands = stringSplit(command);
    ofstream PortalToPlatform;
    if(commands[0] == "Start"){
        //file clear at the start 
        //portalId increment
        PortalToPlatform.open("PortalToPlatform.txt", ios::app);
        if(PortalToPlatform.is_open()){
            PortalToPlatform<<portalId<<" "<<currentRequestId<<" "<<commands[0]<<endl;
            PortalToPlatform.close();
            pendingRequests.push_back({currentRequestId, commands});
        }
    }
    else if(commands[0] == "List"){
        PortalToPlatform.open("PortalToPlatform.txt", ios::app);
        if(PortalToPlatform.is_open()){
            PortalToPlatform<<portalId<<" "<<currentRequestId<<" "<<commands[0]<<" "<<commands[1]<<endl;
            PortalToPlatform.close();
            pendingRequests.push_back({currentRequestId, commands});
        }
    }
    else if(commands[0] == "Buy"){
        PortalToPlatform.open("PortalToPlatform.txt", ios::app);
        if(PortalToPlatform.is_open()){
            PortalToPlatform<<portalId<<" "<<currentRequestId<<" "<<commands[0]<<" "<<commands[1]<<" "<<commands[2]<<endl;
            PortalToPlatform.close();
            pendingRequests.push_back({currentRequestId, commands});
        }
    }
    else if(commands[0] == "Check"){
        checkResponse();
    }


    currentRequestId++;
}

void MyPortal::checkResponse(){
    ifstream PlatformToPortal;
    int currentRequest;
    map<int, vector<vector<string>>> responses;
    for(int current=0; current<pendingRequests.size(); current++){
        currentRequest = pendingRequests[current].first;

        PlatformToPortal.open("PlatformToPortal.txt", ios::in);
        if(PlatformToPortal.is_open()){
            string responseStr;
            while(getline(PlatformToPortal, responseStr)){
                vector<string> response = stringSplit(responseStr);
                //portalId matching and requestID matching
                if((response[0] == portalId) && (to_string(currentRequest) == response[1])){
                    responses[currentRequest].push_back(response);
                }
            }
            PlatformToPortal.close();
        }

    }
    for(auto current : responses){
        int requestId = current.first;
        vector<vector<string>> response = current.second;
        int reqIndex = -1;
        for(int request=0; request<pendingRequests.size(); request++){
            if(pendingRequests[request].first == requestId){
                reqIndex = request;
                break;
            }
        }
        if(reqIndex >= 0){
            vector<string> request = pendingRequests[reqIndex].second;
            if(request[0] == "Start"){
                for(int ind1=0; ind1<response.size(); ind1++){
                    for(int ind2=2; ind2<response[0].size(); ind2++){
                        cout<<response[ind1][ind2]<<" ";
                    }
                    cout<<endl;
                }
            }

            else if(request[0] == "List"){
                vector<MyProduct> products;
                for(int ind1=0; ind1<response.size(); ind1++){
                    //making product object here for sorting according to sortOrder
                    MyProduct product;
                    product.setProductName(response[ind1][2]);
                    product.setProductUniqueName(response[ind1][3]);
                    product.setPrice(stoi(response[ind1][4]));
                    product.setQuantityAvailable(stoi(response[ind1][5]));
                    //2 3 4 5
                    //ProductName1 productUniqueName1 price1 quanitityAvailable1
                    products.push_back(product);
                }
                //sorting of products according to sortOrder
                string sortOrder = request[2];
                if(sortOrder == "productName"){
                    sort(products.begin(), products.end(), SortProduct::sortName);
                }
                else if(sortOrder == "productUniqueName"){
                    sort(products.begin(), products.end(), SortProduct::sortUniqueName);
                }
                else if(sortOrder == "price"){
                    sort(products.begin(), products.end(), SortProduct::sortPrice);
                }
                else if(sortOrder == "quantityAvailable"){
                    sort(products.begin(), products.end(), SortProduct::sortQuantity);
                }
                
                //displaying these products after sorting
                for(int product=0; product<products.size(); product++){
                    cout<<products[product].getProductName()<<" "<<products[product].getProductUniqueName()<<" "
                    <<products[product].getPrice()<<" "<<products[product].getQuantityAvailable();
                    cout<<endl;
                }
                
            }

            else if(request[0] == "Buy"){
                for(int ind1=0; ind1<response.size(); ind1++){
                    for(int ind2=2; ind2<response[0].size(); ind2++){
                        cout<<response[ind1][ind2]<<" ";
                    }
                    cout<<endl;
                }
            }

            //deleting requests from pendingRequests vector after displaying their responses
            pendingRequests.erase(pendingRequests.begin()+reqIndex);
        }
    }
    
}

//setters and getters
string MyPortal::getPortalId(){
    return portalId;
}

void MyPortal::setPortalId(string portalId){
    this->portalId = portalId;
}

// private methods to use in class itself 
vector<string> MyPortal::stringSplit(string s){
    stringstream ss(s);
    string word;
    vector<string> commands;
    while (ss >> word) {
        commands.push_back(word);
    }
    return commands;
}
