# Wellness Tracker


## About



WellnessTracker is a Java application that tracks wellness metrics such as steps, water intake, exercise, and also does food tracking. 


## Project Reflection


### Development Environment

For my project, I chose to use the Eclipse IDE. For my first demo, I used VIM and javac, however, I decided to switch to Eclipse for my second demo because I wanted an environment with a debugger, JUnit support, a project explorer, and a marketplace. 


### Switching Between the Text-Based User Interface and Graphical User Interface

Wellness Tracker has both a text-based user interface and a graphical user interface. To switch between user interfaces, simply change the useGraphicalInterface boolean variable in the TrackerApp class.


### Additional Features

1. API Request for Calorie Tracking


Food Tracking is accomplished by using CalorieNinja's natural language processing API (https://rapidapi.com/user/calorieninjas) to retrieve calories for a user inputted query. The calorie tracking feature takes user input and sends an HTTP GET request to a free API I found on RapidAPI. The API response is information on the user inputted food item. My application then parses the response using some basic string functions such as .split() and adds the calories to a calorie count. I believe this feature is the most successful because it took a lot of research to figure out how to send a GET request to a REST API and parse the response. Furthermore, I am very proud of the result of my efforts. Calorie tracking was a goal for my project since the first demo, and I wanted to take it a step further than just having the user enter a calorie estimate. I wanted the user to be able to enter a food item and the amount they ate, and the calories get logged in my app. I was able to execute and achieve my goal by utilizing resources such as the Java HttpRequest documentation. Using the Java HttpRequest documentation also taught me a lot about reading documentation and separating the useful information from the not useful at the moment information.


2. CSS Styling


My project has CSS styling for text, backgrounds, tooltips, and buttons. Text fields utilize focused text input to add a blue border when a user is recording text in a particular field. Buttons utilize simple java fx CSS animations so they have a shadow effect when a user hovers their mouse over the button. All CSS in this project was accomplished by referring to the JavaFX documentation.


3. Lambda Function Button Handlers


I chose to use lambda function button event handlers for my project because I liked the idea of writing my button handler in line with the rest of my user interface code. I also believe lambda function event handlers are easier to work with. The JavaFX Button class includes a method called setOnAction that can be used for button click events. I passed the result of this method into my lambda function as an argument.


4. Additional UI Elements


My project also utilizes additional UI elements such as tooltips, progress bars, and alerts. Tooltips allow a user to hover over a button and learn more about what it does. For example, hovering over Add brings up a tooltip that states: "Click to submit entries. You can submit as many as you want at a time." Progress bars are used for tracking a user's progress towards their wellness metric goals.


### File IO

Wellness reports are generated as .txt files in the home/Wellness Tracker Reports directory.