package shop.UpdateManagement.ProductUpdateManagement;

import java.util.Scanner;

import shop.UpdateManagement.ProductTypeUpdateManagement.ProductTypeManagement;
import shop.UpdateManagement.ProviderUpdateManagement.ProviderManagement;

public class Product {
	static Scanner sc = new Scanner(System.in);
	private int ID;
	private int providerID;
	private int typeID;
	private String name;
	private double Amount;
	private double Price;

	public void display() {
		System.out.printf("%8d %-15s %-15s %-30s %,-15.1f %,-20.2f\n", this.ID,
				ProviderManagement.getName(this.providerID), ProductTypeManagement.getName(this.typeID), this.name,
				this.Amount, this.Price);

	}

	public void update() {
		do {
			System.out.println("Choose information that needs to be updated");
			System.out.println("\t1. Product type ID");
			System.out.println("\t2. Provider ID");
			System.out.println("\t3. Product name");
			System.out.println("\t4. Product amount");
			System.out.println("\t5. Product price");
			System.out.println("\t0. Go back");

			System.out.println("Your choice:");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				System.out.println("\t Enter new product type ID:");
				int idlh = Integer.parseInt(sc.nextLine());
				if (ProductTypeManagement.indexOfId(idlh) == -1) {
					System.out.println("Product type ID does not exist!");
					return;
				}
				this.setTypeID(idlh);
				System.out.println("Product type ID was updated successfully!");
				break;
			case 2:
				System.out.println("\t Enter new provider ID:");
				int ProID = Integer.parseInt(sc.nextLine());
				if (ProviderManagement.indexOfId(ProID) == -1) {
					System.out.println("Provider ID does not exist!");
					return;
				}
				this.setProviderID(ProID);
				System.out.println("Prodvider ID was updated successfully!");
				break;
			case 3:
				System.out.print("\t Enter new product name");
				String name = sc.nextLine();
				if (name.trim().length() == 0) {
					System.out.println("\t Product name cannot be empty!");
					return;
				}
				if (ProductManagement.nameIsExist(name) != -1) {
					System.out.println("\r Product name already exists! ");
					return;
				}
				this.setName(name);
				System.out.println("Product name was updated successfully!");
				break;
			case 4:
				System.out.println("\t Enter new product amount:");
				double amount = Double.parseDouble(sc.nextLine());
				if (amount < 0) {
					System.out.println("Product amount is not valid");
					return;
				}
				this.setAmount(amount);
				System.out.println("Product amount was updated successfully!");
				break;
			case 5:
				System.out.println("\t Enter new product price");
				double price = Double.parseDouble(sc.nextLine());
				if (price < 0) {
					System.out.println("Product price is not valid!");
					return;
				}
				this.setPrice(price);
				System.out.println("Product price was successfully updated!");
				break;
			case 0:
				return;
			default:
				System.out.println("Choice is invalid! ");
			}
		} while (true);
	}

	public Product() {
		super();
	}

	public Product(int iD, int providerID, int typeID, String name, double amount, double price) {
		super();
		ID = iD;
		this.providerID = providerID;
		this.typeID = typeID;
		this.name = name;
		Amount = amount;
		Price = price;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getProviderID() {
		return providerID;
	}

	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

}
