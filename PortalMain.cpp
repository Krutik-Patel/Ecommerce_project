#include <bits/stdc++.h>
using namespace std;
#include "./demo/MyPortal.h"

class PortalMain
{
public:
    PortalMain()
    {
        currentPortalId = 1;
    }
    static void main()
    {
        // make portal objects and give them a PortalId
        // portal will process userCommands and displays responses;
        MyPortal portal;
        // portal.setPortalId(currentPortalId);
        // currentPortalId++;

        while (true)
        {
            string commandType;
            cin >> commandType;
            if (commandType == "Start")
            {
                string command = commandType;
                portal.processUserCommand(command);
            }
            else if (commandType == "List")
            {
                string command = commandType;
                string category;
                cin >> category;
                command = command + " " + category;
                string sortOrder;
                cin >> sortOrder;
                command = command + " " + sortOrder;
                portal.processUserCommand(command);
            }
            else if (commandType == "Buy")
            {
                string command = commandType;
                string productId;
                cin >> productId;
                command = command + " " + productId;
                string numItems;
                cin >> numItems;
                command = command + " " + numItems;
                portal.processUserCommand(command);
            }
            else if (commandType == "Check")
            {
                string command = commandType;
                portal.processUserCommand(command);
            }
            else if (commandType == "End")
            {
                break;
            }
        }
    }

private:
    int currentPortalId;
    vector<MyPortal> portals;
};

int main()
{
    PortalMain::main();
    return 0;
}