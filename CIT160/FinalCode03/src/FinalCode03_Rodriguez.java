public class FinalCode03_Rodriguez {
    public static void main(String[] args) {
        String helloWorld = "hello world!";
        for (int i = 0; i < helloWorld.length(); ++i) {
            helloWorld = helloWorld.substring(0, i).toUpperCase() + helloWorld.substring(i);
            if (helloWorld.charAt(i) != ' ')
                System.out.println(helloWorld);
        }
    }
}
