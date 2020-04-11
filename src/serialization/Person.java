package serialization;

import java.io.Serializable;

/**
 * Сделать клиен-серверное приложение. Передать по сети сеарилизованный объект
 */

public class Person implements Serializable {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+ ", " + name + ", " + age + ", " + address;
    }
}
