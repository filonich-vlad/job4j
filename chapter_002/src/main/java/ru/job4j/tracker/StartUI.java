package ru.job4j.tracker;

public class StartUI {
    /**
     * Получение данный от полььзователья
     */
    private final Input input;

    /**
     * Трекер заявок.
     */
    private final Tracker tracker;

    /**
     * Конструетор ининциализаций поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Запуск программы
     * @param args - аргументы для входа.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Введите пункт меню : ", menu.getRange()));
        } while (!"y".equals(this.input.ask("Exit? (y) ")));
    }
}
