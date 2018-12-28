package ru.job4j.condition;

/**
 * @author Vladislav Filonich
 * @version $Id$
 * @since 28.12.18
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в турик. Спровите что-нибудь другое.";
        if ("Привет, бот.".equals(question)) {
            rsl = "Привет, умник!";
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи!";
        }
        return rsl;
     }
}