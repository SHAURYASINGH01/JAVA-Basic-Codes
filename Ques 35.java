import java.util.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) {
        //..... YOUR CODE STARTS HERE .....
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }
        // Lambda expression to compute the sum of even numbers
        int sumOfEvens = numbers.stream()
            .filter(num -> num % 2 == 0)
            .mapToInt(Integer::intValue)
            .sum();
        // Lambda expression to compute the product of odd numbers
        int productOfOdds = numbers.stream()
            .filter(num -> num % 2 != 0)
            .reduce(1, (a, b) -> a * b);
        // Calculate the difference
        int difference = sumOfEvens - productOfOdds;
        System.out.println(difference);
        
        //..... YOUR CODE ENDS HERE .....
    }
}
