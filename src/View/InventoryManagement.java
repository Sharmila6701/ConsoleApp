package View;


	import java.util.List;
	import java.util.Scanner;

	import Model.Product;
	import viewmodel.InventoryViewModel;

	public class InventoryManagement {
	    public static void main(String[] args) {
	        InventoryViewModel viewModel = new InventoryViewModel();
	        Scanner sc = new Scanner(System.in);
	        int item;

	        do {
	            System.out.println("---Inventory Management System---\n");
	            System.out.println("1. Add new Item");
	            System.out.println("2. Search Item");
	            System.out.println("3. Display all Item");
	            System.out.println("4. Update Item ");
	            System.out.println("5. Remove Item ");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice : ");

	            item = sc.nextInt();
	            switch (item) {
	                case 1:
	                    System.out.println();
	                    System.out.print("Enter Item no : ");
	                    int no = sc.nextInt();
	                    System.out.print("Enter Item name : ");
	                    String name = sc.next();
	                    viewModel.addProduct(name, no);
	                    System.out.println("Item added successfully!\n");
	                    break;
	                case 2:
	                    System.out.println("--Search Item--");
	                    System.out.println("1. Search by Item Number");
	                    System.out.println("2. Search by Item Name");
	                    System.out.print("Enter your choice: ");
	                    int searchChoice = sc.nextInt();
	                    switch (searchChoice) {
	                        case 1:
	                            System.out.print("Enter Item Number to search: ");
	                            int searchItemNo = sc.nextInt();
	                            Product foundByNo = viewModel.findProductByNo(searchItemNo);
	                            if (foundByNo != null) {
	                                System.out.println("Item found: " + foundByNo+"\n");
	                            } else {
	                                System.out.println("Item not found!");
	                            }
	                            break;
	                        case 2:
	                            System.out.print("Enter Item Name to search: ");
	                            String searchItemName = sc.next();
	                            Product foundByName = viewModel.findProductByName(searchItemName);
	                            if (foundByName != null) {
	                                System.out.println("Item found: " + foundByName+"\n");
	                            } else {
	                                System.out.println("Item not found!");
	                            }
	                            break;
	                        default:
	                            System.out.println("Invalid choice!");
	                            break;
	                    }
	                    break;
	                case 3:
	                    System.out.println("--Display all Item--\n");
	                    List<Product> allProducts = viewModel.getAllProducts();
	                    if (!allProducts.isEmpty()) {
	                        for (Product p : allProducts) {
	                            System.out.println(p + "\n");
	                        }
	                    } else {
	                        System.out.println("No items in inventory!\n");
	                    }
	                    break;
	                case 4:
	                    System.out.println("--Update Item--");
	                    System.out.print("Enter Item Number to update: ");
	                    int updateItemNo = sc.nextInt();
	                    System.out.print("Enter new Item Name: ");
	                    String newName = sc.next();
	                    boolean isUpdated = viewModel.updateProduct(updateItemNo, newName);
	                    if (isUpdated) {
	                        System.out.println("Item details updated!");
	                    } else {
	                        System.out.println("Item not found!");
	                    }
	                    break;
	                case 5:
	                    System.out.println("--Remove Item--");
	                    System.out.println("Enter Item no");
	                    int removeItemNo = sc.nextInt();
	                    boolean isRemoved = viewModel.removeProduct(removeItemNo);
	                    if (isRemoved) {
	                        System.out.println("Item removed successfully");
	                    } else {
	                        System.out.println("Item not found");
	                    }
	                    break;
	                case 6:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice!");
	                    break;
	            }
	        } while (item != 6);
	    }
	}

