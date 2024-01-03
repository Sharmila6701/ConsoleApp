package Repository;

	import Model.Product;

	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;

	public class InventoryRepository {
	    private List<Product> inventoryItems;

	    public InventoryRepository() {
	        this.inventoryItems = new ArrayList<>();
	    }

	    public void addProduct(Product product) {
	        inventoryItems.add(product);
	    }

	    public Product findProductByNo(int searchItemNo) {
	        for (Product prod : inventoryItems) {
	            if (prod.getNo() == searchItemNo) {
	                return prod;
	            }
	        }
	        return null;
	    }

	    public Product findProductByName(String searchItemName) {
	        for (Product prod : inventoryItems) {
	            if (prod.getName().equalsIgnoreCase(searchItemName)) {
	                return prod;
	            }
	        }
	        return null;
	    }

	    public List<Product> getAllProducts() {
	        return new ArrayList<>(inventoryItems);
	    }

	    public boolean updateProduct(int updateItemNo, String newName) {
	        for (Product prod : inventoryItems) {
	            if (prod.getNo() == updateItemNo) {
	                prod.setName(newName);
	                return true;
	            }
	        }
	        return false;
	    }

	    public boolean removeProduct(int removeItemNo) {
	        Iterator<Product> iterator = inventoryItems.iterator();
	        while (iterator.hasNext()) {
	            Product p = iterator.next();
	            if (p.getNo() == removeItemNo) {
	                iterator.remove();
	                return true;
	            }
	        }
	        return false;
	    }
	}




