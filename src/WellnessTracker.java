import java.util.Scanner;

/**
 * WellnessTracker class. This class has the core functionality of the
 * application including recording metrics, checking metrics, and the
 * applications main menu.
 */

public class WellnessTracker {

	private int stepCount;
	private double waterIntake;
	private double sleepTime;
	private double exerciseTime;
	private double calorieCount;

	Scanner sc = new Scanner(System.in);

	/**
	 * Wellness Tracker constructor
	 * 
	 * @param stepCount
	 * @param waterIntake
	 * @param sleepTime
	 * @param exerciseTime
	 * @param calorieCount
	 */
	public WellnessTracker() {
		super();
		this.stepCount = 0;
		this.waterIntake = 0.0;
		this.sleepTime = 0.0;
		this.exerciseTime = 0.0;
		this.calorieCount = 0;
	}

	/*
	 * menu method contains the main menu and a switch statement for performing
	 * operations based on user input
	 * 
	 * @param: none
	 * 
	 * @return: void
	 */
	public void menu(User user) {

		do {
			// Main menu
			System.out.println("\n");
			System.out.println("Welcome to wellness tracker, " + user.getName() + "!");
			System.out.println("-----------------------------------------");
			System.out.println("Step count" + "\t|" + "\t" + stepCount);
			System.out.println("-----------------------------------------");
			System.out.println("Water intake" + "\t|" + "\t" + waterIntake + " fluid ounces");
			System.out.println("-----------------------------------------");
			System.out.println("Sleep time" + "\t|" + "\t" + sleepTime + " hours");
			System.out.println("-----------------------------------------");
			System.out.println("Exercise time" + "\t|" + "\t" + exerciseTime + " minutes");
			System.out.println("-----------------------------------------");
			System.out.println("Calories" + "\t|" + "\t" + calorieCount + " calories");
			System.out.println("-----------------------------------------");
			System.out.println("\n");
			System.out.println("What would you like to do?");
			System.out.println("1: Record steps");
			System.out.println("2: Record water intake");
			System.out.println("3: Record sleep");
			System.out.println("4: Record exercise");
			System.out.println("5: Record food");
			System.out.println("6: Edit previous entry");
			System.out.println("7: Exit application");

			int menuSelection = sc.nextInt();
			// Switch statement for menu option selection
			switch (menuSelection) {
			case 1:
				recordMetric("steps", user);
				break;
			case 2:
				recordMetric("water", user);
				break;
			case 3:
				recordMetric("sleep", user);
				break;
			case 4:
				recordMetric("exercise", user);
				break;
			case 5:
				FoodAPI f = new FoodAPI();
				calorieCount += f.requestCalories();
				checkMetric("calories", user);
				break;
			case 6:
				System.out.println(
						"Would you like to edit an entry for steps (1), water (2), sleep (3), or exercise (4)?");
				int metricToEdit = sc.nextInt();
				editEntry(metricToEdit);
				break;
			case 7:
				break;
			}
		} while (true);
	}

	/*
	 * recordMetric method prompts users to enter a recording for a specific metric
	 * (ex. steps)
	 * 
	 * @param: metric - metric user would like to record
	 * 
	 * @returns: void
	 */
	public void recordMetric(String metric, User user) {
		System.out.println("Please enter the amount of " + metric + " you would like to record: ");
		if (metric == "steps") {
			stepCount += sc.nextInt();
			checkMetric("steps", user);
		} else if (metric == "water") {
			waterIntake += sc.nextDouble();
			checkMetric("water", user);
		} else if (metric == "sleep") {
			sleepTime += sc.nextDouble();
			checkMetric("sleep", user);
		} else if (metric == "exercise") {
			exerciseTime += sc.nextDouble();
			checkMetric("exercise", user);
		}
	}

