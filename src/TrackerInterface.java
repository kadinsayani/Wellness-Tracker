import java.util.Scanner;

/**
 * WellnessTracker class. This class has the core functionality of the
 * application including recording metrics, checking metrics, and the
 * applications main menu.
 */

public class TrackerInterface {

	/**
	 * menu method contains the main menu and a switch statement for performing
	 * operations based on user input
	 * 
	 * @param: user
	 * 
	 * @return: void
	 */
	public void menu(User user) {

		Metric steps = new Metric("steps");
		Metric water = new Metric("water");
		Metric sleep = new Metric("sleep");
		Metric exercise = new Metric("exercise");
		Metric calories = new Metric("calories");

		Scanner menuSc = new Scanner(System.in);

		boolean menuActive = true;

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

			int menuSelection = menuSc.nextInt();

			// Switch statement for menu option selection

			switch (menuSelection) {
			case 1:
				steps.recordMetric(user);
				steps.checkMetric(user);
				break;
			case 2:
				water.recordMetric(user);
				water.checkMetric(user);
				break;
			case 3:
				sleep.recordMetric(user);
				sleep.checkMetric(user);
				break;
			case 4:
				exercise.recordMetric(user);
				exercise.checkMetric(user);
				break;
			case 5:
				FoodAPI f = new FoodAPI();
				calories.addToCalorieCount(f.requestCalories());
				calories.checkMetric(user);
				break;
			case 6:
				menuActive = false;
				break;
			}
		} while (menuActive == true);
	}
}
