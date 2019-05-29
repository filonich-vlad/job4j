package ru.job4j.tracker;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int[] getRange() {
        int[] out = new int[this.actions.length];
        for (int i = 0; i < this.actions.length; i++) {
            out[i] = i;
        }
        return out;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
    }

    /**
     * Select and execute.
     * @param key - key of action.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        System.out.println("Меню:");
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Classes for each of the menu options.
     */

    private class AddItem extends BaseAction {

        public AddItem() {
            super("Добавить заявку.", 0);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("----------- Добавление новой заявки -----------");
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с id = " + item.getId() + " добавлена.-----");
        }
    }

    private class EditItem extends BaseAction {

        public EditItem() {
            super("Редактирвоать заявку.", 2);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("-----------Редактирование заявки-----------");
            String id = input.ask("Введите id заявки : ");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Заявка с данным id не найдена.");
            } else {
                System.out.println("Старое имя заявки: " + item.getName());
                String newName = input.ask("Введите новое имя заявки :");
                System.out.println("Старое описание заявки : " + item.getDescription());
                String newDesc = input.ask("Введите новое описание заявки :");
                Item newItem = new Item(newName, newDesc, item.getCreate());
                tracker.replace(id, newItem);
                System.out.println("Заявка изменена.");
            }
        }
    }

    private class ShowItems extends BaseAction {

        public ShowItems() {
            super("Показать все заявки.", 1);
        }

        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAll();
            if (items.length == 0) {
                System.out.println("Нет ни одной заявки.");
            } else {
                for (Item item : items) {
                    System.out.printf("Имя : %s, id : %s%n", item.getName(), item.getId());
                }
            }
        }
    }

    private class DeleteItem extends BaseAction {

        public DeleteItem() {
            super("Удалить заявку.", 3);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("--------------Удаление заявки-----------------");
            String id = input.ask("Введите id заявки : ");
            if (tracker.delete(id)) {
                System.out.println("Заявка удалена.");
            } else {
                System.out.println("Заявка не удалена. Возможно неверный id.");
            }
        }
    }

    private class FindById extends BaseAction {

        public FindById() {
            super("Найти заявку по ключу.", 4);
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки: ");
            Item item =  tracker.findById(id);
            if (item != null) {
                System.out.printf("Имя : %s%nОписание :%s%n", item.getName(), item.getDescription());
            } else {
                System.out.println("Нет заявок с таким id.");
            }
        }
    }

    private class FindByName extends BaseAction {

        public FindByName() {
            super("Найти заявку по имени.", 5);
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки: ");
            Item[] items = tracker.findByName(name);
            if (items.length == 0) {
                System.out.println("Заявок с таким именем нет");
            } else {
                for (Item item : items) {
                    System.out.printf("Имя : %s%nid : %s%nОписание : %s%n", item.getName(), item.getId(), item.getDescription());
                }
            }
        }
    }


}
