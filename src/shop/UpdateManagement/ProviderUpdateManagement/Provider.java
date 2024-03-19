package shop.UpdateManagement.ProviderUpdateManagement;

import java.util.Scanner;

public class Provider {
	static Scanner sc = new Scanner(System.in);
	private int ID;
	private String name;
	private String address;

	public void display() {
		System.out.printf("%-5d %-30s %-30s\n", this.ID, this.name, this.address);
	}

	public void update() {
		do {
			System.out.println("Choose information to be updated");
			System.out.println("\t1. Provider's name");
			System.out.println("\t2. Provider's address");
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
				this.name = name;
				System.out.println("Name was updated successfully.");
				break;
			case 2:
				System.out.print("\tEnter new address: ");
				String address = sc.nextLine();
				if (address.trim().length() == 0) {
					System.out.println("\t Address is not valid ! ");
					return;
				}
				this.address = address;
				System.out.println("Address was updated successfully");
				break;

			case 0:
				return;
			default:
				System.out.println("Choice is invalid! ");
			}
		} while (true);
	}

	public Provider(int iD, String name, String address) {
		super();
		ID = iD;
		this.name = name;
		this.address = address;
	}

	public Provider() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
