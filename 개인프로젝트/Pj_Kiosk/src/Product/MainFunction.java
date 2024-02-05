package Product;

import java.util.ArrayList;
import java.util.Scanner;

public class MainFunction {
	
	// 배열 추가는 public static void 쓰는 main 에서만 가능
	public static ArrayList<Product> drink = new ArrayList<Product>();
	public static ArrayList<Product> dessert = new ArrayList<Product>();
	public static ArrayList<Product> drink_B = new ArrayList<Product>();
	public static ArrayList<Product> dessert_B = new ArrayList<Product>();
	public static ArrayList<Product> Cafe_T = new ArrayList<Product>();
	
	public static Scanner sc = new Scanner(System.in);
	public static String cmd;
	public static int order = 0;
	
	public static void DrinkLoad() {
		//음료수
		drink.add(new DrinkData("뜨거운 아메리카노", 1000, 0));
		drink.add(new DrinkData("아이스 아메리카노", 1500, 0));
		drink.add(new DrinkData("오렌지 쥬스", 2000, 0));
	}
	
	public static void DessertLoad() {
		//디저트
		dessert.add(new DessertData("마카롱", 1000, 0));
		dessert.add(new DessertData("치즈 케이크", 3500, 0));
		dessert.add(new DessertData("약과 샌드", 4000, 0));
	}
}
