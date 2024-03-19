package shop.SearchManagement.cartSearch;

import java.util.Scanner;

import shop.SalesManagement.SalesManagement;

public class CartSearch {
	static Scanner sc = new Scanner(System.in);
	public static void cartSearch() {
		System.out.println("Enter cart ID: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = SalesManagement.indexOfId(id);
		if(index ==-1) {
			System.out.println("Cart ID does not exist!");
			return;
		}
		System.out.println("Result: ");
		System.out.printf("%-25s %-10s %-14s %-15s\n", "Product name", "Amount", "Price", "Cost");
		SalesManagement.getList().get(index).display();
	}
}
