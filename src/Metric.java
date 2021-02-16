import java.util.Scanner;

public class Metric {
	
	private double metricCount;
	private double calorieCount;
	private String metricType;
	
	Metric(String metricType) {
		if (metricType == "calories") {
			calorieCount = 0.0;
		}
		metricCount = 0.0;
		this.metricType = metricType;
	}

	/*
	 * recordMetric method prompts users to enter a recording for a specific metric
	 * (ex. steps)
	 * 
	 * @param: metric - metric user would like to record
	 * 
	 * @returns: void
	 */
	public void recordMetric(User user) {
		System.out.println("Please enter the amount of " + metricType + " you would like to record: ");
		Scanner sc = new Scanner(System.in);
		double amountToAdd = sc.nextDouble();
		metricCount += amountToAdd;
		checkMetric(user);
	}

	/*
	 * checkMetric method compares recorded metrics with goals and calculated
	 * recommendations
	 * 
	 * @param: metric - metric being checked
	 * 
	 * @returns: void
	 */
	public void checkMetric(User user) {
		if (metricType == "steps") {
			if (metricCount < user.getStepGoal()) {
				System.out.println("You have " + (user.getStepGoal() - metricCount)
						+ " steps remaining before you reach your goal! 👣");
			} else if (metricCount == user.getStepGoal()) {
				System.out.println("Congratulations! You have reached your step goal. ✅");
			} else {
				System.out.println("You have exceeded your step goal, keep it up! 😁");
			}
		} else if (metricType == "water") {
			double waterGoal = calculateRequiredWaterIntake(user);
			if (metricCount < waterGoal) {
				System.out.println("You have " + (waterGoal - metricCount)
						+ " fluid ounces remaining before you reach your recommended daily water intake! 💧");
			} else if (metricCount == waterGoal) {
				System.out.println("Congratulations! You have reached your recommended daily water intake. ✅");
			} else {
				System.out.println("You have exceeded your recommended daily water intake, keep it up! 😁");
			}
		} else if (metricType == "sleep") {
			double sleepGoal = calculateRecommendedSleep(user.getAge());
			if (metricCount < sleepGoal) {
				System.out.println("You are " + (sleepGoal - metricCount)
						+ " hours short of your recommended sleep time (" + sleepGoal + "). 💤");
			} else if (metricCount == sleepGoal) {
				System.out.println("Congratulations! You have met your recommended sleep time. ✅");
			} else {
				System.out.println("You have exceeded your recommended sleep time. 😁");
			}
		} else if (metricType == "exercise") {
			double exerciseGoal = 60.0;
			if (metricCount < exerciseGoal) {
				System.out.println("You have " + (exerciseGoal - metricCount)
						+ " exercise minutes remaining before you reach your recommended daily exercise time. 💪");
			} else if (metricCount == exerciseGoal) {
				System.out.println("Congratulations! You have met your recommended daily exercise time! ✅");
			} else {
				System.out.println("You have exceeded your recommended daily exercise time. 😁");
			}
		} else if (metricType == "calories") {
			if (metricCount < user.getCalorieGoal()) {
				System.out.println("You have " + (user.getCalorieGoal() - metricCount)
						+ " calories remaining before you reach your calorie goal. 🍎");
			} else if (metricCount == user.getCalorieGoal()) {
				System.out.println("Congratulations! You have met your calorie goal! ✅");
			} else {
				System.out.println("You have exceeded your calorie goal.");
			}
		}
	}
	
	public void addToCalorieCount(double calories) {
		calorieCount += calories;
	}

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

	/**
	 * @return the metricCount
	 */
	public double getMetricCount() {
		return metricCount;
	}
	
	/**
	 * @return the calorieCount
	 */
	public double getCalorieCount() {
		return calorieCount;
	}
	
//	private void editEntry(int metric) {
//		if (metric == 1) {
//			System.out.println("How many steps would you like to remove?");
//			int stepsToRemove = sc.nextInt();
//			stepCount -= stepsToRemove;
//		} else if (metric == 2) {
//			System.out.println("How many fluid ounces of water would you like to remove?");
//			double waterToRemove = sc.nextDouble();
//			waterIntake -= waterToRemove;
//		} else if (metric == 3) {
//			System.out.println("How many hours of sleep would you like to remove?");
//			double sleepToRemove = sc.nextDouble();
//			sleepTime -= sleepToRemove;
//		} else if (metric == 4) {
//			System.out.println("How many minutes of exercise would you like to remove?");
//			double exerciseToRemove = sc.nextDouble();
//			exerciseTime -= exerciseToRemove;
//		}
//	}

}