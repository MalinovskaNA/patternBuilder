package ru.netology.lessonN;

import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String city;

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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
        return age == person.age && name.equals(person.name) && surname.equals(person.surname) && city.equals(person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person [name=")
                .append(name).append(", surname=")
                .append(surname).append(", age=")
                .append(age).append(", city=")
                .append(city).append("]");
        return builder.toString();
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder person = new PersonBuilder();
        person.setName(name)
                //setName(name != null && !name.trim().isEmpty()?getName():name)
                .setSurname(surname)
                .setAddress(city).build();
        return person;
    }

}
