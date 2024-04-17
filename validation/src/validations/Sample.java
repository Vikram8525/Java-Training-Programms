package validations;

public class Sample {

	public static void main(String[] args) {
		InputValid iv = new InputValid();
		System.out.print("enter a integer ");
		int a = iv.validateInteger();
		double b = iv.validateDouble();
		String c = iv.validateString();
		}

}
