package shop.UpdateManagement.ProductTypeUpdateManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductTypeManagement {
	static Scanner sc = new Scanner(System.in);
	private static ArrayList<ProductType> list = new ArrayList<>();

	public static ArrayList<ProductType> getList() {
		return list;
	}

	public static void setList(ArrayList<ProductType> list) {
		ProductTypeManagement.list = list;
	}

	public static int autoNumber = 101;

	public static void init() {
		list.add(new ProductType(autoNumber++, "Thoi Trang", "Danh cho phu nu"));
		list.add(new ProductType(autoNumber++, "Gia dung", "Do gia dung gia re"));
		list.add(new ProductType(autoNumber++, "Cong nghe", "Nhung san pham cong nghe doi moi nhat"));
	}

	public static void productTypeManagement() {
		do {
			System.out.println("\n------PRODUCT TYPE MANAGEMENT MENU------");
			System.out.println("Choose a function: ");
			System.out.println("\t1. Add new product type");
			System.out.println("\t2. Update product type");
			System.out.println("\t3. Delete product type");
			System.out.println("\t4. Sort product types by alphabetical order");
			System.out.println("\t5. View product type list");
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
		System.out.println("\n----ADD NEW ProductType-----");
		System.out.print("\t Enter ProductType's name: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("\t Name cannot be empty !");
			return;
		}
		if (ProductTypeManagement.nameIsExist(name) != -1) {
			System.out.println("\t Product type already exists !");
			return;
		}
		System.out.print("\t Enter ProductType's description: ");
		String des = sc.nextLine();
		if (des.trim().length() == 0) {
			System.out.println("\t Description cannot be empty !");
			return;
		}
		
		list.add(new ProductType(autoNumber++, name, des));
		System.out.println("\t ProductType was added succesfully!");
	}

	private static void update() {
		System.out.println("\n -----UPDATE PRODUCT TYPE-----");
		System.out.println("\tEnter ProductType's ID: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfId(id);
		if (index == -1) {
			System.out.println("ProductType does not exist! ");
			return;
		}
		list.get(index).update();
		System.out.println("ProductType's information was updated succesfully! ");
	}

	private static void remove() {
		System.out.println("\n -----DELETE PRODUCT TYPE-----");
		System.out.println("\tEnter ProductType's ID: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfId(id);
		if (index == -1) {
			System.out.println("ProductType does not exist!");
			return;
		}
		list.remove(index);
		System.out.println("ProductType was deleted succesfully! ");
	}

	private static void sort() {
		Collections.sort(list, new Comparator<ProductType>() {
			@Override
			public int compare(ProductType o1, ProductType o2) {
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
		});
		System.out.println("List is sorted!");
	}

	private static void display() {
		System.out.println("\n-----PRODUCT TYPE LIST-----");
		System.out.printf("%-5s %-15s %-30s\n", "ID", "Name","Description");
		for (ProductType x : list) {
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
	public static int nameIsExist(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().trim().compareToIgnoreCase(name.trim()) == 0) {
				return i;
			}
		}
		return -1;
	}
	public static String getName(int id) {
		for(ProductType x  : list) {
			if(x.getID()==id) {
				return x.getName();
			}
		}
		return null;
	}
}
