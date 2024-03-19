package shop.SalesManagement;

import shop.UpdateManagement.ProductUpdateManagement.Product;
import shop.UpdateManagement.ProductUpdateManagement.ProductManagement;

public class SaleProduct {
	private int IDH;
	private double amount;

	public void display() {
		Product x = ProductManagement.getProduct(IDH);
		System.out.printf("%-25s %-8.2f %-,15.2f %-,15.2f\n", x.getName(), this.amount, x.getPrice(), this.cost());
	}

	public double cost() {
		Product x = ProductManagement.getProduct(IDH);
		return amount * x.getPrice();
	}

	public SaleProduct() {
		super();
	}

	public SaleProduct(int iD, double amount) {
		super();
		IDH = iD;
		this.amount = amount;
	}

	public int getID() {
		return IDH;
	}

	public void setID(int iD) {
		IDH = iD;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
