#include<bits/stdc++.h>
using namespace std;
#include "./DemoPortal.h"


DemoPortal::DemoPortal():Portal(){
    currentRequestId = 1;
    portalId = "1";
}

void DemoPortal::processUserCommand(string command){
    vector<string> commands = stringSplit(command);
    ofstream PortalToPlatform;
    //checking commmand types and accordingly writing requests to PortalToPlatform.txt file
    //here pendingRequests vector store the pending requests
    //we will delete a request from this vector after displaying its response
    
    //Start commmand
    if(commands[0] == "Start"){
        //file clear at the start 
        PortalToPlatform.open("PortalToPlatform.txt", ios::app);
        if(PortalToPlatform.is_open()){
            PortalToPlatform<<portalId<<" "<<currentRequestId<<" "<<commands[0]<<endl;
            PortalToPlatform.close();
            pendingRequests.push_back({currentRequestId, commands});
        }
    }
    
    //List commmand
    else if(commands[0] == "List"){
        PortalToPlatform.open("PortalToPlatform.txt", ios::app);
        if(PortalToPlatform.is_open()){
            PortalToPlatform<<portalId<<" "<<currentRequestId<<" "<<commands[0]<<" "<<commands[1]<<endl;
            PortalToPlatform.close();
            pendingRequests.push_back({currentRequestId, commands});
        }
    }
    
    //Buy commmand
    else if(commands[0] == "Buy"){
        PortalToPlatform.open("PortalToPlatform.txt", ios::app);
        if(PortalToPlatform.is_open()){
            PortalToPlatform<<portalId<<" "<<currentRequestId<<" "<<commands[0]<<" "<<commands[1]<<" "<<commands[2]<<endl;
            PortalToPlatform.close();
            pendingRequests.push_back({currentRequestId, commands});
        }
    }
    
    //check command
    else if(commands[0] == "Check"){
        checkResponse();
    }


    currentRequestId++;
}

void DemoPortal::checkResponse(){
    ifstream PlatformToPortal;
    int currentRequest;
    
    //map responses - key = requestId, value - vector of responses of this requestId
    map<int, vector<vector<string>>> responses;
    
    //scanning through pendingRequests vector and checking that responses to these requests are there in PlatformToPortal.txt file
    for(int current=0; current<pendingRequests.size(); current++){
        currentRequest = pendingRequests[current].first;

        PlatformToPortal.open("PlatformToPortal.txt", ios::in);
        if(PlatformToPortal.is_open()){
            string responseStr;
             //we are reading here entire file
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
    
    //now will consider these responses stored in map 'responses' one by one
    for(auto current : responses){
        int requestId = current.first; //requestId
        vector<vector<string>> response = current.second; //vector of responsea to this request
        int reqIndex = -1;
        
        //again scanning through pendingRequests vector to get type of this request and to delete that request
        //here reqIndex stores index of this request in pendingRequests vector
        for(int request=0; request<pendingRequests.size(); request++){
            if(pendingRequests[request].first == requestId){
                reqIndex = request;
                break;
            }
        }
        if(reqIndex >= 0){
            vector<string> request = pendingRequests[reqIndex].second; //getting this request
            //checking type of current response of a request
            
            //for 'Start', displaying types of categories 
            if(request[0] == "Start"){
                for(int ind1=0; ind1<response.size(); ind1++){
                    for(int ind2=2; ind2<response[0].size(); ind2++){
                        cout<<response[ind1][ind2]<<" ";
                    }
                    cout<<endl;
                }
            }

            //for 'List', first we make objects of these products and then sort them according to sortOrder
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
                if(sortOrder == "Name"){
                    sort(products.begin(), products.end(), SortProduct::sortName);
                }
                else if(sortOrder == "UniqueName"){
                    sort(products.begin(), products.end(), SortProduct::sortUniqueName);
                }
                else if(sortOrder == "Price"){
                    sort(products.begin(), products.end(), SortProduct::sortPrice);
                }
                else if(sortOrder == "Quantity"){
                    sort(products.begin(), products.end(), SortProduct::sortQuantity);
                }
                
                //displaying these products after sorting
                for(int product=0; product<products.size(); product++){
                    cout<<products[product].getProductName()<<" "<<products[product].getProductUniqueName()<<" "
                    <<products[product].getPrice()<<" "<<products[product].getQuantityAvailable();
                    cout<<endl;
                }
                
            }

            //for 'Buy', showing result of this purchase i.e. success or failure
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
string DemoPortal::getPortalId(){
    return portalId;
}

void DemoPortal::setPortalId(string portalId){
    this->portalId = portalId;
}

// private methods to use in class itself which splits the string 
vector<string> DemoPortal::stringSplit(string s){
    stringstream ss(s);
    string word;
    vector<string> commands;
    while (ss >> word) {
        commands.push_back(word);
    }
    return commands;
}
