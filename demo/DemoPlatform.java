package demo;

import java.io.*;
import java.util.*;
import ecomm.Platform;
import ecomm.Seller;
import ecomm.Globals;
import ecomm.Product;

public class DemoPlatform extends Platform {
	private HashMap<String, Boolean> handled = new HashMap<String, Boolean>(); // the handled ids
	private ArrayList<Seller> sellerlist = new ArrayList<>(); // the sellers with the platform

	// constructor
	public DemoPlatform() {
		super();
	}

	@Override
	public boolean addSeller(Seller aSeller) {
		sellerlist.add(aSeller);
		return true;
	}

	@Override
	public void processRequests() {
		try {

			// file reader
			File myObj = new File(Globals.toPlatform);
			Scanner myReader = new Scanner(myObj);

			// lists of pending requests
			ArrayList<String> requests = new ArrayList<>();

			// main while loop
			while (myReader.hasNextLine()) {

				// input from PortalToPlatform.txt
				String data = myReader.nextLine();
				String[] reqnoWords = data.split("\\s");
				String requestID = reqnoWords[1];
				String portalID = reqnoWords[0];
				String key = portalID + " " + requestID; // key for the hashmap, made of portalID<Space>requestID

				// if the request has not been handeled till now
				if (handled.containsKey(key) == false) {
					requests.add(data);
					handleIndividualRequest(reqnoWords); // private method handling individual request
					handled.put(key, true); // marking the requestID as handled
				}
			}
			myReader.close();
		} catch (IOException e) {
			// catch exception
			System.out.println("Reading error occurred.");
			e.printStackTrace();
		}
	}

	// private method to handleIndividualRequest called by the processRequest method
	// this method cannot be accessed by any class object other than itself
	private void handleIndividualRequest(String[] requests) {

		String portalID = requests[0]; // portal id
		String requestID = requests[1]; // request id

		// command types
		if (requests[2].equals("Start")) {

			// debug message
			System.out.print("Start Request___::PortalID=" + portalID + " -- ");

			// towrite is the text to be written to the textfile
			String towrite = "";

			// get all the categories and add their names to the string
			for (Globals.Category category : Globals.Category.values()) {
				towrite = towrite + category.name() + " "; // shows all the categories
			}
			towrite = portalID + " " + requestID + " " + towrite;

			// write output in txt file, private method to write the text in file
			writeOutput(towrite);

			// debug message
			System.out.print("EXECUTED\n");

		} else if (requests[2].equals("List")) {

			// debug message
			System.out.print("List Request___::PortalID=" + portalID + " -- ");

			// new temporary arraylist of products, it will be holding the arrayList passed
			// from the seller method FindProducts
			ArrayList<Product> ptemp = new ArrayList<>(); // products available list of the category
			for (int k = 0; k < sellerlist.size(); k++) // iterating through all the connected sellers
			{
				if (requests[3].equals("Mobile")) {
					ptemp = sellerlist.get(k).findProducts(Globals.Category.Mobile);

				} else if (requests[3].equals("Book")) {
					ptemp = sellerlist.get(k).findProducts(Globals.Category.Book);
				}

				if (ptemp.size() > 0) {
					for (int d = 0; d < ptemp.size(); d++) { // product details being written

						// toWrite string to be written on the text file
						String toWrite = portalID + " " + requestID + " " + ptemp.get(d).getName() + " "
								+ ptemp.get(d).getProductID() + " " + ptemp.get(d).getPrice() + " "
								+ ptemp.get(d).getQuantity();

						// write output in the text file
						writeOutput(toWrite);
					}

				}
			}

			// debug message
			System.out.print("EXECUTED\n");

		} else if (requests[2].equals("Buy")) {

			// debug message
			System.out.print("Buy Request___::PortalID= " + portalID + " -- ");

			String uniqueProdID = requests[3]; // unique id of the product
			String quantStr = requests[4];
			boolean result = false;
			int quantity = Integer.parseInt(quantStr); // quantity

			// ask every seller to buy their product, if it is true breaks the loop
			for (int j = 0; j < sellerlist.size(); j++) {

				// if a successful transaction occurs if we get
				result = sellerlist.get(j).buyProduct(uniqueProdID, quantity);

				// the product id and quantity
				if (result == true) {
					break;
				}
			}

			// toWrite string to be written on the text file
			String toWrite = portalID + " " + requestID;

			// success and failure according added to the string to be printed
			if (result) {
				toWrite = toWrite + " " + "Success";
			} else {
				toWrite = toWrite + " Failure";
			}

			// write the output
			writeOutput(toWrite);
			System.out.print("EXECUTED\n");
		}
	}

	// private method to write in file, not accessible to other objects
	private void writeOutput(String output) {
		try {
			Writer writer;
			writer = new BufferedWriter(new FileWriter(Globals.fromPlatform, true));
			writer.write(output + "\n");
			writer.close();
		} catch (IOException ioe) {
			// catch exception
			System.out.println("Writing error occurred.");
			ioe.printStackTrace();
		}
	}
}
