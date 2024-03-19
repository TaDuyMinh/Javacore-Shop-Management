package shop.SalesManagement;

import java.util.ArrayList;
import java.util.Scanner;

import shop.UpdateManagement.CustomerUpdateManagement.CustomerManagement;
import shop.UpdateManagement.ProductUpdateManagement.ProductManagement;

public class Cart {
	static Scanner sc = new Scanner(System.in);
	private int ID;
	private int IDKH;
	private ArrayList<SaleProduct> list = new ArrayList<>();

	public void display() {
		System.out.println("\n-----YOUR CART-----");
		System.out.println("\t Cart ID: " + this.ID);
		System.out.println("\t Customer : " + CustomerManagement.getName(this.IDKH));
		System.out.println("\t Product list:");
		System.out.printf("%-25s %-8s %-15s %-15s\n", "Product name", "Amount", "Price", "Cost");
		double tt = 0;
		for (SaleProduct x : list) {
			x.display();
			tt += x.cost();
		}
		System.out.printf("\t Total cost: %,.2f\n", tt);
	}
	public double totalCost() {
		double total=0;
		for (SaleProduct x : list) {
			total += x.cost();
		}
		return total;
	}
	public void update() {
		System.out.println("Enter product ID: ");
		int idh = Integer.parseInt(sc.nextLine());
		int index2 = indexOfCart(idh);
		if (index2 != -1) {
			System.out.println("\tEnter new amount : ");
			double buyAmount = Double.parseDouble(sc.nextLine());
			if (buyAmount < 0) {
				System.out.println("\t Amount is not valid!");
				return;
			} else if (buyAmount == 0) {
				list.remove(index2);
				return;
			} else {
				int index1 = ProductManagement.indexOfId(idh);
				if (index1 == -1) {
					System.out.println("\t Data access error");
					return;
				}
				if (buyAmount > ProductManagement.getList().get(index1).getAmount()) {
					System.out.println("\t Product quantity limit exceeded !");
					return;
				}
				list.get(index2).setAmount(buyAmount);
				System.out.println("Product amount was changed successfully! ");
			}

		}
	}

	public void remove() {
		System.out.println("Enter product ID: ");
		int idh = Integer.parseInt(sc.nextLine());
		int index2 = indexOfCart(idh);
		if (index2 != -1) {
			list.remove(index2);
			System.out.println("Product was deleted successfully!");
		} else {
			System.out.println("Product does not exist in cart! ");
		}
	}

	public void add() {
		System.out.println("Enter product ID:");
		int idh = Integer.parseInt(sc.nextLine());
		int index1 = ProductManagement.indexOfId(idh);
		if (index1 == -1) {
			System.out.println("\t Product does not exist or ran out of stock !");
			return;
		}

		System.out.println("\tEnter amount: ");
		double buyAmount = Double.parseDouble(sc.nextLine());
		if (buyAmount <= 0) {
			System.out.println("\t Amount is invalid! ");
			return;
		}
		int index2 = indexOfCart(idh);
		if (index2 != -1) {
			buyAmount += list.get(index2).getAmount();

		}
		if (buyAmount > ProductManagement.getList().get(index1).getAmount()) {
			System.out.println("\tProduct quantity limit exceeded !");
			return;
		}
		if (index2 != -1) {
			list.get(index2).setAmount(buyAmount);
		} else {
			list.add(new SaleProduct(idh, buyAmount));
		}
	}

	public int indexOfCart(int idh) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID() == idh) {
				return i;
			}
		}
		return -1;
	}

	public Cart(int iD, int iDKH, ArrayList<SaleProduct> list) {
		super();
		ID = iD;
		IDKH = iDKH;
		this.list = list;
	}

	public Cart() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getIDKH() {
		return IDKH;
	}

	public void setIDKH(int iDKH) {
		IDKH = iDKH;
	}

	public ArrayList<SaleProduct> getList() {
		return list;
	}

	public void setList(ArrayList<SaleProduct> list) {
		this.list = list;
	}
}
