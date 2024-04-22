package validations;

public class Sample {

	public static void main(String[] args) {
		InputValid iv = new InputValid();
		System.out.print("enter your name");
		String name = iv.validateNameString();
		System.out.print("enter a integer value for A");
		int a = iv.validateInteger();
		System.out.print("enter a Double value for b");
		double b = iv.validateDouble();
		System.out.print("enter a String value for C");
		String c = iv.validateString();
		System.out.print("enter your e mail");
		String email = iv.validateEmailAddress();
		System.out.print("enter your Password");
		String Password = iv.validatePassword();
		}

}
