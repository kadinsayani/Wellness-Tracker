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
}
