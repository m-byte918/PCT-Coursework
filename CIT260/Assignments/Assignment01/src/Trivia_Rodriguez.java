// Name: Christian Rodriguez
// Date: 01/22/2020
// Desc: Trivia game for programming assignment 1.

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*; 
import java.io.*;

public class Trivia_Rodriguez {
    // Because the class name and its methods are verbose as hell...
    public static void showError(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
        System.exit(0); // Program will terminate if there is ANY error reading the file
    }
    // Quiz for each player
    public static int quiz(String playerName, ArrayList<Questions_Rodriguez> questionsList) {
        int score = 0;
        for (int i = 0; i < questionsList.size(); ++i) {
            char answer = '?';
            boolean epsteinDidntKillHimeself;
            Questions_Rodriguez question = questionsList.get(i);

            // Title will show the players name, what question they are on, and how many are left
            String title = playerName + " - Question " + (i + 1) + "/" + questionsList.size();
            
            // Validate response
            do {
                epsteinDidntKillHimeself = false;
                String response = question.display(title);

                // Response must be exactly one character
                while (response.length() != 1) {
                    JOptionPane.showMessageDialog(null, "Invalid input length", "Invalid length", JOptionPane.WARNING_MESSAGE);
                    response = question.display(title);
                }
                // Response may only be A, B, C, or D. Case insensitive.
                answer = response.toUpperCase().charAt(0);
                if (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
                    JOptionPane.showMessageDialog(null, "Answer may only be A, B, C, or D", "Invalid input", JOptionPane.WARNING_MESSAGE);
                    epsteinDidntKillHimeself = true;
                }
            } while (epsteinDidntKillHimeself);

            // Response is valid. If it is correct, add one to the player's score
            if (answer == question.getCorrectAnswer())
                ++score;
        }
        return score;
    }
    public static void main(String[] args) {
        // Open quiz.txt for reading questions and answers
        Scanner quiz = null;
        try {
            // Creating an instance of file within scanner constructor
            // because Scanner::close() will also close the file
            quiz = new Scanner(new File("quiz.txt"));
        } catch (IOException e) {
            // Either the pathname was invalid or the file was not found in the
            // specified path. Either way, neatly display that it was not found
            showError("Error 404", "Quiz file was not found");
        }
        ArrayList<Questions_Rodriguez> questionsList = new ArrayList<Questions_Rodriguez>();

        // Add initial question to list and store it in currentQuestion
        questionsList.add(new Questions_Rodriguez());
        Questions_Rodriguez currentQuestion = questionsList.get(0);
        
        String line    = ""; // Current line contents
        int lineNumber = 0;  // Current line number

        // Fill questionsList from quiz file
        while (quiz.hasNextLine()) {
            line = quiz.nextLine().trim(); // Remove unwanted whitespace (not racist)
            ++lineNumber; // Keep line number updated as we are looping through each line
            
            // Ignore empty lines
            if (line.isEmpty()) {
                // ...unless the first question is missing
                if (questionsList.size() == 1 && currentQuestion.getQuestion() == null)
                    showError("Malformed question on line " + lineNumber, "File must start with a question.");
                continue;
            }
            // Only validate the question if it has not been validated already
            if (currentQuestion.getQuestion() == null) {
                // Validate punctuation, must contain a period or question mark
                int lastPeriodIndex = line.lastIndexOf(".");
                int lastQuestionMarkIndex = line.lastIndexOf("?");
                if (lastPeriodIndex < 0 && lastQuestionMarkIndex < 0) {
                    showError("Malformed question on line " + lineNumber, "Questions must end in a period or question mark. \nEx: Question?, Question.");
                }
                // Validate question content, must not be empty
                int lastPunctuationIndex = Math.max(lastPeriodIndex, lastQuestionMarkIndex);
                if (line.substring(0, lastPunctuationIndex).trim().isEmpty()) {
                    showError("Malformed question on line " + lineNumber, "Question cannot be empty");
                }
                // Finished, now we can move on to answers in the next iteration
                currentQuestion.setQuestion(line);
                continue;
            }
            // Answer may not be less than 2 chars (A., B., etc..)
            if (line.length() < 2) {
                showError("Malformed answer on line " + lineNumber, "Answer must start with A. B. C. or D., Ex: A. AnswerA, B. AnswerB");
            }
            // Set correct answer if line ends with "<"
            if (line.endsWith("<")) {
                // Remove correct answer marker from string so it does not get printed out
                line = line.substring(0, line.length() - 1).trim();
                if (currentQuestion.getCorrectAnswer() == '?') {
                    currentQuestion.setCorrectAnswer(line.charAt(0));
                // Too many correct answer markers, there may only be one for any given question
                } else {
                    showError("Extra '<' character on line " + lineNumber, "There cannot be more than one correct answer per question.");
                }
            }
            // Validate answer content
            if (line.isEmpty()) {
                showError("Malformed answer on line " + lineNumber, "Answer cannot be empty.");
            }
            // Validate each of the four possible answers
            if (currentQuestion.getAnswerA() == null) {
                if (line.toUpperCase().startsWith("A.")) {
                    currentQuestion.setAnswerA(line);
                } else {
                    showError("Malformed answer on line " + lineNumber, "Answer must start with A. or a. Ex: A. AnswerA, a. AnswerA");
                }
            } else if (currentQuestion.getAnswerB() == null) {
                if (line.toUpperCase().startsWith("B.")) {
                    currentQuestion.setAnswerB(line);
                } else {
                    showError("Malformed answer on line " + lineNumber, "Answer must start with B. or b. Ex: B. AnswerB, b. AnswerB");
                }
            } else if (currentQuestion.getAnswerC() == null) {
                if (line.toUpperCase().startsWith("C.")) {
                    currentQuestion.setAnswerC(line);
                } else {
                    showError("Malformed answer on line " + lineNumber, "Answer must start with C. or c. Ex: C. AnswerC, c. AnswerC");
                }
            } else if (currentQuestion.getAnswerD() == null) {
                if (line.toUpperCase().startsWith("D.")) {
                    // This is the last answer that needs to be checked, if the correct answer has
                    // not been defined yet then we can assume it is missing from the entire question
                    if (currentQuestion.getCorrectAnswer() == '?') {
                        showError("Missing correct answer marker on (at most) line " + lineNumber, 
                            "Correct answers must be marked with the '<' character after the line.\n"
                            + "Ex: A. AnswerA\n"
                            + "       B. AnswerB\n"
                            + "       C. AnswerC <\n"
                            + "       D. AnswerD");
                    }
                    currentQuestion.setAnswerD(line);
                } else {
                    showError("Malformed answer on line " + lineNumber, "Answer must start with D. or d. Ex: D. AnswerD, d. AnswerD");
                }
                // Finished initializing current question. If there is anything else after it, move on to the next
                if (quiz.hasNext()) {
                    questionsList.add(new Questions_Rodriguez());
                    currentQuestion = questionsList.get(questionsList.size() - 1);
                }
            }
        }
        // End of file was reached, check if any attributes of the last question were left uninitialized
        if (currentQuestion.getQuestion() == null)
            showError("EOF", "Unexpected end of file. Expected question.");
        else if (currentQuestion.getAnswerA() == null)
            showError("EOF", "Unexpected end of file. Expected answer A.");
        else if (currentQuestion.getAnswerB() == null)
            showError("EOF", "Unexpected end of file. Expected answer B.");
        else if (currentQuestion.getAnswerC() == null)
            showError("EOF", "Unexpected end of file. Expected answer C.");
        else if (currentQuestion.getAnswerD() == null)
            showError("EOF", "Unexpected end of file. Expected answer D.");

        // Prompt for and validate player one's name
        String playerOneName = "";
        while (playerOneName.trim().isEmpty()) {
            playerOneName = JOptionPane.showInputDialog(null, "Player 1, what is your first name?");
            if (playerOneName == null)
                System.exit(0); // User hit cancel or exited
            playerOneName = playerOneName.trim();
        }
        // Quiz player one
        int playerOneScore = quiz(playerOneName, questionsList);
        
        // Prompt for and validate player two's name
        String playerTwoName = "";
        while (playerTwoName.trim().isEmpty()) {
            playerTwoName = JOptionPane.showInputDialog(null, "Player 2, what is your first name?");
            if (playerTwoName == null)
                System.exit(0); // User hit cancel or exited
            playerTwoName = playerTwoName.trim();
        }
        // Quiz player two
        int playerTwoScore = quiz(playerTwoName, questionsList);
        
        // Determine who the winner is
        String status = "Its a tie!";
        if (playerOneScore > playerTwoScore) {
            status = playerOneName + " wins!";
        } else if (playerTwoScore > playerOneScore) {
            status = playerTwoName + " wins!";
        }
        // Display the winner and their score(s)
        JOptionPane.showMessageDialog(
            null,
            String.format("%s's score: %d\n%s's score: %d\n\n%s\n\n", playerOneName, playerOneScore, playerTwoName, playerTwoScore, status), 
            status,
            JOptionPane.INFORMATION_MESSAGE
        );
        // OBLITERATE quiz and JOptionPane with FACTS and LOGIC
        quiz.close();
        System.exit(0);
    }
}
