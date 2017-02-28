package com.example.formador.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by formador on 7/2/17.
 */

public class User extends RealmObject {

    public static final String INDEX_ID = "id";

    @PrimaryKey
    private String id;
    private String mail;
    private RealmList<Holiday> holidays = new RealmList<>();

    public User() {
    }

    public User(String id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    public User(String mail) {
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public RealmList<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(RealmList<Holiday> holidays) {
        this.holidays = holidays;
    }
}
