package shop.SearchManagement.providerSearch;

import java.util.Scanner;

import shop.UpdateManagement.ProviderUpdateManagement.Provider;
import shop.UpdateManagement.ProviderUpdateManagement.ProviderManagement;

public class ProviderSearch {
	public static Scanner sc = new Scanner(System.in);

	public static void providerSearch() {
		do {
			System.out.println("====PROVIDER SEARCH====");
			System.out.println("\t1. Search by provider ID");
			System.out.println("\t2. Search by provider name");
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
		System.out.println(" Enter provider ID: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = ProviderManagement.indexOfId(id);
		if (index == -1) {
			System.out.println("Cannot find any provider with given ID!");
			return;
		}
		System.out.println("Result :");
		System.out.printf("%-5s %-30s %-30s\n", "ID", "Name", "Address");
		ProviderManagement.getList().get(index).display();
	}

	private static void NameSearch() {
		System.out.println(" Enter provider name: ");
		String name = sc.nextLine();
		int dem = 0;
		for (Provider x : ProviderManagement.getList()) {
			if (x.getName().trim().equalsIgnoreCase(name.trim())) {
				System.out.printf("%-5s %-30s %-30s\n", "ID", "Name", "Address");

				x.display();
				dem++;
			}
		}
		if (dem == 0) {
			System.out.println("Cannot find any provider with given name!");
		}
	}
}
