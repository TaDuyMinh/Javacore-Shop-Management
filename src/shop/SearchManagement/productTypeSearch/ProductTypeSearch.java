package shop.SearchManagement.productTypeSearch;

import java.util.Scanner;

import shop.UpdateManagement.ProductTypeUpdateManagement.ProductType;
import shop.UpdateManagement.ProductTypeUpdateManagement.ProductTypeManagement;

public class ProductTypeSearch {
	public static Scanner sc = new Scanner(System.in);

	public static void productTypeSearch() {
		do {
			System.out.println("====PRODUCT TYPE SEARCH====");
			System.out.println("\t1. Search by product type ID");
			System.out.println("\t2. Search by product type name");
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
		System.out.println(" Enter product type ID: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = ProductTypeManagement.indexOfId(id);
		if (index == -1) {
			System.out.println("Cannot find any product type with given ID!");
			return;
		}
		System.out.println("Result :");
		System.out.printf("%-5s %-15s %-30s\n", "ID", "Name", "Description");
		ProductTypeManagement.getList().get(index).display();
	}

	private static void NameSearch() {
		System.out.println(" Enter product type name: ");
		String name = sc.nextLine();
		int dem = 0;
		for (ProductType x : ProductTypeManagement.getList()) {
			if (x.getName().trim().equalsIgnoreCase(name.trim())) {
				System.out.printf("%-5s %-15s %-30s\n", "ID", "Name", "Description");

				x.display();
				dem++;
			}
		}
		if (dem == 0) {
			System.out.println("Cannot find any product type with given name!");
		}
	}
}
