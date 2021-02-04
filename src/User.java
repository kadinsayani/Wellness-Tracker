/**
 * User class to store user data
 */

public class User {
	private String name;
	private int stepGoal;
	private int age;
	private double weight;
	private int calorieGoal;

	/**
	 * User constructor
	 * 
	 */
	User() {
		
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
