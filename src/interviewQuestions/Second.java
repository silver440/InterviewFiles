package interviewQuestions;

import java.io.BufferedReader;
import java.util.Scanner;

import javax.imageio.ImageTranscoder;

import org.apache.poi.hslf.dev.SlideAndNotesAtomListing;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;

public class Second {
  public static Scanner scan;
private static String string2;
	public static void main(String[] args) {
			System.out.println("Enter the input string ");
	scan=new Scanner(System.in);
//	getReversed();
	getReversed2();
	//getReversed3();
 
	System.out.println(reverseString(string2));
	}
	
	  
	public static void getReversed() {
		String st="";
	
	 String st1=scan.nextLine();
//	  char [] c=st.toCharArray();
	 for(int i=st1.length()-1; i>=0; i--) {
		 st=st+st1.charAt(i);
	
	 }
			 System.out.println(st);
	}	
public static void getReversed2() {
	String string=scan.nextLine();
	StringBuilder input1=new StringBuilder(string );
	String string2=input1.reverse().toString();
	System.out.println(string2);
	
		
		
	}
public static void getReversed3() {
	String string=scan.nextLine();
StringBuilder bd=new StringBuilder(string);
// bd=bd.append(string);
bd=bd.reverse();
  System.out.println(bd);



 
} 	
public  static String reverseString (String string) {
	 String string1="Eliya";
	System.out.println(string1);
	  if(string1.isEmpty())
		  return string1;
	//  
	 System.out.println();
	  return reverseString(string1.substring(1))+string1.charAt(0);
}
 
}

	


