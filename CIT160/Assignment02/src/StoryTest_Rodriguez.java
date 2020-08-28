// Name: Christian Rodriguez
// Date: 09/24/2019
// Desc: Programming Assignment #2, working with classes

import java.util.Scanner;                      // input
import java.util.ArrayList;                    // indexing, string lists
import java.util.concurrent.ThreadLocalRandom; // salt for score

public class StoryTest_Rodriguez {
    // getScore(), getAssembledMadlib()
    int inputNumberTotal = 0;
    
    // storeIndexes(), getAssembledMadlib()
    final String adj  = "[adj]";
    final String adv  = "[adv]";
    final String num  = "[#]";
    final String noun = "[noun]";
    String template   = "";
    
    // promptUserInput()
    Scanner            input      = null;
    ArrayList<String>  nouns      = new ArrayList<>();
    ArrayList<Integer> numbers    = new ArrayList<>();
    ArrayList<String>  adverbs    = new ArrayList<>();
    ArrayList<String>  adjectives = new ArrayList<>();

    // storeIndexes()
    ArrayList<Integer> adjIndexes    = new ArrayList<>();
    ArrayList<Integer> advIndexes    = new ArrayList<>();
    ArrayList<Integer> numIndexes    = new ArrayList<>();
    ArrayList<Integer> nounIndexes   = new ArrayList<>();
    ArrayList<Integer> partsOfSpeech = new ArrayList<>();
    
    /********** Setters **********/
    public void setInputNumberTotal(int newInputNumberTotal) {
        inputNumberTotal = newInputNumberTotal;
    }
    public void setTemplate(String newTemplate) {
        template = newTemplate;
        storeIndexes();
    }
    public void setInput(Scanner keyboard) {
        input = keyboard;
    }
    public void setNouns(ArrayList<String> nounsList) {
        nouns = nounsList;
    }
    public void setNumbers(ArrayList<Integer> numbersList) {
        numbers = numbersList;
    }
    public void setAdverbs(ArrayList<String> adverbsList) {
        adverbs = adverbsList;
    }
    public void setAdjectives(ArrayList<String> adjectivesList) {
        adjectives = adjectivesList;
    }
    public void setAdjIndexes(ArrayList<Integer> adjIndexesList) {
        adjIndexes = adjIndexesList;
    }
    public void setAdvIndexes(ArrayList<Integer> advIndexesList) {
        advIndexes = advIndexesList;
    }
    public void setNumIndexes(ArrayList<Integer> numIndexesList) {
        numIndexes = numIndexesList;
    }
    public void setNounIndexes(ArrayList<Integer> nounIndexesList) {
        nounIndexes = nounIndexesList;
    }
    public void setPartsOfSpeech(ArrayList<Integer> partsOfSpeechList) {
        partsOfSpeech = partsOfSpeechList;
    }

    /********** Getters **********/
    public int getInputNumberTotal() {
        return inputNumberTotal;
    }
    public String getAdj() {
        return adj;
    }
    public String getAdv() {
        return adv;
    }
    public String getNum() {
        return num;
    }
    public String getNoun() {
        return noun;
    }
    public String getTemplate() {
        return template;
    }
    public Scanner getInput() {
        return input;
    }
    public ArrayList<String> getNouns() {
        return nouns;
    }
    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
    public ArrayList<String> getAdverbs() {
        return adverbs;
    }
    public ArrayList<String> getAdjectives() {
        return adjectives;
    }
    public ArrayList<Integer> getAdjIndexes() {
        return adjIndexes;
    }
    public ArrayList<Integer> getAdvIndexes() {
        return advIndexes;
    }
    public ArrayList<Integer> getNumIndexes() {
        return numIndexes;
    }
    public ArrayList<Integer> getNounIndexes() {
        return nounIndexes;
    }
    public ArrayList<Integer> getPartsOfSpeech() {
        return partsOfSpeech;
    }
    
