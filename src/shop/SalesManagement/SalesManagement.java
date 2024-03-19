package shop.SalesManagement;

import java.util.ArrayList;
import java.util.Scanner;

import shop.UpdateManagement.CustomerUpdateManagement.CustomerManagement;
import shop.UpdateManagement.ProductUpdateManagement.ProductManagement;

public class SalesManagement {
	public static int autoNumber = 11;
	static Scanner sc = new Scanner(System.in);
	private static ArrayList<Cart> list = new ArrayList<>();

	public static void salesManagement() {
		System.out.println("\n--------Sales Management--------");
		System.out.println("You are using this function as: ");
		System.out.println("\t1. Seller");
		System.out.println("\t2. Customer");
		System.out.println("\n\t0. Go back");
		System.out.println("Your choice: ");
		int chon = Integer.parseInt(sc.nextLine());
		if (chon == 1) {
			cartManagement();
		} else if (chon == 2) {
			customer();
		} else if (chon == 0) {
			return;
		} else {
			System.out.println("Choice is invalid");
		}
	}

	private static void customer() {
		Cart cart = new Cart();
		System.out.println("\nWelcome to the store !");
		do {
			System.out.println("\t1. View cart");
			System.out.println("\t2. Add product to cart");
			System.out.println("\t3. Change product in cart");
			System.out.println("\t4. Delete product from cart");
			System.out.println("\t5. Delete cart");
			System.out.println("\t6. Check out");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				cart.display();
				break;
			case 2:
				cart.add();
				break;
			case 3:
				cart.update();
				break;
			case 4:
				cart.remove();
				break;
			case 5:
				System.out.println("Cart deleted!");
				cart = null;
				return;
			case 6:
				cartCheckOut(cart);
				return;
			default:
				System.out.println("Choice is invalid");
			}
		} while (true);

	}

	private static double totalRevenue() {
		double total = 0;
		for (Cart cart : list) {
			total += cart.totalCost();
		}
		return total;
	}

	private static void cartManagement() {
		System.out.println("======List of sold product(s)======");
		for (Cart cart : list) {
			cart.display();
			System.out.println("---------------------------------");
		}
		System.out.printf("TOTAL REVENUE: %,.2f", totalRevenue());
	}

	private static void cartCheckOut(Cart cart) {
		if (cart.getList().size() == 0) {
			System.out.println("\t You haven't bought any product!");
			return;
		}
		System.out.println("\n====CART CHECKOUT====");
		System.out.println(" 1. I have a customer ID");
		System.out.println(" 2. I haven't registered for a customer ID");
		System.out.println("Your choice :");
		int chon = Integer.parseInt(sc.nextLine());

		switch (chon) {
		case 1:
			System.out.println("\tEnter your ID :");
			int idk = Integer.parseInt(sc.nextLine());
			int index1 = CustomerManagement.indexOfId(idk);
			if (index1 != -1) {
				cart.setIDKH(idk);
			} else {
				System.out.println("Customer ID doesn't exist!");
				SalesManagement.cartCheckOut(cart);
			}
			cart.setID(autoNumber++);
			System.out.println();
			cart.display();
			System.out.println("\tThanks for visiting our store ! See you again !");
			for (SaleProduct x : cart.getList()) {
				int index = ProductManagement.indexOfId(x.getID());
				if (index == -1) {
					System.out.println("\tData access error! ");
					return;
				}
				ProductManagement.getList().get(index)
						.setAmount(ProductManagement.getList().get(index).getAmount() - x.getAmount());
			}
			list.add(cart);
			break;

		case 2:
			System.out.println("\tYour customer ID will be: " + CustomerManagement.autoNumber);
			cart.setIDKH(CustomerManagement.autoNumber);
			CustomerManagement.add();
			cart.setID(autoNumber++);
			System.out.println();
			cart.display();
			System.out.println("\tThanks for visiting our store ! See you again !");
			for (SaleProduct x : cart.getList()) {
				int index = ProductManagement.indexOfId(x.getID());
				if (index == -1) {
					System.out.println("\tData access error! ");
					return;
				}
				ProductManagement.getList().get(index)
						.setAmount(ProductManagement.getList().get(index).getAmount() - x.getAmount());
			}
			list.add(cart);
			break;
		default:
			System.out.println("Choice is invalid");
		}
		return;
	}

	public static int indexOfId(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID() == id) {
				return i;
			}
		}
		return -1;
	}

	public static ArrayList<Cart> getList() {
		return list;
	}

	public static void setList(ArrayList<Cart> list) {
		SalesManagement.list = list;
	}

}
