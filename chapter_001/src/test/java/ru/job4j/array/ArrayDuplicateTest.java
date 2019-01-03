package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;


public class ArrayDuplicateTest {

    ArrayDuplicate remover = new ArrayDuplicate();

    @Test
    public void whenThreeDuplicatesThenNoDuplicates() {
        String[] input = {"Under", "My", "Umbrella", "Ela", "Ela", "Ela", "Eh", "Eh"};
        String[] result = remover.removeDuplicates(input);
        String[] expected = {"Under", "My", "Umbrella", "Ela", "Eh"};
        assertThat(expected, arrayContainingInAnyOrder(result));
    }

    @Test
    public void whenNoDuplicatesThenChangeNothing() {
        String[] input = {"1", "2", "3", "Elochka Gori!"};
        String[] result = remover.removeDuplicates(input);
        assertThat(input, arrayContainingInAnyOrder(result));
    }

    @Test
    public void whenAllAreDuplicatesThenOneElement() {
        String[] input = {"1", "1", "1", "1"};
        String[] result = remover.removeDuplicates(input);
        String[] expected = {"1"};
        assertThat(expected, arrayContainingInAnyOrder(result));
    }
}
