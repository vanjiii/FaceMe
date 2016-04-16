package com.vanjiii.faceme.database;

import com.vanjiii.faceme.beans.Person;

import java.util.List;

/**
 * Interface, which defines which are the methods available to access the database.
 *
 * Created by vanjiii on 4/9/16.
 */
public interface DatabaseAdapter {

    /**
     * Store the given person bean to the database.
     *
     * @param person The person bean to store.
     * @return Boolean if the process was successful.
     */
    void storePerson(Person person );

    /**
     * Load person by its index in the database.
     *
     * @param index The index of the person which to fetch.
     * @return Person object or null if no such exists.
     */
    Person loadPerson(int index);

    /**
     * @return List of the objects in the database.
     */
    List<Person> loadAllPersons();
}
