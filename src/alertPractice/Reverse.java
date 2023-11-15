package alertPractice;

public class Reverse {

	public static void main(String[] args) {
	  ReverseString("Dalalama");

	}
	 public static void ReverseString(String st) {
		 String orgString=st;
		 
		 String tempString="";
		 for(int i=orgString.length()-1; i>=0; i--) {
			 tempString=tempString+orgString.charAt(i);
			 
		 }if(tempString.equalsIgnoreCase(orgString)) {
			 System.out.println("is palindrome");
		 }else {
			 System.out.println("is not palindrome");
		 }
		// System.out.println("reversed strting:"	+tempString);
	 }    

} 
