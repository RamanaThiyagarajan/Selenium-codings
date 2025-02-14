import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams1 {
  //@Test
 public void Regular() {
		
		//Stream is nothing but collection of strings
		ArrayList<String> names = new ArrayList<String>();
		names.add("Ramana");
		names.add("Anandh");
		names.add("Aravin");
		names.add("Vaishu");
		names.add("Akhil");
        int count=0;
		for(int i=0; i<names.size();i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count);
 }
	//	@Test
 public void streamFilter	() {

			
			 
			 ArrayList<String> names = new ArrayList<String>();
				names.add("Ramana");
				names.add("Anandh");
				names.add("Aravin");
				names.add("Vaishu");
				names.add("Akhil");
		 
		Long c= names.stream().filter(s->s.startsWith("A")).count(); //Data type of count
		System.out.println(c);
		
		long d= Stream.of("Ramana","Anandh","Aravin","Vaishu","Akhil").filter(s->
		{
			s.startsWith("A");
			return true;
		}).count();
		System.out.println(d);
		
		//print all the names of Array list
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
	}

//@Test
public void streamMap() {
	ArrayList<String> names = new ArrayList<String>();
	names.add("man");
	names.add("Don");
	names.add("women");
	
	//print names which have last letter "a" with Uppercase
	Stream.of("Ramana","Anandh","Aravin","Vaishu","Akhila").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
//	print names which have first letter as uppercase and sorted
	List<String> names1= Arrays.asList("Ramana","Anandh","Aravin","Vaishu","Akhila");
	
	names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	//Merging 2 different lists
	Stream<String> newStream= Stream.concat(names.stream(), names1.stream());
	//newStream.sorted().forEach(s->System.out.println(s));
	boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Ramana"));
	System.out.println(flag);
	Assert.assertTrue(flag);
	
}
		
@Test
public void streamCollect() {
	
	List<String> ls= Stream.of("Ramana","Anandh","Aravin","Vaishu","Akhila").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
	System.out.println(ls.get(0));
	
	//Assignment- Create a List integers & Print the unique vaues
	//Sort the Array
	List<Integer> values =Arrays.asList(3,2,2,7,5,1,9,7);
	//values.stream().distinct().forEach(s->System.out.println(s));
	List<Integer> li =values.stream().distinct().sorted().collect(Collectors.toList());
	System.out.println(li.get(2));
	
}
}
