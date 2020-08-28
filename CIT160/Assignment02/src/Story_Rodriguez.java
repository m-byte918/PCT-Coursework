// Name: Christian Rodriguez
// Date: 09/24/2019
// Desc: Programming Assignment #2, working with classes

import java.text.DecimalFormat;
import java.util.Scanner;

public class Story_Rodriguez {
    public static void main(String[] args) {
        
        int hours = 45;
        double pay, payRate = 10.00;
        pay = hours <= 40 ? hours * payRate : 40 * payRate + (hours - 40) * payRate * 1.5;
        System.out.println(pay);
        
        double x = 12.78;
        DecimalFormat formatter = new DecimalFormat("##0.0");
        System.out.println(formatter.format(x));
        
        System.out.println("/********************* With overloaded constructor **********************/");
        System.out.println("Please provide a mad lib template.");
        System.out.println("Example: He bought [#] [adj] [noun] from the [noun] [adv]\n");

        Scanner keyboard = new Scanner(System.in);
        StoryTest_Rodriguez story = new StoryTest_Rodriguez(keyboard);

        // Check if user provided any parts of speech
        if (story.templateInvalid()) {
            System.out.println("Mad lib template must contain at least one adjective, adverb, number, or noun");
            System.exit(0);
        }
        // Prompt user for inputs for parts of speech
        story.promptUserInput();

        // Output completed mad lib
        System.out.println("\nCompleted mad lib: " + story.getAssembledMadlib());
        System.out.println("Score: " + story.getScore());
        
        System.out.println("\n\n/********************* With default constructor **********************/");
        System.out.println("Please provide a mad lib template.");
        System.out.println("Example: He bought [#] [adj] [noun] from the [noun] [adv]\n");

        story = new StoryTest_Rodriguez();
        story.setInput(keyboard);
        story.setTemplate(keyboard.nextLine());
        
        // Check if user provided any parts of speech
        if (story.getPartsOfSpeech().isEmpty()) {
            System.out.println("Mad lib template must contain at least one adjective, adverb, number, or noun");
            System.exit(0);
        }
        // Prompt user for inputs for parts of speech
        story.promptUserInput();

        // Output completed mad lib
        System.out.println("\nCompleted mad lib: " + story.getAssembledMadlib());
        System.out.println("Score: " + story.getScore());
    }
}