    /********** Methods **********/
    StoryTest_Rodriguez() {
        // No mad lib template is provided
    }
    StoryTest_Rodriguez(Scanner keyboard) {
        input = keyboard;
        setTemplate(input.nextLine());
    }
    private void storeIndexes() {
        // Get index of all adjectives
        for (int i = template.indexOf(adj); i != -1 && i < template.length(); i = template.indexOf(adj, i + 1)) {
            partsOfSpeech.add(i);
            adjIndexes.add(i);
        }
        // Get index of all adverbs
        for (int i = template.indexOf(adv); i != -1 && i < template.length(); i = template.indexOf(adv, i + 1)) {
            partsOfSpeech.add(i);
            advIndexes.add(i);
        }
        // Get index of all numbers
        for (int i = template.indexOf(num); i != -1 && i < template.length(); i = template.indexOf(num, i + 1)) {
            partsOfSpeech.add(i);
            numIndexes.add(i);
        }
        // Get index of all nouns
        for (int i = template.indexOf(noun); i != -1 && i < template.length(); i = template.indexOf(noun, i + 1)) {
            partsOfSpeech.add(i);
            nounIndexes.add(i);
        }
        // Sort for prompting order
        partsOfSpeech.sort(null);
    }
    public boolean templateInvalid() {
        return partsOfSpeech.isEmpty();
    }
    public void promptUserInput() {
        // Invalid template-- getting input is pointless
        if (templateInvalid())
            return;
        
        // Prompt user for inputs and store them for later
        System.out.println();
        for (int i : partsOfSpeech) {
            if (adjIndexes.contains(i)) {
                System.out.print("Please provide an adjective: ");
                adjectives.add(input.nextLine());
            }
            else if (advIndexes.contains(i)) {
                System.out.print("Please provide an adverb: ");
                adverbs.add(input.nextLine());
            }
            else if (numIndexes.contains(i)) {
                System.out.print("Please provide a number: ");
                // Validate input
                while (!input.hasNextInt()) {
                    System.out.print("    Number must be an integer: ");
                    input.next();
                }
                numbers.add(input.nextInt());
                input.nextLine(); // Clear newline for next call
            }
            else if (nounIndexes.contains(i)) {
                System.out.print("Please provide a noun: ");
                nouns.add(input.nextLine());
            }
        }
    }
    public String getAssembledMadlib() {
        // Invalid template-- no mad lib can be assembled
        if (templateInvalid()) 
            return "N/A";

        // Replace [adj] with provided adjectives
        for (int i = template.indexOf(adj), j = 0; i != -1; i = template.indexOf(adj), ++j) {
            String before = template.substring(0, i);
            String after = template.substring(i + adj.length());
            template = before + adjectives.get(j) + after;
        }
        // Replace [adv] with provided adverbs
        for (int i = template.indexOf(adv), j = 0; i != -1; i = template.indexOf(adv), ++j) {
            String before = template.substring(0, i);
            String after = template.substring(i + adv.length());
            template = before + adverbs.get(j) + after;
        }
        // Replace [#] with provided numbers
        for (int i = template.indexOf(num), j = 0; i != -1; i = template.indexOf(num), ++j) {
            String before = template.substring(0, i);
            String after = template.substring(i + num.length());
            int numberSubstitute = numbers.get(j);
            template = before + numberSubstitute + after;
            inputNumberTotal += numberSubstitute; // Increase input number total for score
        }
        // Replace [noun] with provided nouns
        for (int i = template.indexOf(noun), j = 0; i != -1; i = template.indexOf(noun), ++j) {
            String before = template.substring(0, i);
            String after = template.substring(i + noun.length());
            template = before + nouns.get(j) + after;
        }
        return template;
    }
    public int getScore() {
        // Invalid template-- no score can be calculated
        if (templateInvalid())
            return 0;

        // Length of story based on number of words
        int wordCount = template.split("\\s+").length;
        
        // 5 points per part of speech
        int posCount = partsOfSpeech.size() * 5;
        
        // Random integer from 1-10
        int salt = ThreadLocalRandom.current().nextInt(1, 10 + 1);

        return wordCount + posCount + inputNumberTotal + salt;
    }
}
