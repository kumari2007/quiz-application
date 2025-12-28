import java.io.*;
import java.util.*;

public class Quiz {
    private ArrayList<Question> questions = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private final String FILE_NAME = "questions.txt";

    public Quiz() {
        loadFromFile();
    }

    // Load questions from file
    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String q = line;
                String[] opts = new String[4];
                for (int i = 0; i < 4; i++) {
                    opts[i] = br.readLine();
                }
                int ans = Integer.parseInt(br.readLine());
                questions.add(new Question(q, opts, ans));
            }
        } catch (IOException e) {
            System.out.println("No existing questions found. Starting fresh.");
        }
    }

    // Save all questions to file
    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Question q : questions) {
                pw.println(q.getQuestion());
                for (String opt : q.getOptions()) {
                    pw.println(opt);
                }
                pw.println(q.getCorrectOption());
            }
        } catch (IOException e) {
            System.out.println("Error saving questions.");
        }
    }

    // Setter mode
    public void addQuestionsByUser() {
        System.out.print("Enter number of questions to add: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter question:");
            String qText = sc.nextLine();

            String[] options = new String[4];
            for (int j = 0; j < 4; j++) {
                System.out.print("Option " + (j + 1) + ": ");
                options[j] = sc.nextLine();
            }

            System.out.print("Correct option (1-4): ");
            int correct = sc.nextInt();
            sc.nextLine();

            questions.add(new Question(qText, options, correct));
        }
        saveToFile();
        System.out.println("Questions saved successfully!");
    }

    // Player mode
    public void startQuiz() {
        if (questions.isEmpty()) {
            System.out.println("No questions available!");
            return;
        }

        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQ" + (i + 1));
            Question q = questions.get(i);
            q.display();
            System.out.print("Your answer: ");
            int ans = sc.nextInt();

            if (q.isCorrect(ans)) score++;
        }

        System.out.println("\nFinal Score: " + score + "/" + questions.size());
    }
}
