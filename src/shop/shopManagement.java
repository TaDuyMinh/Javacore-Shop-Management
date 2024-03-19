package shop;

import java.util.Scanner;

import shop.SalesManagement.SalesManagement;
import shop.SearchManagement.SearchManagement;
import shop.UpdateManagement.UpdateManagement;
import shop.UpdateManagement.ProductTypeUpdateManagement.ProductTypeManagement;
import shop.UpdateManagement.ProductUpdateManagement.ProductManagement;
import shop.UpdateManagement.ProviderUpdateManagement.ProviderManagement;

public class shopManagement {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ProviderManagement.init();
		ProductTypeManagement.init();
		ProductManagement.init();
		do {
			System.out.println("\n===========SHOP MANAGEMENT PROGRAM=========");
			System.out.println("Choose one management function");
			System.out.println("1. Update system information");
			System.out.println("2. Sales Management");
			System.out.println("3. Search Management");
			System.out.println("0. Exit");

			System.out.println("Your choice: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				UpdateManagement.updateManagement();
				break;
			case 2:
				SalesManagement.salesManagement();
				break;
			case 3:
				SearchManagement.searchManagement();
				break;
			case 0:
				System.out.println("Program exited successfully!");
				System.exit(0);
			default:
				System.out.println("Choice is invalid! ");
			}
		} while (true);
	}
}
