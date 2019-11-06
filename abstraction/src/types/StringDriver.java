package types;

public class StringDriver {

	public static void main(String[] args) 
	{
		String string1 = "I'am a string";
		String string2 = "I'am a string";
		
		System.out.println("with equals "  + string1.contentEquals(string2));
		System.out.println("with == "  + (string1==string2));
		
		String alsoString1 = string1;
		string1 = string1 + "!";
		
		System.out.println(string1);
		System.out.println(alsoString1);
		
		System.out.println("with equals "  + string1.equals(alsoString1));
		System.out.println("with == "  + (string1==alsoString1));
		
		System.out.println("---------------------------------------");
		
		StringBuilder sb1 = new StringBuilder(" I'm stringbuilder object!");
		StringBuilder sb2 = new StringBuilder(" I'm stringbuilder object!");
		
		System.out.println("with == "  + (sb1==sb2));
		System.out.println("with equals " + sb1.toString().contentEquals(sb2.toString()));
		
		
		
		
		

				

		
	}

}
