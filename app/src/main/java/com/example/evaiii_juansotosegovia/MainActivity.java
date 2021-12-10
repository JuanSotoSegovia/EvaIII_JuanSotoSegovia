package com.example.evaiii_juansotosegovia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //intents explicitos
    public void gestion(View view){
        Intent i = new Intent(getBaseContext(), GestionPizza.class);
        startActivity(i);
    }

    public void listado(View view){
        Intent i = new Intent(getBaseContext(), ListadoPizza.class);
        startActivity(i);
    }

    public void armarPizza(View view){
        Intent i = new Intent(getBaseContext(), ArmarPizza.class);
        startActivity(i);
    }

    //intents implicitos
    public void facebook(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com/LittleCaesarsChile/"));
        startActivity(i);
    }

    public void instagram(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.instagram.com/littlecaesarschile/?hl=es"));
        startActivity(i);
    }

    public void twitter(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://twitter.com/littlecaesars?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"));
        startActivity(i);
    }

    public void youtube(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/watch?v=Ivfbvv3b14Q"));
        startActivity(i);
    }
}