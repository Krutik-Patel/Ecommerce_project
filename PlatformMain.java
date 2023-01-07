import java.util.*;
import demo.DemoPlatform;
import ecomm.Platform;
import ecomm.Seller;
import demo.IMT2021024.*;
import demo.IMT2021048.*;
import demo.IMT2021518.*;

public class PlatformMain {

	public static void main(String[] args) {

		Platform pf = new DemoPlatform(); // platform initialized

		// creating a number of sellers (of different sub-types of Seller)
		// Assigning a name (sellerID) to each of them.
		Seller s1 = new SellerKrutik("kurtik");
		Seller s2 = new SellerSuyash("suyas");
		Seller s3 = new SellerAnshuman("anshuman");

		// adding sellers to the platform here
		s1.addPlatform(pf);
		s2.addPlatform(pf);
		s3.addPlatform(pf);

		// scanner reads the input from the txt file "PortalToPlatform.txt"
		Scanner sc = new Scanner(System.in);

		boolean running = true;
		// checking that "check" command is there or not
		while (running) {
			String inp = sc.next();
			if (inp.equals("Check")) {
				pf.processRequests();
			} else if (inp.equals("End")) {
				running = false;
				break;
			}
		}
		sc.close();
	}
}
