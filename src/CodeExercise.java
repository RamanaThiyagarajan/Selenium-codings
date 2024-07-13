
public class CodeExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] numbers = {1,2,3,4,5};
	    
	    System.out.println("The first element of the array is "+ numbers[0]);
	    System.out.println("The last element of the array is "+ numbers[4]);
	    
	    for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }
	    
	    int totalElements = numbers.length;
	    System.out.println(totalElements + " is the total number of elements");
	}

}
