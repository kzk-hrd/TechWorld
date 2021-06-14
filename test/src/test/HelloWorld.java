package test;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		System.out.println("Hello World");
		
		List<String> a = new ArrayList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		for(int i=0; i<a.size(); i++) {
			System.out.println(a.get(i));
		}

	}

}
