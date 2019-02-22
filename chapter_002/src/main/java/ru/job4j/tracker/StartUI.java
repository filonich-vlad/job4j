package ru.job4j.tracker;

public class StartUI {
    /**
     * Константы меню.
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";

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
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Показывает меню и просит вас выбрать пункт. Если выбрать не существующий пункт, будете перевыбирать.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
               this.show();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            } else {
                System.out.println("Нет такого пункта меню.");
            }

        }
    }

    /**
     * Показывает меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0 - Добавить заявку.");
        System.out.println("1 - Показать все заявки.");
        System.out.println("2 - Редактирвоать заявку.");
        System.out.println("3 - Удалить заявку.");
        System.out.println("4 - Найти заявку по ключу.");
        System.out.println("5 - Найти заявку по имени.");
        System.out.println("6 - Выход.");
    }

    /**
     * Метод добавляет новую заявку в хранилище.
     */
    private void createItem() {
        System.out.println("----------- Добавление новой заявки -----------");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с id = " + item.getId() + " добавлена.-----");
    }

    /**
     * Метод редактирования заявки. Старая заявка в хранилище перетирается новой, с новым именем и описанием.
     */
    private void editItem() {
        System.out.println("-----------Редактирование заявки-----------");
        String id = this.input.ask("Введите id заявки : ");
        Item item = this.tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка с данным id не найдена.");
        } else {
            System.out.println("Старое имя заявки: " + item.getName());
            String newName = this.input.ask("Введите новое имя заявки :");
            System.out.println("Старое описание заявки : " + item.getDescription());
            String newDesc = this.input.ask("Введите новое описание заявки :");
            Item newItem = new Item(newName, newDesc, item.getCreate());
            this.tracker.replace(id, newItem);
            System.out.println("Заявка изменена.");
        }

    }

    /**
     * Удаление заявки.
     */
    private void deleteItem() {
        System.out.println("--------------Удаление заявки-----------------");
        String id = this.input.ask("Введите id заявки : ");
        if (this.tracker.delete(id)) {
            System.out.println("Заявка удалена.");
        } else {
            System.out.println("Заявка не удалена. Возможно неверный id.");
        }
    }

    /**
     * Поиск по ключу. Выдаёт имя и описание.
     */
    private void findById() {
        String id = this.input.ask("Введите id заявки: ");
        Item item =  this.tracker.findById(id);
        if (item != null) {
            System.out.printf("Имя : %s%nОписание :%s%n", item.getName(), item.getDescription());
        } else {
            System.out.println("Нет заявок с таким id.");
        }
    }

    /**
     * Поиск по имени. Выдаёт имя, ключ и описание.
     */
    private void findByName() {
        String name = this.input.ask("Введите имя заявки: ");
        Item[] items = this.tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("Заявок с таким именем нет");
        } else {
            for (Item item : items) {
                System.out.printf("Имя : %s%nid : %s%nОписание : %s%n", item.getName(), item.getId(), item.getDescription());
            }
        }
    }

    /**
     * Показать все заявки. А именно их имена, ключи и описание.
     */

    private void show() {
        if (tracker.findAll().length == 0) {
            System.out.println("Нет ни одной заявки.");
        } else {
            for (Item item : tracker.findAll()) {
                System.out.printf("Имя : %s, id : %s%n", item.getName(), item.getId());
            }
        }
    }
}
