import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberAnalyzer na = new NumberAnalyzer();

        while (true) {
            System.out.println("=== Number Analyzer ===");
            System.out.print("Enter integers separated by spaces: ");
            String input = scanner.nextLine().trim();

            String[] parts = input.split("\\s+");
            int[] numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }

            int sum = na.sum(numbers);
            double average = na.average(numbers);
            int min = na.min(numbers);
            int max = na.max(numbers);
            int[] sorted = na.sortAscending(numbers);

            System.out.println("Sum: " + sum);
            System.out.printf("Average: %.2f%n", average);
            System.out.println("Minimum: " + min);
            System.out.println("Maximum: " + max);
            System.out.println("Sorted: " + Arrays.toString(sorted));

            while (true) {
                System.out.print("Enter a number to search for (0 = exit): ");
                if (scanner.hasNextInt()) {
                    int search = scanner.nextInt();
                    scanner.nextLine(); // consume EOL
                    if (search == 0) break;

                    boolean found = na.contains(numbers, search);
                    System.out.println(found
                            ? "The number is in the input ✅."
                            : "The number is not in the input ❌.");
                } else {
                    scanner.nextLine();
                    System.out.println("Please enter a valid integer.");
                }
            }

            while (true) {
                System.out.print("Do you want to enter new numbers? (yes/no): ");
                String answer = scanner.nextLine().trim().toLowerCase();
                if (answer.equals("yes") || answer.equals("y")) break;
                else if (answer.equals("no") || answer.equals("n")) {
                    System.out.println("Analysis completed.");
                    return;
                } else {
                    System.out.println("Please enter only 'yes' or 'no'.");
                }
            }
        }
    }
}