import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class NumberAnalyzerTest {

    @Test
    void sum_shouldReturnCorrectResult() {
        NumberAnalyzer na = new NumberAnalyzer();
        int[] numbers = new int[]{1, 2, 3};
        int result = na.sum(numbers);
        assertEquals(6, result);
    }

    @Test
    void average_shouldReturnCorrectResult() {
        NumberAnalyzer na = new NumberAnalyzer();
        int[] numbers = new int[]{2, 4, 6};
        double result = na.average(numbers);
        assertEquals(4.0, result, 1e-9); // delta = povolená odchýlka
    }

    @Test
    void average_shouldThrowExceptionOnEmptyArray() {
        NumberAnalyzer na = new NumberAnalyzer();
        int[] numbers = new int[]{};
        assertThrows(IllegalArgumentException.class, () -> na.average(numbers));
    }

    @Test
    void min_shouldReturnSmallestValue_withNegatives() {
        NumberAnalyzer na = new NumberAnalyzer();
        int[] numbers = new int[]{3, -1, -10, 5};
        assertEquals(-10, na.min(numbers));
    }

    @Test
    void max_shouldReturnLargestValue_mixed() {
        NumberAnalyzer na = new NumberAnalyzer();
        int[] numbers = new int[]{9, 0, -3, 4};
        assertEquals(9, na.max(numbers));
    }

    @Test
    void min_max_shouldThrowOnEmptyArray() {
        NumberAnalyzer na = new NumberAnalyzer();
        int[] empty = new int[]{};
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> na.min(empty)),
                () -> assertThrows(IllegalArgumentException.class, () -> na.max(empty))
        );
    }

    @Test
    void sortAscending_shouldReturnSortedCopy_andNotMutateInput() {
        NumberAnalyzer na = new NumberAnalyzer();
        int[] input = new int[]{3, 1, 2};
        int[] original = Arrays.copyOf(input, input.length);

        int[] sorted = na.sortAscending(input);

        // 1) vstup sa nezmenil
        assertArrayEquals(original, input, "Metóda nemá meniť pôvodné pole.");

        // 2) výstup je zoradený
        assertArrayEquals(new int[]{1, 2, 3}, sorted);
    }

    @Test
    void sortAscending_shouldHandleEmptyArray() {
        NumberAnalyzer na = new NumberAnalyzer();
        int[] sorted = na.sortAscending(new int[]{});
        assertArrayEquals(new int[]{}, sorted);
    }

    @Test
    void sortAscending_shouldThrowOnNull() {
        NumberAnalyzer na = new NumberAnalyzer();
        assertThrows(IllegalArgumentException.class, () -> na.sortAscending(null));
    }

    @Test
    void contains_shouldFindPresentValues_andReturnFalseOtherwise() {
        NumberAnalyzer na = new NumberAnalyzer();
        int[] data = new int[]{-1, 2, 2, 3};
        assertTrue(na.contains(data, -1));
        assertTrue(na.contains(data, 2));
        assertFalse(na.contains(data, 5));
        assertFalse(na.contains(null, 1)); // null-safe
    }

    @Test
    void indexOf_shouldReturnFirstIndex_orMinusOne() {
        NumberAnalyzer na = new NumberAnalyzer();
        int[] data = new int[]{5, 7, 7, 9};
        assertEquals(1, na.indexOf(data, 7));  // prvý výskyt
        assertEquals(-1, na.indexOf(data, 10));
        assertEquals(-1, na.indexOf(null, 5)); // null-safe
    }

}