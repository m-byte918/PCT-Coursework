// Name: Christian Rodriguez
// Date: 01/22/2020
// Desc: Trivia game for programming assignment 1.

import javax.swing.*; 

public class Questions_Rodriguez {
    private String question    = null;
    private String answerA     = null;
    private String answerB     = null;
    private String answerC     = null;
    private String answerD     = null;
    private char correctAnswer = '?';
    
    // Constructors
    Questions_Rodriguez() {
    }
    Questions_Rodriguez(String _question, String _answerA, String _answerB, String _answerC, String _answerD, char _correctAnswer) {
        question      = _question;
        answerA       = _answerA;
        answerB       = _answerB;
        answerC       = _answerC;
        answerD       = _answerD;
        correctAnswer = _correctAnswer;
    }

    // Setters
    void setQuestion(String newQuestion) {
        question = newQuestion;
    }
    void setAnswerA(String answer) {
        answerA = answer;
    }
    void setAnswerB(String answer) {
        answerB = answer;
    }
    void setAnswerC(String answer) {
        answerC = answer;
    }
    void setAnswerD(String answer) {
        answerD = answer;
    }
    void setCorrectAnswer(char answer) {
        correctAnswer = answer;
    }

    // Getters
    String getQuestion() {
        return question;
    }
    String getAnswerA() {
        return answerA;
    }
    String getAnswerB() {
        return answerB;
    }
    String getAnswerC() {
        return answerC;
    }
    String getAnswerD() {
        return answerD;
    }
    char getCorrectAnswer() {
        return correctAnswer;
    }
    
    // Other
    String display(String title) {
        String answer = JOptionPane.showInputDialog(
            null,
            String.format("%s\n%s\n%s\n%s\n%s\n\n", question, answerA, answerB, answerC, answerD),
            title,
            JOptionPane.QUESTION_MESSAGE
        );
        // Player hit cancel or closed out of dialog
        if (answer == null)
            System.exit(0);
        return answer.trim();
    }
}
