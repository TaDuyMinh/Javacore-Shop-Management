package shop.UpdateManagement.ProviderUpdateManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class ProviderManagement {
	static Scanner sc = new Scanner(System.in);
	private static ArrayList<Provider> list = new ArrayList<>();

	public static ArrayList<Provider> getList() {
		return list;
	}

	public static void setList(ArrayList<Provider> list) {
		ProviderManagement.list = list;
	}

	public static int autoNumber = 101;

	public static void init() {
		list.add(new Provider(autoNumber++, "Vinmart", "13 Nguyen Xien"));
		list.add(new Provider(autoNumber++, "CoopMart", "12 Thang Long"));
		list.add(new Provider(autoNumber++, "BigC", "Ngo 213 Trinh Van Bo"));
	}

	public static void providerManagement() {
		do {
			System.out.println("\n------provider MANAGEMENT MENU------");
			System.out.println("Choose a function: ");
			System.out.println("\t1. Add new provider");
			System.out.println("\t2. Update provider's information");
			System.out.println("\t3. Delete provider's information");
			System.out.println("\t4. Sort provider names by alphabetical order");
			System.out.println("\t5. View provider list");
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

	private static void add() {
		System.out.println("\n----ADD NEW provider-----");
		System.out.print("\t Enter provider's name: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("\t Name cannot be empty !");
			return;
		}
		System.out.print("\t Enter provider's address: ");
		String address = sc.nextLine();
		if (address.trim().length() == 0) {
			System.out.println("\t Address cannot be empty !");
			return;
		}
		list.add(new Provider(autoNumber++, name, address));
		System.out.println("\t Provider was added succesfully!");
	}

	private static void update() {
		System.out.println("\n -----UPDATE PROVIDER INFORMATION-----");
		System.out.println("\tEnter provider's ID: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfId(id);
		if (index == -1) {
			System.out.println("Provider does not exist! ");
			return;
		}
		list.get(index).update();
		System.out.println("Provider's information was updated succesfully! ");
	}

	private static void remove() {
		System.out.println("\n -----DELETE PROVIDER INFORMATION-----");
		System.out.println("\tEnter provider's ID: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfId(id);
		if (index == -1) {
			System.out.println("Provider does not exist!");
			return;
		}
		list.remove(index);
		System.out.println("Provider was deleted succesfully! ");

	}

	private static void sort() {
		Collections.sort(list, new Comparator<Provider>() {
			@Override
			public int compare(Provider o1, Provider o2) {
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
		});
		System.out.println("List is sorted!");
	}

	private static void display() {
		System.out.println("\n-----PROVIDER LIST-----");
		System.out.printf("%-5s %-30s %-30s\n", "ID", "Name", "Address");
		for (Provider x : list) {
			x.display();
		}

	}

	public static int indexOfId(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID() == id) {
				return i;
			}
		}
		return -1;
	}

	public static int addressIsExist(String address) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAddress().trim().compareToIgnoreCase(address.trim()) == 0) {
				return i;
			}
		}
		return -1;
	}
	public static String getName(int id) {
		for(Provider x  : list) {
			if(x.getID()==id) {
				return x.getName();
			}
		}
		return null;
	}
}