	/*
	 * checkMetric method compares recorded metrics with goals and calculated
	 * recommendations
	 * 
	 * @param: metric - metric being checked
	 * 
	 * @returns: void
	 */
	public void checkMetric(String metric, User user) {
		if (metric == "steps") {
			if (stepCount < user.getStepGoal()) {
				System.out.println("You have " + (user.getStepGoal() - stepCount)
						+ " steps remaining before you reach your goal! 👣");
			} else if (stepCount == user.getStepGoal()) {
				System.out.println("Congratulations! You have reached your step goal. ✅");
			} else {
				System.out.println("You have exceeded your step goal, keep it up! 😁");
			}
		} else if (metric == "water") {
			double waterGoal = calculateRequiredWaterIntake(user);
			if (waterIntake < waterGoal) {
				System.out.println("You have " + (waterGoal - waterIntake)
						+ " fluid ounces remaining before you reach your recommended daily water intake! 💧");
			} else if (waterIntake == waterGoal) {
				System.out.println("Congratulations! You have reached your recommended daily water intake. ✅");
			} else {
				System.out.println("You have exceeded your recommended daily water intake, keep it up! 😁");
			}
		} else if (metric == "sleep") {
			double sleepGoal = calculateRecommendedSleep(user.getAge());
			if (sleepTime < sleepGoal) {
				System.out.println("You are " + (sleepGoal - sleepTime)
						+ " hours short of your recommended sleep time (" + sleepGoal + "). 💤");
			} else if (sleepTime == sleepGoal) {
				System.out.println("Congratulations! You have met your recommended sleep time. ✅");
			} else {
				System.out.println("You have exceeded your recommended sleep time. 😁");
			}
		} else if (metric == "exercise") {
			double exerciseGoal = 60.0;
			if (exerciseTime < exerciseGoal) {
				System.out.println("You have " + (exerciseGoal - exerciseTime)
						+ " exercise minutes remaining before you reach your recommended daily exercise time. 💪");
			} else if (exerciseTime == exerciseGoal) {
				System.out.println("Congratulations! You have met your recommended daily exercise time! ✅");
			} else {
				System.out.println("You have exceeded your recommended daily exercise time. 😁");
			}
		} else if (metric == "calories") {
			if (calorieCount < user.getCalorieGoal()) {
				System.out.println("You have " + (user.getCalorieGoal() - calorieCount)
						+ " calories remaining before you reach your calorie goal. 🍎");
			} else if (calorieCount == user.getCalorieGoal()) {
				System.out.println("Congratulations! You have met your calorie goal! ✅");
			} else {
				System.out.println("You have exceeded your calorie goal.");
			}
		}
	}

	/*
	 * calculateRequiredWaterIntake
	 * 
	 * @param: none
	 * 
	 * @returns: weight / 2.0
	 */
	public double calculateRequiredWaterIntake(User user) {
		return user.getWeight() / 2.0;
	}

	/*
	 * calculateRecommendedSleep based on recommended sleep times from canada.ca
	 * 
	 * @param: age
	 * 
	 * @returns: recommendedSleep
	 */
	public double calculateRecommendedSleep(int age) {
		double recommendedSleep = 0.0;
		if (age >= 18 && age <= 64) {
			recommendedSleep += 8.0;
		} else if (age >= 65) {
			recommendedSleep += 7.5;
		}
		return recommendedSleep;
	}

	public void editEntry(int metric) {
		if (metric == 1) {
			System.out.println("How many steps would you like to remove?");
			int stepsToRemove = sc.nextInt();
			stepCount -= stepsToRemove;
		} else if (metric == 2) {
			System.out.println("How many fluid ounces of water would you like to remove?");
			double waterToRemove = sc.nextDouble();
			waterIntake -= waterToRemove;
		} else if (metric == 3) {
			System.out.println("How many hours of sleep would you like to remove?");
			double sleepToRemove = sc.nextDouble();
			sleepTime -= sleepToRemove;
		} else if (metric == 4) {
			System.out.println("How many minutes of exercise would you like to remove?");
			double exerciseToRemove = sc.nextDouble();
			exerciseTime -= exerciseToRemove;
		}
	}
}
