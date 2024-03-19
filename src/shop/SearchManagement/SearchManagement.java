package shop.SearchManagement;

import java.util.Scanner;

import shop.SearchManagement.cartSearch.CartSearch;
import shop.SearchManagement.customerSearch.CustomerSearch;
import shop.SearchManagement.productSearch.ProductSearch;
import shop.SearchManagement.productTypeSearch.ProductTypeSearch;
import shop.SearchManagement.providerSearch.ProviderSearch;

public class SearchManagement {
	public static Scanner sc = new Scanner(System.in);

	public static void searchManagement() {
		do {
			System.out.println("\t-------SEARCH PROGRAM-------");
			System.out.println("\t1. Provider search");
			System.out.println("\t2. Product type search");
			System.out.println("\t3. Product search");
			System.out.println("\t4. Customer search");
			System.out.println("\t5. Cart search");
			System.out.println("\t0. Go back");

			System.out.println("Your choice: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				ProviderSearch.providerSearch();
				;
				break;
			case 2:
				ProductTypeSearch.productTypeSearch();
				;
				break;
			case 3:
				ProductSearch.productSearch();
				;
				break;
			case 4:
				CustomerSearch.customerSearch();
				;
				break;
			case 5:
				CartSearch.cartSearch();
				break;
			case 0:
				return;
			default:
				System.out.println("Choice is invalid");
			}
		} while (true);
	}
}
