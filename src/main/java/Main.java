import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // outer loop
            int sum = 0;

            System.out.println("=== Number Analyzer ===");
            System.out.print("Enter integers separated by spaces: ");
            String input = scanner.nextLine().trim();

            String[] parts = input.split("\\s+");
            int[] numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }

            int min = numbers[0];
            int max = numbers[0];
            for (int n : numbers) {
                sum += n;
                if (n < min) min = n;
                if (n > max) max = n;
            }
            double average = (double) sum / numbers.length;

            System.out.println("Sum: " + sum);
            System.out.printf("Average: %.2f%n", average);
            System.out.println("Minimum: " + min);
            System.out.println("Maximum: " + max);

            int[] sorted = Arrays.copyOf(numbers, numbers.length);
            Arrays.sort(sorted);
            System.out.println("Sorted: " + Arrays.toString(sorted));

            // inner loop – repeated search
            while (true) {
                System.out.print("Enter a number to search for (0 = exit): ");

                if (scanner.hasNextInt()) {
                    int search = scanner.nextInt();
                    scanner.nextLine(); // consume end of line

                    if (search == 0) break;

                    boolean found = false;
                    for (int n : numbers) {
                        if (n == search) { found = true; break; }
                    }
                    System.out.println(found
                            ? "The number is in the input ✅."
                            : "The number is not in the input ❌.");
                } else {
                    // not an integer -> inform and retry
                    scanner.nextLine(); // discard invalid input
                    System.out.println("Please enter a valid integer.");
                }
            }

            // confirmation for a new run
            while (true) {
                System.out.print("Do you want to enter new numbers? (yes/no): ");
                String answer = scanner.nextLine().trim().toLowerCase();
                if (answer.equals("yes") || answer.equals("y")) {
                    break; // break only this question loop
                } else if (answer.equals("no") || answer.equals("n")) {
                    System.out.println("Analysis completed.");
                    return; // exit program
                } else {
                    System.out.println("Please enter only 'yes' or 'no'.");
                }
            }
        }
    }
}