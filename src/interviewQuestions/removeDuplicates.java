package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.xml.transform.Source;

import org.apache.commons.math3.ode.ContinuousOutputFieldModel;
import org.apache.xmlbeans.impl.repackage.Repackage;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import net.bytebuddy.implementation.bytecode.assign.primitive.VoidAwareAssigner;

public class removeDuplicates {
	
	public static void main (String []arg) {
		removeDuplicates("molouma");
		removeDuplicate2("bbbcccddddeeee");
		removeDuplicate3("bubalambuelem");
		removeDuplicates4("bccdabbeellyy");
	}
	public static  void  removeDuplicates(String st) {
		 char [] ch=st.toCharArray();
		 
		 String st1="";
		   for(char value:ch) {
			   if(st1.indexOf(value)==-1) {
				   st1=st1+value;
				 
					
				}
			   
			}
			System.out.println("string before remove duplicates:"+st);
			System.out.println("String after remove the duplicates: "+st1);
			
		}
	public static void removeDuplicate2(String st) {
		String st2="";
		LinkedHashSet<Character>  ch=new LinkedHashSet<>();	
		for(int i=0; i<st.length(); i++) {
			ch.add(st.charAt(i));
			//for(Character a:ch) {
		
			}
				
			System.out.println(ch);
					
		
			}
		
	public static void removeDuplicate3(String st) {
		int i;
		
		char[] chars=st.toCharArray();
		 StringBuilder sBuilder=new StringBuilder();
		 for( char ch:chars) {
			 if(sBuilder.indexOf(String.valueOf(ch))<0)
				 sBuilder.append(ch);
		 }
		 System.out.println(sBuilder.toString());
	}
	public static void removeDuplicates4(String st) {
	
		Set <Character> s=new HashSet<Character>();
		 for(int i=0; i<st.length();i++){
			 s.add(st.charAt(i));
		 }
		 System.out.println(s);
		 }


}	


