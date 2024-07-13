
public class JavaPractice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// String is an Object that represents the sequences of Charcters
		//String Literal
	//	String s = "Rahul shetty Academy";
	//	String s1 = "Rahul shetty Academy";
		
		//Declaring String using New Allocator		
		String s1 = new String ("Welcome");
		String s2 = new String ("Welcome");
		
		//Iterate the Characters in the String
		
		String s = "Rahul shetty Academy";
		//Split with Space
//		String[] splittedString= s.split(" ");
//		System.out.println(splittedString[0]);
//		System.out.println(splittedString[1]);
//		System.out.println(splittedString[2]);
		
		//Split with word in the String
		String[] splittedString= s.split("shetty");
		System.out.println(splittedString[0].trim());
		System.out.println(splittedString[1].trim());
		
		//Print the String in Character wise
		
		for(int i=0; i<s.length();i++)
		{
			System.out.println(s.charAt(i));
		}
		
		//Print the String in Reverse Order character wise
		
		for (int i=s.length()- 1; i>=0; i--)
		{
			System.out.println(s.charAt(i));
		}
		
		
		//Print the String in Reverse Order Sentence wise
//		String reversed = "";
//
//		for (int i=s.length()- 1; i>=0; i--)
//		{
//			reversed += s.charAt(i);
//			System.out.println(reversed);
//		}
		
		// Using StringBuilder to reverse the string
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();
        
        // Printing the reversed string
        System.out.println(reversed);
    }
		
	}

