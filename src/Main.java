import java.util.Scanner;

/**
 * Main class to take user data as input, create user object, and execute
 * WellnessTracker.menu()
 */

public class Main {

	/**
	 * This application is intended to record metrics that contribute to one's
	 * overall wellness
	 * 
	 * @author Kadin Sayani
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// User information
		System.out.println(
				"Welcome to Wellness Tracker! Wellness Tracker records steps, water intake, time spent sleeping, and also does food tracking!");
		System.out.println("Please enter your name: ");
		String name = sc.nextLine();
		System.out.println("Please enter your age: ");
		int age = sc.nextInt();
		System.out.println("Please enter your weight in lb: ");
		double weight = sc.nextDouble();
		System.out.println("Please enter your step goal: ");
		int stepGoal = sc.nextInt();
		System.out.println("Please enter your calorie goal: ");
		int calorieGoal = sc.nextInt();
		System.out.println("\n");

		// Create user object and pass in user inputed data
		User user = new User(name, stepGoal, age, weight, calorieGoal);

		// WellnessTracker.menu()
		WellnessTracker wt = new WellnessTracker(0, 0, 0, 0, 0.0);
		wt.menu(user);

		sc.close();
	}

}
