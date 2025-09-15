import java.util.Arrays;

public class NumberAnalyzer {

    public int sum(int[] numbers) {
        int s = 0;
        for (int n : numbers) s += n;
        return s;
    }

    public double average(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Pole nesmie byť prázdne.");
        }
        int sum = sum(numbers);  // využijeme už existujúcu metódu
        return (double) sum / numbers.length;
    }

    public int min(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Pole nesmie byť prázdne.");
        }
        int m = numbers[0];
        for (int n : numbers) {
            if (n < m) m = n;
        }
        return m;
    }

    public int max(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Pole nesmie byť prázdne.");
        }
        int m = numbers[0];
        for (int n : numbers) {
            if (n > m) m = n;
        }
        return m;
    }

    public int[] sortAscending(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Pole nesmie byť null.");
        }
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(copy);
        return copy;
    }

    public boolean contains(int[] numbers, int value) {
        if (numbers == null) return false;
        for (int n : numbers) {
            if (n == value) return true;
        }
        return false;
    }

    public int indexOf(int[] numbers, int value) {
        if (numbers == null) return -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == value) return i;
        }
        return -1;
    }

}