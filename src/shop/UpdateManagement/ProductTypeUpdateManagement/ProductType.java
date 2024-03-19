package shop.UpdateManagement.ProductTypeUpdateManagement;

import java.util.Scanner;


public class ProductType {
	static Scanner sc = new Scanner(System.in);
	private int ID;
	private String name;
	private String description;

	public void display() {
		System.out.printf("%5d %-15s %-30s\n", this.ID, this.name, this.description);
	}
	public void update() {
		do {
			System.out.println("Choose information to be updated");
			System.out.println("\t1. Product type's name");
			System.out.println("\t2. Product type's description");
			System.out.println("\t0. Go back.");

			System.out.println("Your choice");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				System.out.print("\tEnter new name: ");
				String name = sc.nextLine();
				if (name.trim().length() == 0) {
					System.out.println("\t Name cannot be empty ! ");
					return;
				}
				if (ProductTypeManagement.nameIsExist(name) != -1) {
					System.out.println("\t Product type already exists !");
					return;
				}
				this.name = name;
				System.out.println("Name was updated successfully.");
				break;
			case 2:
				System.out.print("\tEnter new description: ");
				String des = sc.nextLine();
				if (des.trim().length() == 0) {
					System.out.println("\t Description cannot be empty ! ");
					return;
				}
				this.description = des;
				System.out.println("Description was updated successfully");
				break;

			case 0:
				return;
			default:
				System.out.println("Choice is invalid! ");
			}
		} while (true);
	}
	public ProductType(int iD, String name, String description) {
		super();
		ID = iD;
		this.name = name;
		this.description = description;
	}

	public ProductType() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
