package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenGetEmptyArrayFromFindAllMethod() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void whenDeleteFromTheMiddleThenGetOneLess() {
        Tracker tracker = new Tracker();
        Item item0 = new Item("test0", "testDescription", 123L);
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2.getId());
        ArrayList<Item> expected = new ArrayList<>() { {
                add(item0);
                add(item1);
                add(item3);
            } };
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenFindByNameThenGetWhatIsSupposed() {
        Tracker tracker = new Tracker();
        Item item0 = new Item("test0", "testDescription", 123L);
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        Item item4 = new Item("test3", "testDescription", 123L);
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        ArrayList<Item> expected = new ArrayList<>() { {
            add(item3);
            add(item4);
        } };
        assertThat(tracker.findByName("test3"), is(expected));
    }
}
