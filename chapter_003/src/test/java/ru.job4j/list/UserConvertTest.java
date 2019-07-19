package ru.job4j.list;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserConvertTest {
    UserConvert converter = new UserConvert();
    @Test
    public void when2Users() {
        List<User> input = new ArrayList<>() { {
            add(new User(1, "Gabriel", "Bucharest"));
            add(new User(2,  "Clarence", "Dublin"));
        } };

        HashMap<Integer, User> result = converter.process(input);

        assertThat(result.get(2).getCity(), is("Dublin"));
    }
}
