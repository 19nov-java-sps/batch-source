package types;

public class ArrayDriver 
{

	public static void main(String[] args) 
	{
		int[] intArr1 = new int[5];
		int[] intArry2 = new int[5];
		int[] intArr3 = {7,3,4,1};
		
		System.out.println( intArr3[2]);
		
		for ( int i=0; i<intArr3.length; i++ )
		{
			System.out.println( intArr3[i] + " ");
		}
		
		System.out.println();
		
		for ( int currentInt : intArr3) 
		{
			System.out.println( currentInt + " ");
		}
		
		int[][] int2DArr = new int[3][3];
		System.out.println();
		
		printAll();
		
		System.out.println();
		
		printAll("hello", "world", "cat", "dog");

	}
	
	public static void printAll(String... strArr)
	{
//		System.out.println(Arrays.toString(srtArr));
		for ( String str : strArr )
		{
			System.out.println( strArr + " ");
		}
		
	}

}
