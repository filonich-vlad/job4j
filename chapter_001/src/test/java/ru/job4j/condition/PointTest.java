package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void when00and34then5() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(3, 4);
        var result = point1.distanceTo(point2);
        assertThat(result, is(5D));
    }
}
