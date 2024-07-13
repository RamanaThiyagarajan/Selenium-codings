abstract class Computer{
	
	abstract void turnOff();
	
	void turnOn() {
		System.out.println("Turning On");
	}
}

class HP extends Computer{
	
	void turnOn(){
		System.out.println("Turning On-HP");
	}
	void turnOff() {
		System.out.println("Turning Off- HP");
	}
}

class Dell extends Computer{
	
	void turnOn(){
		System.out.println("Turning On-Dell");
	}
	void turnOff() {
		System.out.println("Turning Off- Dell");
	}
}

class Abstract {
	public static void main(String[] args) {
		
		HP ob = new HP();
		ob.turnOn();
		ob.turnOff();
		
		Dell ob1 = new Dell();
		ob1.turnOn();
		ob1.turnOff();
	}
}