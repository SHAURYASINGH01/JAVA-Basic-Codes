import java.util.*;
public class Main {
    public static void main(String[] args) {
       //..... YOUR CODE STARTS HERE .....
       
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input
        String[] words = scanner.nextLine().split(" ");
        Map<Integer, List<String>> groupedWords = new HashMap<>();
        for (String word : words) {
            int length = word.length();
            groupedWords.putIfAbsent(length, new ArrayList<>());
            groupedWords.get(length).add(word);
        }
        for (Map.Entry<Integer, List<String>> entry : groupedWords.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
       
       //..... YOUR CODE ENDS HERE .....
    }
}
