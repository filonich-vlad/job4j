package ru.job4j.tracker;
import java.util.*;

/**
 * @version 0x000
 * @since 27.01.2019
 */
public class Tracker {
    /**
     * List для хранения заявок.
     */
    private final List<Item> items = new ArrayList<>();

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
        this.items.add(item);
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
        int index = 0;
        for (Item varitem : items) {
            if (varitem.getId().equals(id)) {
                item.setId(id);
                items.set(index, item);
                result = true;
                break;
            }
            index++;
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
        int index = 0;
        for (Item varitem : items) {
            if (varitem.getId().equals(id)) {
                items.remove(index);
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    /**
     * Получение списка всех заявок.
     * @return массив заявок без null'ов.
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Получение списка по имени.
     * @param name имя заявки.
     * @return массив заявок с именем name.
     */
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item != null && item.getName().equals(name)) {
                result.add(item);
            }
        }
        return result;
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
