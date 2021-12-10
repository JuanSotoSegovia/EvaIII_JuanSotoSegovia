package com.example.evaiii_juansotosegovia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Obj_Class.pizzas;

public class ListadoPizza extends AppCompatActivity {

    //creamo objetos para almacenar los objetos de la vista
    private ListView listado;
    private Button eliminar;

    //creamos objetos de firebase
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    //objeto para almacenar seleccion
    pizzas pizzasSelect;

    //creamos un objeto de la clase pizzas que almacenara la pizza seleccionada
    pizzas p = new pizzas();

    //creamos un array list que alamcenara lo que contiene firebase
    private ArrayList<pizzas> listaPizzas = new ArrayList<>();
    //creamos el adaptador que nos permitira rellenar la lista
    ArrayAdapter<pizzas> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_pizza);

        //almacenamos los objetos de la vista
        listado = (ListView)findViewById(R.id.listView);
        eliminar = (Button)findViewById(R.id.btt_eliminar);

        //obtenemos la base de datos firebase
        obtenerBaseDatos();

        //metodo para obtener la selecciona de la lista
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //obtenemos la posicion
                pizzasSelect = (pizzas)parent.getItemAtPosition(position);
            }
        });

        //mostramos los datos en la lista
        databaseReference.child("Pizzas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //limpiamos la lista cada vez que haya un cambio y haci se refresca de inmediato
                listaPizzas.clear();

                //creamos un ciclo for que recorra la cantidad de pizzas
                for (DataSnapshot op : snapshot.getChildren()){
                    //creamos un objeto pizzas para ir almacenando la consulta de la base
                    pizzas p = op.getValue(pizzas.class);

                    //pasamos el objeto de pizzas a nustra lista
                    listaPizzas.add(p);

                    //llamamos a nuestro adaptador y lo rellenamos con nuestra lista
                    arrayAdapter = new ArrayAdapter<pizzas>(getBaseContext(), android.R.layout.simple_list_item_1, listaPizzas);

                    //llamamos nuestro objeto que contiene el listView y lo seteamos con el adaptador
                    listado.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    //metodo para inicializar y obtener la base de datos
    public void obtenerBaseDatos(){
        FirebaseApp.initializeApp(getBaseContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    //metodo para eliminar objeto seleccionado de la lista
    public void eliminarPizzas(View view) throws InterruptedException{
        //creamos un objeto de la clase pizzas que contendra el objeto seleccionado
        pizzas p = new pizzas();

        //seteamos el objeto con el id del objeto seleccionado de la lista
        p.setId(pizzasSelect.getId());

        //eliminamos el objeto de la base de datos segun el id seleccionado
        databaseReference.child("Pizzas").child(p.getId()).removeValue();

        //arrojamos mensaje flotante
        Toast.makeText(getBaseContext(),"Pizza Eliminada",Toast.LENGTH_SHORT).show();
    }
}