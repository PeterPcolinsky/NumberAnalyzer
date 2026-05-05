import java.util.Arrays;
import java.util.Scanner;

/**
 * Simple console application for analyzing integer numbers.
 *
 * <p>The program allows the user to enter integers separated by spaces
 * and displays basic statistics such as sum, average, minimum, maximum
 * and sorted numbers.</p>
 *
 * <p>The user can also search for specific numbers in the entered input
 * and repeat the analysis with a new set of numbers.</p>
 */
public class Main {

    /**
     * Entry point of the application.
     *
     * <p>Handles user input, calls {@link NumberAnalyzer} methods
     * and prints the analysis results to the console.</p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberAnalyzer na = new NumberAnalyzer();

        while (true) {
            System.out.println("=== Number Analyzer ===");
            System.out.print("Enter integers separated by spaces: ");
            String input = scanner.nextLine().trim();

            int[] numbers = parseNumbers(input);

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

            handleSearch(scanner, na, numbers);

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

    /**
     * Parses a string of space-separated integers into an array.
     *
     * @param input user input string
     * @return array of integers
     */
    private static int[] parseNumbers(String input) {
        String[] parts = input.split("\\s+");
        int[] numbers = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            try {
                numbers[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + parts[i] + ". Using 0 instead.");
                numbers[i] = 0;
            }
        }

        return numbers;
    }

    /**
     * Handles searching numbers in the input array.
     *
     * @param scanner scanner for user input
     * @param analyzer number analyzer instance
     * @param numbers array of numbers
     */
    private static void handleSearch(Scanner scanner, NumberAnalyzer analyzer, int[] numbers) {
        while (true) {
            System.out.print("Enter a number to search for (0 = exit): ");

            if (scanner.hasNextInt()) {
                int search = scanner.nextInt();
                scanner.nextLine(); // consume EOL

                if (search == 0) break;

                boolean found = analyzer.contains(numbers, search);

                System.out.println(found
                        ? "The number is in the input ✅."
                        : "The number is not in the input ❌.");
            } else {
                scanner.nextLine();
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}