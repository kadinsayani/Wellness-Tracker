import java.util.Scanner;

/**
 * This application is intended to record metrics that contribute to one's
 * overall wellness
 * 
 * @author kadinsayani
 */

/**
 * Main class to take user data as input, create user object, and create an
 * instance of TrackerInterface
 */

public class Main {

	/**
	 * main method to create user object and call TrackerMenu.menu
	 * 
	 * @param args
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

		// TrackerInterface.menu() handles the programs interface and calls methods from
		// other
		// classes
		TrackerInterface t = new TrackerInterface();
		t.menu(user);

		sc.close();
	}

}
