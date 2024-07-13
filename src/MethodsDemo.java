
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MethodsDemo d = new MethodsDemo();
		String name = d.getData();
		System.out.println(name);
		MethodsName2 d2 = new MethodsName2();
		d2.getuserData();
		getData2();
		

	}
	
	public String getData() {
		
		System.out.println("Hello World");
		return "Rahul Shetty"; 

}

public static String getData2() { //If static is used, We can call the method Directly like in line number 13
	
	System.out.println("Hello World");
	return "rahul shetty";
}
}
