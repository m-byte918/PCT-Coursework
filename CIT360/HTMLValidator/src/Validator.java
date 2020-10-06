import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validator {

	public static void main(String[] args) throws IOException {
		Path file = Paths.get("./index.html");
		StringBuilder sb = new StringBuilder();

		for (String line : Files.readAllLines(file)) {
			sb.append(line);
		}
		System.out.println(isValidHTML(sb.toString()));
	}

	public static boolean isValidHTML(String html) {
		Stack<String> stack = new ArrayStack<String>(html.length());

		int start = html.indexOf("<");
		int end;
		String tag;

		while (start != -1) {
			end = html.indexOf(">", start + 1);

			if (end == -1)
				return false;

			tag = html.substring(start + 1, end);

			if (!tag.startsWith("/"))
				stack.push(tag);
			else if (!tag.substring(1).equals(stack.pop()))
				return false;

			start = html.indexOf("<", end + 1);
		}
		return stack.isEmpty();
	}
}
