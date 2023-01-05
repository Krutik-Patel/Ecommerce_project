import java.util.*;
import demo.DemoPlatform;
import ecomm.Platform;
import ecomm.Seller;
import demo.IMT2021024.*;
import demo.IMT2021048.*;;

public class PlatformMain {

	public static void main(String[] args) {

		Platform pf = new DemoPlatform(); // replace with appropriate derived class

		// create a number of sellers (of different sub-types of Seller)
		// Assign a name (sellerID) to each of them.

		// replace each of the XYZ below with the derived class name of one of the
		// team members.

		// add sellers here
		Seller s1 = new SellerKrutik("kurtik"); // sd1 derived class of seller created by Anshuman
		Seller s2 = new SellerSuyash("suyas");
		s1.addPlatform(pf);
		s2.addPlatform(pf);
		/*
		 * Seller s2 = new ada("Seller2");
		 * s1.addPlatform(pf);
		 * 
		 * Seller s3 = new SellerXYZ2("Seller3");
		 * s1.addPlatform(pf);
		 */

		/*
		 * // keep reading from System.in
		 * // If "Check" typed in
		 * // invoke
		 * pf.processRequests();
		 */
		Scanner sc = new Scanner(System.in);
		while (1 > 0) {
			String inp = sc.next();
			if (inp.equals("Check"))
				pf.processRequests();
			if (inp.equals("End"))
				break;
		}

	}

}
