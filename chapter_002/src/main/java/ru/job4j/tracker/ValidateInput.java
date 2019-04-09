package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        int value = -1;
        boolean invalid = true;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Введите число из верного диапазона");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите корректные данные: ");
            }
        } while (invalid);
        return value;
    }
}
