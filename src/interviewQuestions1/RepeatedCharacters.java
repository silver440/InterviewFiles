package interviewQuestions1;

import java.util.Arrays;

public class RepeatedCharacters {

	public static void main(String[] args) {
		String string="Moulauadem";
		String string1=string.toLowerCase();
		boolean flag=true;
		char [] a=string1.toCharArray();
		for(int i=0; i<a.length; i++) {
			for(int y=0; y<a.length; y++) {
				if(a[i]==a[y]&& i!=y) {
					
			//		System.out.println((a[y]));
					flag=false;
					break;
				}
					if(flag) {
			
				}
		
			}
				System.out.println(a[i]);	
		}
		}

	}


