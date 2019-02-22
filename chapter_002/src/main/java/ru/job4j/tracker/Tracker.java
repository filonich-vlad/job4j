package ru.job4j.tracker;
import java.util.*;

/**
 * @version 0x000
 * @since 27.01.2019
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Рандомайзер для генерации ключей.
     */
    private static final Random RN = new Random();

    /**
     * Добавление заявки в хранилище.
     * @param item новая заявка.
     * @return item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Редактирование заявки.
     * Заменяет заявку с ключом id, на новую.
     * @param id - ключ заявки.
     * @param item - новая заявка.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                item.setId(id);
                items[index] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Удаление заявки.
     * @param id - ключ заявки, которую удаляем.
     * @return true, если смогли удалить, false иначе.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int ind = 0; ind < position; ind++) {
            if (items[ind].getId().equals(id)) {
                System.arraycopy(items, ind + 1, this.items, ind, this.items.length - ind - 1);
                result = true;
                position--;
                break;
            }
        }
        return result;
    }

    /**
     * Получение списка всех заявок.
     * @return массив заявок без null'ов.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, position);
    }

    /**
     * Получение списка по имени.
     * @param name имя заявки.
     * @return массив заявок с именем name.
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[this.items.length];
        int ind = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(name)) {
                result[ind++] = item;
            }
        }
        return Arrays.copyOf(result, ind);
    }

    /**
     * Получение заявки по id.
     * @return заявка с ключом id.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * @return уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

}
