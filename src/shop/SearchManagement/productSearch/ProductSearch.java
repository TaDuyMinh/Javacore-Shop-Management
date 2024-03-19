package shop.SearchManagement.productSearch;

import java.util.Scanner;

import shop.UpdateManagement.ProductUpdateManagement.Product;
import shop.UpdateManagement.ProductUpdateManagement.ProductManagement;

public class ProductSearch {
	public static Scanner sc = new Scanner(System.in);

	public static void productSearch() {
		do {
			System.out.println("====PRODUCT SEARCH====");
			System.out.println("\t1. Search by product ID");
			System.out.println("\t2. Search by product name");
			System.out.println("\t0. Go back");

			System.out.println("Your choice: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				IDSearch();
				break;
			case 2:
				NameSearch();
				break;
			case 0:
				return;
			default:
				System.out.println("Choice is invalid");
			}
		} while (true);
	}

	private static void IDSearch() {
		System.out.println(" Enter product ID: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = ProductManagement.indexOfId(id);
		if (index == -1) {
			System.out.println("Cannot find any product with given ID!");
			return;
		}
		System.out.println("Result :");
		System.out.printf("%8s %-15s %-15s %-30s %-15s %-20s \n", "ID", "Provider", "Type", "Name", "Amount", "Price");
		ProductManagement.getList().get(index).display();
	}

	private static void NameSearch() {
		System.out.println(" Enter product name: ");
		String name = sc.nextLine();
		int dem = 0;
		for (Product x : ProductManagement.getList()) {
			if (x.getName().trim().equalsIgnoreCase(name.trim())) {
				System.out.printf("%8s %-15s %-15s %-30s %-15s %-20s \n", "ID", "Provider", "Type", "Name", "Amount", "Price");
				x.display();
				dem++;
			}
		}
		if (dem == 0) {
			System.out.println("Cannot find any product with given name!");
		}
	}
}
