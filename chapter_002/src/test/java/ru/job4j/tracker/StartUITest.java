package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

private final PrintStream stdOut = System.out;
private final ByteArrayOutputStream out = new ByteArrayOutputStream();

private String sep = System.lineSeparator();

private String menu = "Меню:"
        + sep
        + "0 - Добавить заявку."
        + sep
        + "1 - Показать все заявки."
        + sep
        + "2 - Редактирвоать заявку."
        + sep
        + "3 - Удалить заявку."
        + sep
        + "4 - Найти заявку по ключу."
        + sep
        + "5 - Найти заявку по имени.";

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void loadBack() {
        System.setOut(this.stdOut);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        String result = menu
                + sep
                + "----------- Добавление новой заявки -----------"
                + sep
                + "------------ Новая заявка с id = " + tracker.findAll().get(0).getId() + " добавлена.-----"
                + sep;
        assertThat(new String(out.toByteArray()), is(result));
    }


    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        new StartUI(input, tracker).init();
        String result = menu + sep
                + "-----------Редактирование заявки-----------"
                + sep
                + "Старое имя заявки: test name"
                + sep
                + "Старое описание заявки : desc"
                + sep
                + "Заявка изменена."
                + sep;
        assertThat(new String(out.toByteArray()), is(result));
    }

    @Test
    public void whenDeleteThenItemDisapears() {
        Tracker tracker = new Tracker();
        Item item2 = tracker.add(new Item("i am gonna be deleted", "desc"));
        Input input = new StubInput(new String[]{"3", item2.getId(), "y"});
        new StartUI(input, tracker).init();
        String result = menu
                + sep
                + "--------------Удаление заявки-----------------"
                + sep
                + "Заявка удалена."
                + sep;
        assertThat(new String(out.toByteArray()), is(result));
    }

    @Test
    public void whenFindByIdThenItWorksFine() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        String result = menu
                + sep
                + "Имя : test name"
                + sep
                + "Описание :desc"
                + sep;
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(result));
    }

    @Test
    public void whenFindByNameThenItWorks() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", "test name", "y"});
        String result = menu
                + sep
                + "Имя : test name"
                + sep
                + "id : "
                + item.getId()
                + sep
                + "Описание : desc"
                + sep;
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(result));
    }

    @Test
    public void whenTypeNAN() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new ValidateInput(new StubInput(new String[]{"a", "5", "test name", "y"}));
        String result = menu
                + sep
                + "Введите корректные данные: "
                + sep
                + "Имя : test name"
                + sep
                + "id : "
                + item.getId()
                + sep
                + "Описание : desc"
                + sep;
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(result));
    }

    @Test
    public void whenTypeNotInOptionsRange() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new ValidateInput(new StubInput(new String[]{"-1", "5", "test name", "y"}));
        String result = menu
                + sep
                + "Введите число из верного диапазона: "
                + sep
                + "Имя : test name"
                + sep
                + "id : "
                + item.getId()
                + sep
                + "Описание : desc"
                + sep;
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(result));
    }
}