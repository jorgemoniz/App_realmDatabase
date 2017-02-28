package com.example.formador.realm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by formador on 14/2/17.
 */

public class RealmApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        /*
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myrealm.realm")
                .schemaVersion(42)
                .build();

        Realm.setDefaultConfiguration(config);*/

    }
}
