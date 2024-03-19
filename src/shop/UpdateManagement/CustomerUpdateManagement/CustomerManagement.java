package shop.UpdateManagement.CustomerUpdateManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CustomerManagement {
	static Scanner sc = new Scanner(System.in);
	private static ArrayList<Customer> list = new ArrayList<>();

	public static ArrayList<Customer> getList() {
		return list;
	}

	public static void setList(ArrayList<Customer> list) {
		CustomerManagement.list = list;
	}

	public static int autoNumber = 101;

//	public static void init() {
//		list.add(new Customer(autoNumber++, "Ta Duy Minh", "0194375111"));
//		list.add(new Customer(autoNumber++, "Ta Doan Linh", "022265222"));
//		list.add(new Customer(autoNumber++, "Ta Doanh King", "0333213213"));
//		list.add(new Customer(autoNumber++, "Dao Cong Minh", "0543213213"));
//		list.add(new Customer(autoNumber++, "Dao Cong Anh", "0334236713"));
//
//	}

	public static void customerManagement() {
		do {
			System.out.println("\n------CUSTOMER MANAGEMENT MENU------");
			System.out.println("Choose a function: ");
			System.out.println("\t1. Add new customer");
			System.out.println("\t2. Update customer's information");
			System.out.println("\t3. Delete customer's information");
			System.out.println("\t4. Sort customer names by alphabetical order");
			System.out.println("\t5. View customer list");
			System.out.println("\t0. Go back");
			System.out.println("Your choice: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				add();
				break;
			case 2:
				update();
				break;
			case 3:
				remove();
				break;
			case 4:
				sort();
				break;
			case 5:
				display();
				break;
			case 0:
				return;
			default:
				System.out.println("Choice is invalid!");
			}
		} while (true);
	}

	public static void add() {
		System.out.println("\n----ADD NEW CUSTOMER-----");
		System.out.print("\t Enter customer's name: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("\t Name cannot be empty !");
			return;
		}
		System.out.print("\t Enter customer's phone number: ");
		String phone = sc.nextLine();
		if (phone.trim().length() == 0) {
			System.out.println("\t Phone number cannot be empty !");
			return;
		}
		if (CustomerManagement.phoneIsExist(phone) != -1) {
			System.out.println("\t Phone number already exists !");
			return;
		}
		list.add(new Customer(autoNumber++, name, phone));
		System.out.println("\t Customer was added succesfully!");
	}

	private static void update() {
		System.out.println("\n -----UPDATE CUSTOMER INFORMATION-----");
		System.out.println("\tEnter customer's ID: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfId(id);
		if (index == -1) {
			System.out.println("Customer does not exist! ");
			return;
		}
		list.get(index).update();
		System.out.println("Customer's information was updated succesfully! ");
	}

	private static void remove() {
		System.out.println("\n -----DELETE CUSTOMER INFORMATION-----");
		System.out.println("\tEnter customer's ID: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfId(id);
		if (index == -1) {
			System.out.println("Customer does not exist!");
			return;
		}
		list.remove(index);
		System.out.println("Customer was deleted succesfully! ");
	}

	private static void sort() {
		Collections.sort(list, new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
		});
		System.out.println("List is sorted!");

	}

	private static void display() {
		System.out.println("\n-----CUSTOMER LIST-----");
		System.out.printf("%-5s %-25s %12s\n", "ID", "Name","Phone number");
		for (Customer x : list) {
			x.display();
		}

	}

//	public static int nameIsExist(String name) {
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getName().trim().compareToIgnoreCase(name.trim()) == 0) {
//				return i;
//			}
//		}
//		return -1;
//	}
	public static int indexOfId(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID() == id) {
				return i;
			}
		}
		return -1;
	}

	public static int phoneIsExist(String phone) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPhone().trim().compareToIgnoreCase(phone.trim()) == 0) {
				return i;
			}
		}
		return -1;
	}
	public static String getName(int id) {
		for(Customer x  : list) {
			if(x.getID()==id) {
				return x.getName();
			}
		}
		return null;
	}

}
