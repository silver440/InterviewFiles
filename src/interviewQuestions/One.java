package interviewQuestions;

import java.io.StringReader;
import java.nio.file.attribute.AclEntryFlag;
import java.util.Arrays;
import java.util.Scanner;

public class One {
	public static void main(String[] args) {
     
//    Scanner scanner=new Scanner(System.in);
//	    System.out.println("please enter the reversible string");
//	     String st1=scanner.nextLine();
//     
//		 String reversedString= getFirstStringReverse(st1);
//	 System.out.println("after reversed: "+reversedString);
//
//        System.out.println("please enter the plandrome string");
//        String st2=scanner.nextLine();
//     
////	boolean a=plandromeString(s);
////System.out.println(a);
//   
//    if(plandromeString(st2)) {
//  	 System.out.println(st2+":is plandrome string");
//     }else {
//  	 System.out.println(st2+":is not plandrome string");
//    }
//    System.out.println("Please enter the number ");
//	  int number=scanner.nextInt();
//if(isPlandromeNumber(number)) {
//	System.out.println(number+ ": is plandrome number");
//	}else {
//		System.out.println(number+ ":is not plandrome number");
//	}
//		removingDuplicate("Mothorlem");
		fizzBuzz();
	}
		
	 
	public static  String getFirstStringReverse(String st) {
		//String name="Welcometo ";
		System.out.println("original string is:"+st);
		String revS="";
		for(int i=st.length()-1; i>=0; i--) {
			revS=revS+st.charAt(i);
		}
	
		return revS;
		
	}
	public static boolean plandromeString( String s) {
		boolean ans=false;
		String orgString="";
		for(int i=s.length()-1; i>=0; i--) {
	      orgString=orgString+s.charAt(i);
	      if(s.equalsIgnoreCase(orgString)) {
	    	  System.out.println("String is plandrome ");
	    	  ans=true;
	      }
	      
		}
	
		return ans;
		
		
		
		
	}
	public static boolean isPlandromeNumber(int n) {
		int tempN=n;  int rev=0;
		while(n!=0) {
			int remainder=n%10;
			rev=rev*10+remainder;
			n=n/10;
			
		}
		if(rev==tempN) {
	//		System.out.println("sum is:"+rev);
		
		return true;
			
		}
	return false;
		
		
	}
	public static void removingDuplicate( String st) {
		int j;  int count=0;
		char[] chars=st.toCharArray();
		for(int i=0; i<chars.length; i++) {
			for(j=0; j<i; j++	) {
			if(chars[i]==chars[j]) {
		  //   break;
			chars[j]++	;
			}
				
			}
			if(j==i) {
				chars[count++]=chars[j];
			
			}
	
		}
	
	//	System.out.println(String.valueOf(Arrays.copyOf(chars, count)));
	}
	public static void fizzBuzz() {
		int num =50;
		for(int i=0; i<=num; i++) {
			if(i%3==0) {
		System.out.println("this numbers are fizz "+i);
			}
		}
		
	}
}