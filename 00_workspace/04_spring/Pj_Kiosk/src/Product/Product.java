package Product;

public class Product {
	//변수들
	public String name;
	public int price;
	public int quantity;
	
	public Product(String xx, int yy, int zz) {
		name = xx;
		price = yy;
		quantity = zz;
	}
	
	public void info() {
		System.out.println("메뉴이름 : " + name + ", 가격 : " + price + "원");
	}
}
