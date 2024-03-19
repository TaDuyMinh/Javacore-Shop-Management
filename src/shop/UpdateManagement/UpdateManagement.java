package shop.UpdateManagement;

import java.util.Scanner;

import shop.UpdateManagement.CustomerUpdateManagement.CustomerManagement;
import shop.UpdateManagement.ProductTypeUpdateManagement.ProductTypeManagement;
import shop.UpdateManagement.ProductUpdateManagement.ProductManagement;
import shop.UpdateManagement.ProviderUpdateManagement.ProviderManagement;


public class UpdateManagement {
	static Scanner sc = new Scanner(System.in);

	public static void updateManagement() {
		do {
			System.out.println("\n=====SYSTEM INFORMATION MANAGEMENT=====");
			System.out.println("Choose function");
			System.out.println("\t1. Update provider information");
			System.out.println("\t2. Update product type information");
			System.out.println("\t3. Update product information");
			System.out.println("\t4. Update customer information");
			System.out.println("\t0. Go back");
			System.out.println("Your choice: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				ProviderManagement.providerManagement();
				break;
			case 2:
				ProductTypeManagement.productTypeManagement();
				break;
			case 3:
				ProductManagement.productManagement();
				break;
			case 4:
				CustomerManagement.customerManagement();
				break;
			case 0:
				return;
			default:
				System.out.println("Choice is invalid");
			}
		} while (true);
	}

}
