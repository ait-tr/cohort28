
public class CircusAppl {

	public static void main(String[] args) {
	     lightOn();
	     entertainer();
	     lightOff();
	   }

	   public static void lightOff(){
	    System.out.println("Light off");
	   }

	   public static void lightOn(){
	     System.out.println("Light on");
	   }

	   public static void entertainer(){
	     joggler();
	     singer();
	     clown();
	   }

	   public static void joggler(){
	     System.out.println("My name is John Smith");
	     System.out.println("I am a joggler");
	   }

	   public static void singer(){
	     System.out.println("My name is Philipp");
	     System.out.println("I am a singer");
	   }

	   public static void clown() {
	     System.out.println("My name is Oleg Popov");
	     System.out.println("I am a clown");
	   }
}
