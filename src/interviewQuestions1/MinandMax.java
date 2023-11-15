package interviewQuestions1;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class MinandMax {

	public static void main(String[] args) {
		int i;
	    int a[]= {12,13,14,15,16};
	    int max=a[0]; int secondmax=a[0]; int min=a[0]; int secondmin=a[0];
	   
	    for( i=0;i<a.length;i++) {
	    	System.out.print(a[i]+" ");

	    }	
	    System.out.println("");
	  for( i=0;i<a.length;i++) {
	    	if(a[i]>max) {
	    		secondmax=max;
	    		max= a[i];
	    	}
	    	else if(a[i]>secondmax) {
	    		secondmax=a[i];
	    	}
	    		   
	    		
	    			 }
	  for( i=0;i<a.length;i++) {
		  if(a[i]<min) {
			  secondmin=min;
			 min=a[i];
		  }else if(a[i]>secondmin) {
			secondmin=a[1];
		  }
	  }
	  System.out.println(max+","+secondmax);
	  System.out.println(min+";"+secondmin);
	    			 
	}
	
	    		
	    

   
  
}
