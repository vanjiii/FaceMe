package com.vanjiii.faceme.beans;

import android.content.Context;

import com.vanjiii.faceme.constants.DatabaseConstants;
import com.vanjiii.faceme.constants.GenderEnum;
import com.vanjiii.faceme.database.DatabaseAdapterImpl;

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
    private String photoUri;
    private String name;
    private int age;
    private GenderEnum sex;
    private DatabaseConstants isSentToServer;

    public Person() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
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

    public static List<Person> getAllPersons(Context context) {
        DatabaseAdapterImpl database = new DatabaseAdapterImpl(context);
        return database.loadAllPersons();
    }

    public DatabaseConstants isSentToServer() {
        return isSentToServer;
    }

    public void setIsSentToServer(DatabaseConstants isSentToServer) {
        this.isSentToServer = isSentToServer;
    }
}
