import java.util.*;
public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Quiz quiz = new Quiz();

        while (true) {
            System.out.println("\n===== Quiz Application =====");
            System.out.println("1. Set Questions");
            System.out.println("2. Attempt Quiz");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    quiz.addQuestion();
                    break;
                case 2:
                    quiz.startQuiz();
                    break;
                case 3:
                    System.out.println("Thank you for using Quiz App!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}