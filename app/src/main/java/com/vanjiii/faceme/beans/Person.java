package com.vanjiii.faceme.beans;

import com.vanjiii.faceme.constants.GenderEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean that represents a object to manipulate.
 * <p>
 * Created by vanjiii on 4/9/16.
 */
public class Person {

    //TODO: Remove face with person.
    //TODO Remove photo with picture.

    private int id;
    private String pictureUri;
    private String name;
    private int age;
    private GenderEnum sex;

    public Person() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(String pictureUri) {
        this.pictureUri = pictureUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GenderEnum getSex() {
        return sex;
    }

    public void setSex(GenderEnum sex) {
        this.sex = sex;
    }

    public static List<Person> getAllPersons() {
        //TODO Remove mock and use DB to get persons

        //mock
        List<Person> persons = new ArrayList<>();
        Person p = new Person();
        p.setAge(19);
        p.setName("Kiro");
        p.setPictureUri("sdcard/folder/1.png");
        p.setSex(GenderEnum.MALE);
        persons.add(p);

        p.setAge(21);
        p.setName("Ivo");
        p.setPictureUri("sdcard/folder/2.png");
        p.setSex(GenderEnum.MALE);
        persons.add(p);

        p.setAge(37);
        p.setName("Tsveti");
        p.setPictureUri("sdcard/folder/3.png");
        p.setSex(GenderEnum.FEMALE);
        persons.add(p);

        return persons;
    }

}
