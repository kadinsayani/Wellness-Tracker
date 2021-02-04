import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


/**
 * FoodTracker class for API request and food tracking related features
 * @author kadinsayani
 *
 */
public class FoodTracker {

	public double calories;

	/**
	 * recordFoodItem method uses the CalorieNinjas natural language processing api
	 * (https://rapidapi.com/user/calorieninjas) to retrieve calories for a user
	 * inputed query
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public double requestCalories() {
		// User input - food search query
		System.out.println("\n");
		System.out.println(
				"Welcome to food tracking mode! Food tracking mode uses a natural language processing API to retrieve nutritional information on the food you ate and log calories.");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the food you ate. For example, type one glass of milk, or two apples.");
		System.out.println("Enter text here: ");
		String input = sc.nextLine();
		String foodSearch = input.replace(" ", "%20");

		try {
			// Http request, response parsing, and adding calories to calorieCount
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://calorieninjas.p.rapidapi.com/v1/nutrition?query=" + foodSearch))
					.header("x-rapidapi-key", "123fd00c7bmshd1ed187683922d3p1ee616jsnb34534610f6a")
					.header("x-rapidapi-host", "calorieninjas.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody()).build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			String toParse = response.body();

			// Parse api response
			String[] items = toParse.split(",");
			calories = Double.parseDouble(items[8].substring(13));

		} catch (NumberFormatException | IOException | InterruptedException e) {
			e.printStackTrace();
		}

		return calories;
	}
}
