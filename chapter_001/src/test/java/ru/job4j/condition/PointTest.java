package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void when00and34then5() {
        Point point_1 = new Point(0, 0);
        Point point_2 = new Point(3, 4);
        var result = point_1.distanceTo(point_2);
        assertThat(result, is(5D));
    }
}
