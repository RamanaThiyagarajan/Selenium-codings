import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaPractise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {1,2,3,4,5,6,7,8,9,10,122};
		
		//Print the values which are divisible by 2 from the array 	
		
		for (int i=0; i<arr.length;i++)
		{
			if (arr[i] % 2 == 0	)
			{
				System.out.println(arr[i]);
			}
			
			else
			{
				System.out.println(arr[i] + " is not multiple of 2");
			}
			
		}
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Ramana");
		a.add("Automation Testing");
		a.add("Devops");
		a.add("Selenium");
		//a.remove("")- This will remove the element from the string
		//a.add("")- This will Add to the String
		//a.get(Index)-This will get the required element in the Array list
		//a.contains("name")- This will check whether the element is present in Array Lists by returning True/False
		System.out.println(a.get(3));                                                                                              
		//Note- For normally array we will use length method to determine the total elements in the Array but in the Array List we will use size method
		for (String val: a)
		{
			System.out.println(val);
		}
		
		String[] name = {"Ramana", "Automation Testing", "Selenium"};
		List<String> nameArrayLists= Arrays.asList(name);
		//nameArrayLists.add("Jenkins");
		System.out.println(nameArrayLists.contains("Automation"));
		
	}

}
