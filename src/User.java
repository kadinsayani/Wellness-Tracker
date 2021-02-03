/**
 * User class to store user data
 */

public class User {
	public String name;
	public int stepGoal;
	public int age;
	public double weight;
	public int calorieGoal;

	/**
	 * User constructor
	 * 
	 * @param name
	 * @param stepGoal
	 * @param age
	 * @param weight
	 * @param calorieGoal
	 */
	User(String name, int stepGoal, int age, double weight, int calorieGoal) {
		this.name = name;
		this.stepGoal = stepGoal;
		this.age = age;
		this.weight = weight;
		this.calorieGoal = calorieGoal;
	}

	/**
	 * @return the stepGoal
	 */
	public int getStepGoal() {
		return stepGoal;
	}

	/**
	 * @param stepGoal the stepGoal to set
	 */
	public void setStepGoal(int stepGoal) {
		this.stepGoal = stepGoal;
	}

	/**
	 * @return the calorieGoal
	 */
	public int getCalorieGoal() {
		return calorieGoal;
	}

	/**
	 * @param calorieGoal the calorieGoal to set
	 */
	public void setCalorieGoal(int calorieGoal) {
		this.calorieGoal = calorieGoal;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
}
