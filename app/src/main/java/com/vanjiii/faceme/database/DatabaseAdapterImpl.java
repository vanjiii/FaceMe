package com.vanjiii.faceme.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.gson.JsonParser;
import com.vanjiii.faceme.beans.Person;
import com.vanjiii.faceme.constants.DatabaseConstants;
import com.vanjiii.faceme.constants.GenderEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of database adapter.
 *
 * Created by vanjiii on 4/10/16.
 */
public class DatabaseAdapterImpl implements DatabaseAdapter{

    // Where clauses constants
    private static final String PERSON_WHERE = DatabaseHelper.COLUMN_ID + " = ?";

    private Context context;

    public DatabaseAdapterImpl(Context context) {
        this.context = context;
    }

    @Override
    public void storePerson(Person person) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();
        storePerson(database, person);
        database.close();
    }

    @Override
    public Person loadPerson(int index) {
        return loadPerson(null, index);
    }

    @Override
    public List<Person> loadAllPersons() {
        Log.i(DatabaseHelper.LOG_TAG, "Loading all the faces from the database.");
        List<Person> persons = loadPersonsHelper(null, null);
        if (persons != null) {
            Log.v(DatabaseHelper.LOG_TAG, "Retrieved " + persons.size() + " faces from the DB.");
        } else {
            Log.w(DatabaseHelper.LOG_TAG, "Error when obtaining the faces from the database.");
        }
        return persons;
    }

    private void storePerson(SQLiteDatabase database, Person person) {
        //TODO: fix logging
        Log.v(DatabaseHelper.LOG_TAG, "Storing face in the database: " + person.getName());
//                + new JsonParser(context).serializeFace(person));
        ContentValues values = new ContentValues();
        //TODO:  remove input id as input var
//        values.put(DatabaseHelper.COLUMN_ID, person.getId());
        values.put(DatabaseHelper.COLUMN_PICTURE_URI, person.getInitialPhotoUri());
        values.put(DatabaseHelper.COLUMN_PERSON_NAME, person.getName());
        values.put(DatabaseHelper.COLUMN_PERSON_AGE, person.getAge());
        values.put(DatabaseHelper.COLUMN_PERSON_SEX, person.getSex().getValue());
        values.put(DatabaseHelper.COLUMN_IS_SENT_TO_SERVER, person.isSentToServer().getValueInt());

        //TODO: add working criteria to look for existing record
        if (loadPerson(database, person.getId()) != null) {
            String [] whereArgs = { String.valueOf(person.getId()) };
            database.update(DatabaseHelper.TABLE_PICTURES, values, PERSON_WHERE, whereArgs);
        } else {
            database.insert(DatabaseHelper.TABLE_PICTURES, null, values);
        }
    }

    private Person loadPerson(SQLiteDatabase database, int index) {
        //TODO: add 
        Log.v(DatabaseHelper.LOG_TAG, "Loading face with index " + index + " from the DB.");
        String [] whereArgs = { String.valueOf(index) };
        List<Person> persons;
        if (database == null) {
            persons = loadPersonsHelper(PERSON_WHERE, whereArgs);
        } else {
            persons = loadPersonsHelper(database, PERSON_WHERE, whereArgs);
        }

        if (persons != null && persons.size() > 0) {
            Log.v(DatabaseHelper.LOG_TAG, "Person retrieval successful.");
            return persons.get(0);
        } else {
            Log.w(DatabaseHelper.LOG_TAG, "Problem while retrieving the person.");
            return null;
        }
    }

    private List<Person> loadPersonsHelper(String where, String[] whereArgs) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        List<Person> faces = loadPersonsHelper(database, where, whereArgs);
        database.close();
        return faces;
    }

    private List<Person> loadPersonsHelper(SQLiteDatabase database, String where, String[] whereArgs) {
        String [] columns = { DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_PICTURE_URI,DatabaseHelper
                .COLUMN_PERSON_NAME,  DatabaseHelper.COLUMN_PERSON_AGE, DatabaseHelper.COLUMN_PERSON_SEX,
                DatabaseHelper.COLUMN_IS_SENT_TO_SERVER };
        Cursor cursor = database.query(DatabaseHelper.TABLE_PICTURES, columns, where,
                whereArgs, null, null, null);
        List<Person> persons = new ArrayList<>();
        try {
            if (cursor != null && cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_ID);
                int pictureUriIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_PICTURE_URI);
                int nameIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_PERSON_NAME);
                int ageIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_PERSON_AGE);
                int sexIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_PERSON_SEX);
                int isSentIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_IS_SENT_TO_SERVER);

                do {
                    Person person = new Person();
                    person.setId(cursor.getInt(idIndex));
                    person.setInitialPhotoUri(cursor.getString(pictureUriIndex));
                    person.setName(cursor.getString(nameIndex));
                    person.setAge(cursor.getShort(ageIndex));
                    person.setSex(GenderEnum.getGenderForValue(cursor.getString(sexIndex)));
                    person.setIsSentToServer(DatabaseConstants.getStateForValue(cursor.getInt(isSentIndex)));

                    persons.add(person);
                } while (cursor.moveToNext());
                cursor.close();
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return persons;
    }
}
