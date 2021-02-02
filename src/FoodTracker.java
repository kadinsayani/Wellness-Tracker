import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class FoodTracker {

    public double calorieCount;

    /**
     * recordFoodItem method uses the CalorieNinjas natural language processing api
     * (https://rapidapi.com/user/calorieninjas) to retrieve calories for a user
     * inputed query
     */
    public void recordFoodItem() {
        // User input - food search query
        System.out.println(
                "Welcome to FoodTracker! FoodTracker uses a natural language processing API to retrieve nutritional information on the food you ate and log calories.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the food you ate. For example, type one glass of milk, or two apples.");
        System.out.println("Enter text here: ");
        String input = sc.nextLine();
        String foodSearch = input.replace(" ", "%20");

        // Http request, response parsing, and adding calories to calorieCount
        try {
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
            double calories = Double.parseDouble(items[8].substring(13));
            
            // Add to calorieCount
            calorieCount += calories;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
