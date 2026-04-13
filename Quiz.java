import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int totalQuestions;

        // 1. Store quiz data in an ArrayList
        List<Question> quizQuestions = new ArrayList<>();
        
        // Add sample questions
        quizQuestions.add(new Question("What is the capital of France?",
                                       new String[]{"Berlin", "Madrid", "Paris", "Rome"},
                                       2));
        
        quizQuestions.add(new Question("Which planet is known as the 'Red Planet'?",
                                       new String[]{"Earth", "Mars", "Jupiter", "Venus"},
                                       1));
        
        quizQuestions.add(new Question("What is 7 + 8?",
                                       new String[]{"13", "14", "15", "16"},
                                       2));

        quizQuestions.add(new Question("Who wrote 'Romeo and Juliet'?",
                                       new String[]{"William Shakespeare", "Charles Dickens", "Jane Austen", "Mark Twain"},
                                       0));

        quizQuestions.add(new Question("Which gas do plants absorb from the atmosphere?",
                                       new String[]{"Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"},
                                       2));

        quizQuestions.add(new Question("What is the largest ocean on Earth?",
                                       new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"},
                                       3));

        quizQuestions.add(new Question("Which language is used for Android app development?",
                                       new String[]{"Swift", "Kotlin", "Ruby", "Go"},
                                       1));

        quizQuestions.add(new Question("What is the boiling point of water at sea level?",
                                       new String[]{"90°C", "100°C", "110°C", "120°C"},
                                       1));

        quizQuestions.add(new Question("Who painted the Mona Lisa?",
                                       new String[]{"Vincent van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Claude Monet"},
                                       1));

        quizQuestions.add(new Question("Which is the smallest prime number?",
                                       new String[]{"0", "1", "2", "3"},
                                       2));

        quizQuestions.add(new Question("What is the chemical symbol for gold?",
                                       new String[]{"Au", "Ag", "Gd", "Go"},
                                       0));

        quizQuestions.add(new Question("Which continent is known as the Dark Continent?",
                                       new String[]{"Asia", "Africa", "Europe", "Australia"},
                                       1));

        quizQuestions.add(new Question("Who is known as the Father of Computers?",
                                       new String[]{"Charles Babbage", "Alan Turing", "Bill Gates", "Steve Jobs"},
                                       0));

        quizQuestions.add(new Question("Which organ purifies our blood?",
                                       new String[]{"Heart", "Liver", "Kidney", "Lungs"},
                                       2));

        quizQuestions.add(new Question("Which country hosted the 2016 Summer Olympics?",
                                       new String[]{"China", "Brazil", "UK", "Russia"},
                                       1));

        totalQuestions = quizQuestions.size();

        System.out.println("Welcome to the Java Quiz! 🧠");
        System.out.println("Answer the following " + totalQuestions + " questions.");
        System.out.println("----------------------------------------");

        // 2. Iterate through each question
        for (Question q : quizQuestions) {
            q.displayQuestion();
            
            // 3. Accept user input
            int userChoice = -1;
            boolean isValidInput = false;

            while (!isValidInput) {
                System.out.print("Enter your answer (1-" + q.getOptions().length + "): ");
                if (scanner.hasNextInt()) {
                    userChoice = scanner.nextInt();
                    if (userChoice >= 1 && userChoice <= q.getOptions().length) {
                        isValidInput = true;
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and " + q.getOptions().length + ".");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input from the scanner
                }
            }

            // 4. Validate the answer and update score
            if (userChoice - 1 == q.getCorrectAnswerIndex()) {
                System.out.println("Correct! ✅");
                score++;
            } else {
                System.out.println("Incorrect. ❌ The correct answer was: " + (q.getCorrectAnswerIndex() + 1) + ". " + q.getOptions()[q.getCorrectAnswerIndex()]);
            }
            System.out.println("----------------------------------------");
        }

        // 5. Calculate and display final results
        double percentage = (double) score / totalQuestions * 100;
        
        System.out.println("Quiz completed!");
        System.out.println("Your final score: " + score + " out of " + totalQuestions);
        System.out.println("Number of correct answers: " + score);
        System.out.println("Number of incorrect answers: " + (totalQuestions - score));
        System.out.printf("Percentage: %.2f%%\n", percentage);
        
        scanner.close();
    }
}