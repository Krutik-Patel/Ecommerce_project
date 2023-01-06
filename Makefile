CC = g++

target: DemoPortal.o MyProduct.o Portal.o SortProduct.o PortalMain.o
	$(CC) DemoPortal.o MyProduct.o Portal.o SortProduct.o PortalMain.o -o test

DemoPortal.o: ./demo/DemoPortal.cpp ./demo/DemoPortal.h
	$(CC) -c ./demo/DemoPortal.cpp

MyProduct.o: ./demo/MyProduct.cpp ./demo/MyProduct.h
	$(CC) -c ./demo/MyProduct.cpp

Portal.o: ./demo/Portal.cpp ./demo/Portal.h
	$(CC) -c ./demo/Portal.cpp

SortProduct.o: ./demo/SortProduct.cpp ./demo/SortProduct.h
	$(CC) -c ./demo/SortProduct.cpp

PortalMain.o: PortalMain.cpp
	$(CC) -c PortalMain.cpp

clean:
	rm *.o