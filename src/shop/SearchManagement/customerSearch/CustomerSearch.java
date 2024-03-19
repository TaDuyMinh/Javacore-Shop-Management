package shop.SearchManagement.customerSearch;

import java.util.Scanner;

import shop.UpdateManagement.CustomerUpdateManagement.Customer;
import shop.UpdateManagement.CustomerUpdateManagement.CustomerManagement;

public class CustomerSearch {
	public static Scanner sc = new Scanner(System.in);

	public static void customerSearch() {
		do {
			System.out.println("====CUSTOMER SEARCH====");
			System.out.println("\t1. Search by customer ID");
			System.out.println("\t2. Search by customer name");
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
		System.out.println(" Enter customer ID: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = CustomerManagement.indexOfId(id);
		if (index == -1) {
			System.out.println("Cannot find any customer with given ID!");
			return;
		}
		System.out.println("Result :");
		System.out.printf("%-5s %-30s %-12s\n", "ID", "Name", "Phone number");
		CustomerManagement.getList().get(index).display();
	}

	private static void NameSearch() {
		System.out.println(" Enter customer name: ");
		String name = sc.nextLine();
		int dem = 0;
		for (Customer x : CustomerManagement.getList()) {
			if (x.getName().trim().equalsIgnoreCase(name.trim())) {
				System.out.printf("%-5s %-30s %-12s\n", "ID", "Name", "Phone number");

				x.display();
				dem++;
			}
		}
		if (dem == 0) {
			System.out.println("Cannot find any customer with given name!");
		}
	}
}
