import java.util.ArrayList;
import java.util.*;
public class Quiz {
    private ArrayList<Question> questions= new ArrayList<>();
    private int score=0;
    private Scanner sc=new Scanner(System.in);
    public void addQuestion(){
        System.out.print("Enter number of questions to add: ");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.println("Enter question "+(i+1)+": ");
            String qText=sc.nextLine();
            String [] options=new String[4];
            for(int j=0;j<4;j++){
                System.out.print("Option: "+(j+1)+": ");
                options[j]=sc.nextLine();
            }
            System.out.print("Enter correct option (1-4): ");
            int correct=sc.nextInt();
            sc.nextLine();
            questions.add(new Question(qText,options,correct));
        }
        System.out.println("\nQuestions added successfully!");
    }
    public void startQuiz(){
        if(questions.isEmpty()){
            System.out.println("No questions available. Ask setter to add questions first!");
            return ;
        }
        score=0;
        System.out.println("\n**** Start Quiz ****");
        for(int i=0;i<questions.size();i++){
            System.out.println("\nQuestion"+(i+1)+": ");
            Question q=questions.get(i);
            q.display();
            System.out.print("Your answer: ");
            int ans=sc.nextInt();
            if(q.isCorrect(ans)){
                System.out.println("Correct!");
                score++;
            }
            else{
                System.out.println("Wrong!");
            }
        }
        showResult();
    }
    private void showResult(){
        System.out.println("\n**** Result ****");
        System.out.println("Score: "+score+"/"+questions.size());
    }
}
