
public class ChoiceAppl {
	public static void main(String[] args) {
	     int height = 195;
	     if(height > 192){
	      System.out.println("I am very tall");
	      System.out.println("Feed me");
	     }
	     System.out.println("My height: " + height);
	     double res = max(8.5, 8.8);
	     System.out.println("Max = " + res);
	     int a = sign(5.5);
	     System.out.println("Sign = " + a);
	     a = sign(-2.3);
	     System.out.println("Sign = " + a);
	     a = sign(0);
	     System.out.println("Sign = " + a);
	     res = taxUkraine(900);
	     System.out.println("Tax in Ukraine = " + res);
	     res = taxUkraine(3000);
	     System.out.println("Tax in Ukraine = " + res);
	     res = salaryNet(10000);
	     System.out.println("Salary netto = " + res);
	   }

	   public static double max(double x, double y) {
	    double res;
	    if(x > y) {
	      res = x;
	    } else {
	      res = y;
	    }
	    return res;
	   }

	   public static int sign(double x){
	     if(x > 0){
	      return 1;
	     }
	     if(x < 0){
	      return -1;
	     }
	     return 0;
	    // int res;
	    // if(x > 0){
	    //   res = 1;
	    // }else {
	    //   if(x < 0){
	    //     res = -1;
	    //   }else{
	    //     res = 0;
	    //   }
	    // }  
	    // return res;
	   }

	   public static double taxUkraine(double salary){
	    double res = 0;
	    if(salary > 1000){
	      res = (salary - 1000) * 0.17;
	    }
	    return res;
	   }
	   
	   public static double salaryNet(double salary){
		     return salary - taxUkraine(salary);
		   }
}
