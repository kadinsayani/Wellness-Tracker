import java.util.Scanner;

/**
 * TrackerInterface class. This class handles the interface of the application
 * and calls methods for recording metrics, checking metrics, and calorie
 * tracking
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

		Scanner sc = new Scanner(System.in);

		boolean menuActive = true;

		System.out.println(
				"Welcome to Wellness Tracker! Wellness Tracker records steps, water intake, time spent sleeping, and also does food tracking!");
		System.out.println("Please enter your name: ");
		String name = sc.nextLine();
		System.out.println("Please enter your age: ");
		int age = sc.nextInt();
		System.out.println("Please enter your weight in lb: ");
		int weight = sc.nextInt();
		System.out.println("Please enter your step goal: ");
		int stepGoal = sc.nextInt();
		System.out.println("Please enter your calorie goal: ");
		int calorieGoal = sc.nextInt();
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

			String menuSelection = sc.nextLine();

			// Switch statement for menu option selection

			switch (menuSelection) {
			case "1":
				System.out.println("Please enter the amount of steps you  would like to record: ");
				int stepsToAdd = sc.nextInt();
				steps.recordMetric(stepsToAdd);
				break;
			case "2":
				System.out.println("Please enter the amount of water (fluid ounces) you  would like to record: ");
				int waterToAdd = sc.nextInt();
				water.recordMetric(waterToAdd);
				break;
			case "3":
				System.out.println("Please enter the amount of sleep (hours) you  would like to record: ");
				int sleepToAdd = sc.nextInt();
				sleep.recordMetric(sleepToAdd);
				break;
			case "4":
				System.out.println("Please enter the amount of exercise (minutes) you  would like to record: ");
				int exerciseToAdd = sc.nextInt();
				exercise.recordMetric(exerciseToAdd);
				break;
			case "5":
				FoodAPI f = new FoodAPI();
				System.out.println("Please enter a food item you would like to record: ");
				String foodItemToAdd = sc.nextLine();
				calories.addToCalorieCount(f.requestCalories(foodItemToAdd));
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