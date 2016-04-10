package com.vanjiii.faceme.beans;

import com.vanjiii.faceme.constants.GenderEnum;

/**
 * Bean that represents a object to manipulate.
 *
 * Created by vanjiii on 4/9/16.
 */
public class Person {

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
}
