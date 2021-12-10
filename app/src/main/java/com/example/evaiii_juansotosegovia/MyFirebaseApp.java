package com.example.evaiii_juansotosegovia;


import com.google.firebase.database.FirebaseDatabase;

//clase que nos permite hacer posible la persistencia de datos
public class MyFirebaseApp extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();

        //activamos la persistencia para que cuando no tengamos internet
        //y hagamos cambios en la app se guarden igual en firebase una ves
        //tengamos internet
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
