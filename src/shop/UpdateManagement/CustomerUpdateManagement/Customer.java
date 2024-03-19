package shop.UpdateManagement.CustomerUpdateManagement;

import java.util.Scanner;

public class Customer {
	private int ID;
	private String name;
	private String phone;
	static Scanner sc = new Scanner(System.in);

	public void display() {
		System.out.printf("%-5d %-25s %-12s\n", this.ID, this.name, this.phone);
	}

	public void update() {
		do {
			System.out.println("Choose information to be updated");
			System.out.println("\t1. Customer's name");
			System.out.println("\t2. Customer's phone number");
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
				System.out.print("\tEnter new phone number: ");
				String phone = sc.nextLine();
				if (phone.trim().length() == 0) {
					System.out.println("\t Phone number is not valid ! ");
					return;
				}
				if (CustomerManagement.phoneIsExist(phone) != -1) {
					System.out.println("Phone number already exists! ");
					return;
				}
				this.phone = phone;
				System.out.println("Phone number was updated successfully");
				break;

			case 0:
				return;
			default:
				System.out.println("Choice is invalid! ");
			}
		} while (true);
	}

	public Customer(int iD, String name, String phone) {
		super();
		ID = iD;
		this.name = name;
		this.phone = phone;
	}

	public Customer() {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
