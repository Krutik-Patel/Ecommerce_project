CC = g++

target: MyPortal.o MyProduct.o Portal.o SortProduct.o PortalMain.o
	$(CC) MyPortal.o MyProduct.o Portal.o SortProduct.o PortalMain.o -o test

MyPortal.o: ./demo/MyPortal.cpp ./demo/MyPortal.h
	$(CC) -c ./demo/MyPortal.cpp

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