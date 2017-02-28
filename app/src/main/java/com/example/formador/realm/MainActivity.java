package com.example.formador.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final User user = new User("3", "121212");
        Holiday holiday = new Holiday("3", new Date(), new Date(), Holiday.STATE_STANDBY);
        user.getHolidays().add(holiday);


        Realm realm = Realm.getDefaultInstance();



        realm.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealmOrUpdate(user);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        Log.i("myApp", "Success");

                    }
                },
                new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {

                        Log.i("myApp", error.getMessage());
                    }
                });
        RealmResults<User> users = realm.where(User.class).findAll();
        RealmResults<User> usersUnderAverage = users.where()
                .lessThan("age", users.average("age"))
                .findAll();

        /*
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(user);
            }
        });
        */

        /*
        realm.beginTransaction();

        realm.copyToRealmOrUpdate(user);

        realm.commitTransaction();*/

        realm.where(User.class).equalTo(User.INDEX_ID, "1").findFirst();


    }
}
