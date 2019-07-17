package ru.job4j.search;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByPhoneNumber() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Barak", "Obama", "890902394", "NY")
        );
        List<Person> persons = phones.find("89090");
        assertThat(persons.iterator().next().getName(), is("Barak"));
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Barak", "Obama", "890902394", "NY")
        );
        List<Person> persons = phones.find("NY");
        assertThat(persons.iterator().next().getName(), is("Barak"));
    }

    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Barak", "Obama", "890902394", "NY")
        );
        List<Person> persons = phones.find("Obama");
        assertThat(persons.iterator().next().getName(), is("Barak"));
    }
}