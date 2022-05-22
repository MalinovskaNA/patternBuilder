package ru.netology.lessonN;

public class PersonBuilder {
    protected String name;
    protected String surname;
    private int age;
    private String city;

    public PersonBuilder() {
        super();
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        Person person = new Person(name, surname, age, city);
        if (person.hasAge() && (person.getAge() <= 0 || person.getAge() > 120)) {
            throw new IllegalArgumentException("Значение возраста не валидно!");
        } else if (person.getName() == null || person.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено имя!");
        } else if (person.getSurname() == null || person.getSurname().trim().isEmpty()) {
            throw new IllegalArgumentException("Не заполнена фамилия!");
        }
        return person;

    }
}
