package interviewQuestions;

public class FizzandBuzzNumb {

	public static void main(String[] args) {
		  int num=50;
			for(int i=0; i<=num; i++) {
				if(i%3==0 && i%5==0) {
					System.out.println("its is fuzz and buzz numbers: "+i);
				} else if(i%3==0) {
					System.out.println("its fuzz number: "+i);
				}else if(i%5==0) {
					System.out.println("its buzz number:"+i);
				}
			}
		
	
}
}