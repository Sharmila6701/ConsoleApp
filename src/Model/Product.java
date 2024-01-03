package Model;

public class Product {
	private int no;
	private String name;

	public Product(String name, int no) {
		this.name = name;
		this.no = no;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getName() {
		return name;
	}

	public int getNo() {
		return no;
	}

	@Override
	public String toString() {
		return no + " " + name;
	}
}
