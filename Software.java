import java.util.*;

class Software{
	public static void main(String[] args) {
		Set<String> failCase = test();
		if (failCase.isEmpty()) {
			System.out.println("All test case passed!!");
		}else{
			System.out.println("Floowing test case failed!!");
			System.out.println(failCase);
		}
	}
	//test
	public static Set<String> test(){
		Set<String> failCase = new HashSet<>();
		//test case 1, F(-1) should print "Invalid Input Number!"
		if (!printbyF(-1).equals("Invalid")) {
			failCase.add("Case 1");
		}
		//test case 2, F(7) =  13, which is a prime, should print "BuzzFizz"		
		if (!printbyF(7).equals("BuzzFizz")) {
			failCase.add("Case 2");
		}
		//test case 3, F(20) =  6765, which is divisible by 15, should print "FizzBuzz"
		if (!printbyF(20).equals("FizzBuzz")) {
			failCase.add("Case 3");
		}
		//test case 4, F(10) = 55, which is divisible by 5, should print "Fizz"
		if (!printbyF(10).equals("Fizz")) {
			failCase.add("Case 4");
		}
		//test case 5, F(8) = 21, which is divisible by 3, should print "Buzz"
		if (!printbyF(8).equals("Buzz")) {
			failCase.add("Case 5");
		}
		//test case 6, F(11) = 89, should print "89"
		if (!printbyF(9).equals("34")) {
			failCase.add("Case 6");
		}
		return failCase;
	}

	/** return Fibonacci number F(n) by formula */
	public static String printbyF(int n) {
		if (n < 1) {
			System.out.println("Invalid Input Number!! n Cannot Be Less Than 1!!");
			return "Invalid";
		}
		int Fibonacci = getFibonacci(n);
		if (isPrime(Fibonacci)) {
			System.out.println("BuzzFizz");
			return "BuzzFizz";
		}else if(Fibonacci%15==0){
			System.out.println("FizzBuzz");
			return "FizzBuzz";
		}else if(Fibonacci%5==0){
			System.out.println("Fizz");
			return "Fizz";
		}else if(Fibonacci%3==0){
			System.out.println("Buzz");
			return "Buzz";
		}else{
			System.out.println(Fibonacci);
			return Integer.toString(Fibonacci);
		}
	}

	/** return Fibonacci number F(n) by formula */
	private static int getFibonacci(int n) {
		double f1 = Math.pow(((1 + Math.sqrt(5)) / 2.0), n);
		double f2 = Math.pow(((1 - Math.sqrt(5)) / 2.0), n);
		return (int)(Math.floor((f1 - f2) / Math.sqrt(5)));
	}

	//checks whether an int is prime or not.
	private static boolean isPrime(int n) {
		//check if n is less than 2
		if (n<2) return false;
		//check if n is equal 2
		if (n==2) return true;
		//check if n is a multiple of 2
		if (n%2==0) return false;
		//if not, then just check the odds
		for(int i=3;i*i<=n;i+=2) {
			if(n%i==0)	return false;
		}
		return true;
	}
}