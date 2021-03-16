/**
 * @author kadinsayani
 *
 */
public class Metric {

	private double metricCount;
	private double calorieCount;
	private String metricType;

	/**
	 * constructor sets metricType and assigns 0 to metric and calorie counts
	 * 
	 * @param metricType
	 */
	Metric(String metricType) {
		if (metricType == "calories") {
			calorieCount = 0.0;
		}
		metricCount = 0.0;
		this.setMetricType(metricType);
	}

	public void recordMetric(double amountToAdd) {
		metricCount += amountToAdd;
	}

	/**
	 * adds calories to user calorieCount
	 * 
	 * @param calories
	 */
	public void addToCalorieCount(double calories) {
		calorieCount += calories;
	}

	public double calculateRequiredWaterIntake(User user) {
		return user.getWeight() / 2.0;
	}

	/**
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
	 * @param metricCount the metricCount to set
	 */
	public void setMetricCount(double metricCount) {
		this.metricCount = metricCount;
	}

	/**
	 * @return the calorieCount
	 */
	public double getCalorieCount() {
		return calorieCount;
	}

	/**
	 * @return metricType
	 */
	public String getMetricType() {
		return metricType;
	}

	/**
	 * @param metricType
	 */
	public void setMetricType(String metricType) {
		this.metricType = metricType;
	}

}
