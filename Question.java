public class Question{
    private String question;
    private String[] options;
    private int correctOption;
    public Question(String question,String [] options,int correctOption){
        this.question=question;
        this.options=options;
        this.correctOption=correctOption;
    }
    public void display(){
        System.out.println(question);
        for(int i=0;i<options.length;i++){
            System.out.println((i+1)+"."+options[i]);
        }
    }
    public boolean isCorrect(int userChoice){
        return userChoice==correctOption;
    }
    public String getQuestion() {
    return question;
}

public String[] getOptions() {
    return options;
}

public int getCorrectOption() {
    return correctOption;
}

}
