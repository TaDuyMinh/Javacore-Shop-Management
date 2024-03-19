package shop.UpdateManagement.ProductUpdateManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import shop.UpdateManagement.ProductTypeUpdateManagement.ProductTypeManagement;
import shop.UpdateManagement.ProviderUpdateManagement.ProviderManagement;

public class ProductManagement {
	static Scanner sc = new Scanner(System.in);
	private static ArrayList<Product> list = new ArrayList<>();

	public static ArrayList<Product> getList() {
		return list;
	}

	public static void setList(ArrayList<Product> list) {
		ProductManagement.list = list;
	}

	public static int autoNumber = 1001;

	public static void init() {
		list.add(new Product(autoNumber++, 101, 101, "Son BBIA", 82, 200000));
		list.add(new Product(autoNumber++, 102, 101, "Nuoc tay trang ABC", 23, 150000));
		list.add(new Product(autoNumber++, 103, 101, "Dau goi dau H&S", 50, 180000));
		list.add(new Product(autoNumber++, 101, 101, "Duong toan than SB", 100, 300000));
		list.add(new Product(autoNumber++, 101, 102, "Thot nhua", 200, 80000));
		list.add(new Product(autoNumber++, 102, 102, "Tu lanh Panasonic", 5, 20000000));
		list.add(new Product(autoNumber++, 103, 102, "Bep dien", 12, 1200000));
		list.add(new Product(autoNumber++, 103, 103, "Dien thoai Samsung", 120, 7000000));
		list.add(new Product(autoNumber++, 103, 103, "Tivi LG", 20, 15000000));
		list.add(new Product(autoNumber++, 102, 103, "May tinh Alienware", 10, 37000000));

	}

	public static void productManagement() {
		do {
			System.out.println("\n------PRODUCT INFORMATION MANAGEMENT------");
			System.out.println("\t1. Add new product");
			System.out.println("\t2. Update product information");
			System.out.println("\t3. Delete product");
			System.out.println("\t4. Sort product name by alphabetical order");
			System.out.println("\t5. View product list");
			System.out.println("\t0. Go back");
			System.out.println("Your choice: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
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
				System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}

	private static void add() {
		System.out.println("\n----Add new product-----");
		System.out.println("\t Enter product type ID:");
		int idlh = Integer.parseInt(sc.nextLine());
		if (ProductTypeManagement.indexOfId(idlh) == -1) {
			System.out.println("Product type ID does not exist!");
			return;
		}
		System.out.println("\t Enter provider ID:");
		int idPro = Integer.parseInt(sc.nextLine());
		if (ProviderManagement.indexOfId(idPro) == -1) {
			System.out.println("Provider ID does not exist!");
			return;
		}
		System.out.print("\t Enter new product name");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("\t Product name cannot be empty!");
			return;
		}
		if (nameIsExist(name) != -1) {
			System.out.println("\r Product name already exists! ");
			return;
		}
		System.out.println("\t Enter product amount: ");
		double amount = Double.parseDouble(sc.nextLine());
		if (amount < 0) {
			System.out.println("Product amount is not valid!");
			return;
		}
		System.out.println("\t Enter product price");
		double price = Double.parseDouble(sc.nextLine());
		if (price < 0) {
			System.out.println("Product price is not valid!");
			return;
		}
		list.add(new Product(autoNumber++, idlh, idPro, name, amount, price));
		System.out.println("\t Product was added successfully");
	}

	private static void update() {
		System.out.println("\n -----UPDATE PRODUCT INFORMATION-----");
		System.out.println("\tEnter product ID: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfId(id);
		if (index == -1) {
			System.out.println("Product ID does not exist in the list!");
			return;
		}
		list.get(index).update();

	}

	private static void remove() {
		System.out.println("\n -----MOVE PRODUCT-----");
		System.out.println("\tEnter product ID: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfId(id);
		if (index == -1) {
			System.out.println("Product ID does not exist in the list!");
			return;
		}
		list.remove(index);
		System.out.println("Delete successfully!");
	}

	private static void sort() {
		Collections.sort(list, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
		});
	}

	private static void display() {
		System.out.println("\n-----PRODUCT LIST-----");
		System.out.printf("%8s %-15s %-15s %-30s %-15s %-20s\n\n", "ID", "Provider", "Type", "Name", "Amount", "Price");
		for (

		Product x : list) {
			x.display();
		}
	}

	public static int nameIsExist(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().trim().compareToIgnoreCase(name.trim()) == 0) {
				return i;
			}
		}
		return -1;
	}

	public static int indexOfId(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID() == id) {
				return i;
			}
		}
		return -1;
	}

	public static String getName(int id) {
		for (Product x : list) {
			if (x.getID() == id) {
				return x.getName();
			}
		}
		return null;
	}

	public static Product getProduct(int id) {
		for (Product x : list) {
			if (x.getID() == id) {
				return x;
			}
		}
		return null;
	}
}
