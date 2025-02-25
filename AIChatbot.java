import java.util.HashMap;
import java.util.Scanner;

import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Random;

public class AIChatbot {
    private static final HashMap<String, String> responses = new HashMap<>();
    private static final String[] jokes = {
        "Why don't scientists trust atoms? Because they make up everything!",
        "Why did the scarecrow win an award? Because he was outstanding in his field!",
        "What do you get when you cross a snowman and a vampire? Frostbite!"
    };
    private static final String[] quizQuestions = {
        "What is the capital of France? A) Berlin B) Madrid C) Paris D) Rome",
        "Which planet is known as the Red Planet? A) Earth B) Venus C) Mars D) Jupiter",
        "Who wrote 'Hamlet'? A) Charles Dickens B) William Shakespeare C) J.K. Rowling D) Mark Twain"
    };
    private static final String[] quizAnswers = {"C", "C", "B"};

    static {
        responses.put("hi", "Hello! How can I assist you today?");
        responses.put("hello", "Hi there! What can I do for you?");
        responses.put("hey", "Hey! How can I help?");
        responses.put("your name", "I am an AI chatbot, here to assist you!");
        responses.put("how are you", "I'm just a bot, but I'm doing great! How about you?");
        responses.put("help", "Sure! How can I assist you?");
        responses.put("bye", "Goodbye! Have a great day!");
        responses.put("time", "The current time is: " + LocalTime.now());
        responses.put("date", "Today's date is: " + LocalDate.now());
        responses.put("weather", "I can't check the weather, but you can try looking it up online!");
        responses.put("joke", "random_joke");
        responses.put("motivate me", "Believe in yourself! Every day is a new opportunity to succeed.");
        responses.put("fact", "Did you know? Honey never spoils! Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3000 years old and still edible.");
        responses.put("quiz", "start_quiz");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("AI Chatbot: Hello! Type 'bye' to exit.");
        
        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().toLowerCase();
            
            if (userInput.equals("bye")) {
                System.out.println("AI Chatbot: Goodbye! Have a great day!");
                break;
            }
            
            boolean foundResponse = false;
            for (String key : responses.keySet()) {
                if (userInput.contains(key)) {
                    String response = responses.get(key);
                    if (response.equals("random_joke")) {
                        response = jokes[random.nextInt(jokes.length)];
                    } else if (response.equals("start_quiz")) {
                        startQuiz(scanner);
                        foundResponse = true;
                        break;
                    }
                    System.out.println("AI Chatbot: " + response);
                    foundResponse = true;
                    break;
                }
            }
            
            if (!foundResponse) {
                System.out.println("AI Chatbot: I'm not sure how to respond to that. Try asking something else!");
            }
        }
        scanner.close();
    }

    private static void startQuiz(Scanner scanner) {
        Random random = new Random();
        int index = random.nextInt(quizQuestions.length);
        System.out.println("AI Chatbot: " + quizQuestions[index]);
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine().trim().toUpperCase();
        
        if (userAnswer.equals(quizAnswers[index])) {
            System.out.println("AI Chatbot: Correct! Well done!");
        } else {
            System.out.println("AI Chatbot: Sorry, that's incorrect. The correct answer was " + quizAnswers[index] + ".");
        }
    }
}
