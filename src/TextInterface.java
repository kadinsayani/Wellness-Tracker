import java.util.Scanner;

/**
 * TrackerInterface class. This class handles the interface of the
 * application and calls methods for recording metrics, checking metrics,
 * and calorie tracking
 */

public class TextInterface {

	/**
	 * menu method contains the main menu and a switch statement for performing
	 * operations based on user input
	 * 
	 * @param: user
	 * 
	 * @return: void
	 */
	public void menu() {

		Metric steps = new Metric("steps");
		Metric water = new Metric("water");
		Metric sleep = new Metric("sleep");
		Metric exercise = new Metric("exercise");
		Metric calories = new Metric("calories");

		Scanner menuSc = new Scanner(System.in);

		boolean menuActive = true;
		
		System.out.println(
				"Welcome to Wellness Tracker! Wellness Tracker records steps, water intake, time spent sleeping, and also does food tracking!");
		System.out.println("Please enter your name: ");
		String name = menuSc.nextLine();
		System.out.println("Please enter your age: ");
		int age = menuSc.nextInt();
		System.out.println("Please enter your weight in lb: ");
		int weight = menuSc.nextInt();
		System.out.println("Please enter your step goal: ");
		int stepGoal = menuSc.nextInt();
		System.out.println("Please enter your calorie goal: ");
		int calorieGoal = menuSc.nextInt();
		System.out.println("\n");

		// Create user object and pass in user inputed data
		User user = new User(name, stepGoal, age, weight, calorieGoal);
		
		do {
			// Main menu
			System.out.println("\n");
			System.out.println("Welcome to wellness tracker, " + user.getName() + "!");
			System.out.println("-----------------------------------------");
			System.out.println("Step count" + "\t|" + "\t" + steps.getMetricCount());
			System.out.println("-----------------------------------------");
			System.out.println("Water intake" + "\t|" + "\t" + water.getMetricCount() + " fluid ounces");
			System.out.println("-----------------------------------------");
			System.out.println("Sleep time" + "\t|" + "\t" + sleep.getMetricCount() + " hours");
			System.out.println("-----------------------------------------");
			System.out.println("Exercise time" + "\t|" + "\t" + exercise.getMetricCount() + " minutes");
			System.out.println("-----------------------------------------");
			System.out.println("Calories" + "\t|" + "\t" + calories.getCalorieCount() + " calories");
			System.out.println("-----------------------------------------");
			System.out.println("\n");
			System.out.println("What would you like to do?");
			System.out.println("1: Record steps");
			System.out.println("2: Record water intake");
			System.out.println("3: Record sleep");
			System.out.println("4: Record exercise");
			System.out.println("5: Record food");
			System.out.println("6: Exit application");

			String menuSelection = menuSc.nextLine();

			// Switch statement for menu option selection

			switch (menuSelection) {
			case "1":
				//todo
				break;
			case "2":
				//todo
				break;
			case "3":
				//todo
				break;
			case "4":
				//todo
				break;
			case "5":
				//todo
				break;
			case "6":
				menuActive = false;
				break;
			default:
				System.err.println("Invalid menu option");
				continue;
			}
		} while (menuActive == true);
	}
}