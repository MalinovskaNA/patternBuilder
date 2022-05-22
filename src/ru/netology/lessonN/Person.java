package ru.netology.lessonN;

import java.util.Objects;

public class Person {
    protected final String NAME;
    protected final String SURNAME;
    private int age;
    private String city;

    public Person(String name, String surname, int age, String city) {
        this.NAME = name;
        this.SURNAME = surname;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return NAME;
    }

    public String getSurname() {
        return SURNAME;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean hasAge() {
        return (age > 0);
    }

    public boolean hasAddress() {
        return (city != null && !city.trim().isEmpty());
    }

    public void happyBirthday() {
        age++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && NAME.equals(person.NAME) && SURNAME.equals(person.SURNAME) && city.equals(person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, SURNAME, age, city);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person [name=")
                .append(NAME).append(", surname=")
                .append(SURNAME).append(", age=")
                .append(age).append(", city=")
                .append(city).append("]");
        return builder.toString();
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder person = new PersonBuilder();
        person.setName(NAME)
                //setName(name != null && !name.trim().isEmpty()?getName():name)
                .setSurname(SURNAME)
                .setAddress(city).build();
        return person;
    }

}
