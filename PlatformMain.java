import java.util.*;
import demo.DemoPlatform;
import ecomm.Platform;
import ecomm.Seller;
import demo.IMT2021024.*;
import demo.IMT2021048.*;
import demo.IMT2021518.*;

public class PlatformMain {

	public static void main(String[] args) {

		Platform pf = new DemoPlatform(); // replace with appropriate derived class

		// creating a number of sellers (of different sub-types of Seller)
		// Assigning a name (sellerID) to each of them.

		// adding sellers here
		Seller s1 = new SellerKrutik("kurtik");
		Seller s2 = new SellerSuyash("suyas");
		Seller s3 = new SellerAnshuman("anshuman");
		s1.addPlatform(pf);
		s2.addPlatform(pf);
		s3.addPlatform(pf);
		
		Scanner sc = new Scanner(System.in);
		//checking that "check" command is there or not
		while (1 > 0) {
			String inp = sc.next();
			if (inp.equals("Check"))
				pf.processRequests();
			if (inp.equals("End"))
				break;
		}

	}

}
