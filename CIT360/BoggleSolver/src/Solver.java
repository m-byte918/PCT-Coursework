import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Solver {
	
	static HashMap<Character, HashMap<String, String>> wordMap;

	// Let the given dictionary be following 
    static String dictionary[]; 
    static int n = 0;
    static final int M = 3, N = 3;
    
    // Driver program to test above function 
    public static void main(String args[]) { 
        char boggle[][] = { { 'a', 'b', 'c', 'e' }, 
                            { 'f', 'g', 'h', 'i' }, 
                            { 'j', 'k', 'l', 'm' } }; 

        System.out.println("Following words of dictionary are present");
        loadWords();
        n = dictionary.length;

        long startTime = System.nanoTime();
        findWords(boggle, false);
        long arrTime = System.nanoTime() - startTime;
        System.out.printf("Array search took %dns\n\n", arrTime);

        startTime = System.nanoTime();
        findWords(boggle, true);
        long hashTime = System.nanoTime() - startTime;
        System.out.printf("Hashmap search took %dns\n\n", hashTime);

        System.out.printf("Hashmap search was %d times faster than Array search", arrTime / hashTime);
    }
    
    // Loads english words
    static void loadWords() {
    	wordMap = new HashMap<Character, HashMap<String, String>>();
    	
    	Path file = Paths.get("./words.txt");
    	List<String> list = null;
    	
    	try {
			list = Files.readAllLines(file);
			dictionary = new String[list.size()];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not load the file");
			System.exit(1);
		}
    	
    	char currentChar = '0';
    	int i = 0;
    	for (String line : list) {
    		if (line.charAt(0) != currentChar) {
    			currentChar = line.charAt(0);
    			wordMap.put(currentChar, new HashMap<String, String>());
    		}
    		// Get the current character and put the corresponding string in that pair
    		wordMap.get(currentChar).put(line, line);
    		dictionary[i++] = line;
    	}
    }

    // Prints all words present in dictionary. 
    static void findWords(char boggle[][], boolean hashSearch) { 
        // Mark all characters as not visited 
        boolean visited[][] = new boolean[M][N]; 
  
        // Initialize current string 
        String str = ""; 
  
        // Consider every character and look for all words 
        // starting with this character 
        for (int i = 0; i < M; i++) 
            for (int j = 0; j < N; j++) 
                findWordsUtil(boggle, visited, i, j, str, hashSearch); 
    }

    // A recursive function to print all words present on boggle 
    static void findWordsUtil(char boggle[][], boolean visited[][], int i, int j, String str, boolean hashSearch) { 
        // Mark current cell as visited and append current character 
        // to str 
        visited[i][j] = true; 
        str = str + boggle[i][j]; 

        // If str is present in dictionary, then print it 
        if (hashSearch ? isWordMap(str) : isWord(str)) 
            System.out.println(str); 

        // Traverse 8 adjacent cells of boggle[i][j] 
        for (int row = i - 1; row <= i + 1 && row < M; row++) 
            for (int col = j - 1; col <= j + 1 && col < N; col++) 
                if (row >= 0 && col >= 0 && !visited[row][col]) 
                    findWordsUtil(boggle, visited, row, col, str, hashSearch); 

        // Erase current character from string and mark visited 
        // of current cell as false 
        str = "" + str.charAt(str.length() - 1); 
        visited[i][j] = false; 
    }

    // A given function to check if a given string is present in 
    // dictionary. The implementation is naive for simplicity. As 
    // per the question dictionary is given to us. 
    static boolean isWord(String str) { 
        // Linearly search all words 
        for (int i = 0; i < n; i++) 
            if (str.equals(dictionary[i])) 
                return true; 
        return false; 
    }

    static boolean isWordMap(String str) {
    	return wordMap.get(str.charAt(0)).get(str) != null;
    }
}
