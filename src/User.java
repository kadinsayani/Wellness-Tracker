/**
 * User class to store user data User class also includes getter and setter
 * methods for user information
 */

public class User {

	private String name;
	private int stepGoal;
	private int age;
	private int weight;
	private int calorieGoal;

	/**
	 * User constructor
	 * 
	 * @param name
	 * @param stepGoal
	 * @param age
	 * @param weight
	 * @param calorieGoal
	 */
	User(String name, int age, int weight, int stepGoal, int calorieGoal) {
		this.name = name;
		this.stepGoal = stepGoal;
		this.age = age;
		this.weight = weight;
		this.calorieGoal = calorieGoal;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", stepGoal=" + stepGoal + ", age=" + age + ", weight=" + weight
				+ ", calorieGoal=" + calorieGoal + "]";
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
		if (stepGoal >= 1) {
			this.stepGoal = stepGoal;
		} else {
			this.stepGoal = 0;
		}
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
		if (calorieGoal >= 100) {
			this.calorieGoal = calorieGoal;
		} else {
			this.calorieGoal = 100;
		}

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
		if (age >= 0) {
			this.age = age;
		} else {
			this.age = 0;
		}
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		if (weight >= 25) {
			this.weight = weight;
		} else {
			this.weight = 25;
		}
	}
}
