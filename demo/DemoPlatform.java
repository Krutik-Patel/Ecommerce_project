package demo;

import java.io.*;
import java.util.*;
import ecomm.Platform;
import ecomm.Seller;
import ecomm.Globals;
import ecomm.Product;

public class DemoPlatform extends Platform {
	private HashMap<String, Boolean> handled = new HashMap<String, Boolean>(); // the handled request ids
	private ArrayList<Seller> sellerlist = new ArrayList<>(); // the sellers with the platform

	public DemoPlatform() {
		super();
	}

	@Override
	public boolean addSeller(Seller aSeller) {
		// TODO Auto-generated method stub
		sellerlist.add(aSeller);
		return true;
	}

	@Override
	public void processRequests() {
		// TODO Auto-generated method stub
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

				// if the request has not been handeled till now
				if (handled.containsKey(requestID) == false) {
					requests.add(data);
					handleIndividualRequest(reqnoWords); // private method handling individual request
					handled.put(requestID, true); // marking the requestID as handled
				}
			}
			myReader.close();
		} catch (IOException e) {
			System.out.println("Reading error occurred.");
			e.printStackTrace();
		}
	}

	private void handleIndividualRequest(String[] requests) {

		String portalID = requests[0]; // portal id
		String requestID = requests[1]; // request id

		// command types
		if (requests[2].equals("Start")) {
			System.out.print("Start Request___");
			String towrite = "";
			for (Globals.Category category : Globals.Category.values()) {
				towrite = towrite + category.name() + " "; // shows all the categories
			}
			towrite = portalID + " " + requestID + " " + towrite;

			// write output in txt file
			writeOutput(towrite);
			System.out.print("EXECUTED\n");
		} else if (requests[2].equals("List")) {
			System.out.print("List Request___");
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
						String toWrite = portalID + " " + requestID + " " + ptemp.get(d).getName() + " "
								+ ptemp.get(d).getProductID() + " " + ptemp.get(d).getPrice() + " "
								+ ptemp.get(d).getQuantity();
						writeOutput(toWrite);
					}

				}
			}

			System.out.print("EXECUTED\n");
		} else if (requests[2].equals("Buy")) {
			System.out.print("Buy Request___");
			String uniqueProdID = requests[3]; // unique id of the product
			String quantStr = requests[4];
			boolean result = false;
			int quantity = Integer.parseInt(quantStr); // quantity
			for (int j = 0; j < sellerlist.size(); j++) {

				// if a successful transaction occurs if we get
				result = sellerlist.get(j).buyProduct(uniqueProdID, quantity);

				// the product id and quantity
				if (result == true) {
					break;
				}
			}
			String toWrite = portalID + " " + requestID;
			if (result) {
				toWrite = toWrite + " " + "Success";
			} else {
				toWrite = toWrite + " Failure";
			}
			writeOutput(toWrite);
			System.out.print("EXECUTED\n");
		}
	}

	private void writeOutput(String output) {
		try {
			Writer writer;
			writer = new BufferedWriter(new FileWriter(Globals.fromPlatform, true));
			writer.write(output + "\n");
			writer.close();
		} catch (IOException ioe) {
			System.out.println("Writing error occurred.");
			ioe.printStackTrace();
		}
	}
}
