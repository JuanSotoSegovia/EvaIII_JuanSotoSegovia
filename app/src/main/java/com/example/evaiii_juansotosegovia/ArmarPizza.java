package com.example.evaiii_juansotosegovia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Obj_Class.ingredientes;
import Obj_Class.pizzas;

public class ArmarPizza extends AppCompatActivity {

    //declaramos objetos que contega os objetos de la vista
    private Spinner spPizzas, spIngredientes;
    private Button calcular;
    private TextView resultado;

    //creamos objetos de firebase
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    //creamos objetos de clases
    ingredientes ing = new ingredientes();
    pizzas piz = new pizzas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armar_pizza);

        //alamacenamos los objetos de la vista en los objetos ya creados
        spPizzas = (Spinner)findViewById(R.id.spn_pizza);
        spIngredientes = (Spinner)findViewById(R.id.spn_ingrediente);
        calcular = (Button)findViewById(R.id.btt_calcular);
        resultado = (TextView)findViewById(R.id.txt_resultado);

        //pasamos datos a nuestro objeto de firebase
        databaseReference = FirebaseDatabase.getInstance().getReference();

        //llamamos al metodo que rellena el spinner de las pizzas
        datosSpinnerPizzas();

        //creamos adaptador con que contiene los ingredientes
        ArrayAdapter arrayAdapterIn = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, ing.getNombre());

        //rellenamos el spinner de ingredientes con el adaptador creado enteriormente
        spIngredientes.setAdapter(arrayAdapterIn);
    }

    //metodo para rellenar spinner pizzas
    public void datosSpinnerPizzas(){

        //creamos una lista que almacenara los datos sacados de firebase
        List<pizzas> pizzas = new ArrayList<>();
        //iniciamos la extraccion de datos de firebase
        databaseReference.child("Pizzas").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //validamos existencia de datos
                if (snapshot.exists()){
                    //ciclo for para recorrer nuestra firebase
                    for (DataSnapshot lp : snapshot.getChildren()){
                        //almacenamos el nombre de la pizza
                        String nombrePizza = lp.child("nombre").getValue().toString();

                        //añadimos las pizzas a nuestra lista a trabes de la creacion de un objeto
                        pizzas.add(new pizzas(nombrePizza));
                    }
                    //creamos adaptador que contiene las pizzas traidas de firebas
                    ArrayAdapter<pizzas> arrayAdapter = new ArrayAdapter<pizzas>(getBaseContext(), android.R.layout.simple_dropdown_item_1line, pizzas);
                    //rellenamos el spiner de las pizzas con el adaptador anteriomente credo
                    spPizzas.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    //metodo calcular que sirve para calcular el total de la pizza con el ingrediente seleccionado
    public void calcular(View view){

        //variable que alamcenan los elementos seleccionados en los spiner pizzas y ingredientes
        String nomPiz = spPizzas.getSelectedItem().toString();
        String nomIng = spIngredientes.getSelectedItem().toString();

        //listas que alamacenaran los nombres y precios de las pizzas
        List<String> pizzasNombre = new ArrayList<>();
        List<String> pizzasPrecio = new ArrayList<>();

        //iniciamos la extraccion de datos de firebase
        databaseReference.child("Pizzas").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //validamos existenvia de datos
                if (snapshot.exists()) {
                    //ciclo for para recorrer nestra firebase
                    for (DataSnapshot lp : snapshot.getChildren()) {
                        //almacenamos el nombre de la pizza y el precio
                        String nombrePizza = lp.child("nombre").getValue().toString();
                        String precioPizza = lp.child("precio").getValue().toString();

                        //añadimos las pizzaqs y precios a nuestras listas
                        pizzasNombre.add(nombrePizza);
                        pizzasPrecio.add(precioPizza);

                    }

                    //ciclo for ultilizado para recorrer las pizzas y los ingredientes
                    for (int i = 0; i <= 100; i++) {

                        //condicional que consulta por igualdad de nombre de pizza seleccionado
                        if (nomPiz.equals(pizzasNombre.get(i))){

                            try {

                                //condicional que consulta por ingrediente seleccionado
                                if (nomIng.equals(ing.getNombre()[0])){

                                    //variable de tipo int que alamcena el precio de la pizza segun indice
                                    int precioPizza = Integer.parseInt(pizzasPrecio.get(i));
                                    //variable de tipo int que alamcena el precio del ingrediente seleccionado
                                    int precioIngrediente = ing.getPrecio()[0];
                                    //variable de tipo int que alamcena el total del precio pizza y precio ingrediente
                                    int total = precioPizza+precioIngrediente;

                                    //variable de tipo string que alamcena la conversion de la variable int total
                                    String precioTotal = String.valueOf(total);

                                    //seteo de objeto textview resltado.
                                    resultado.setText(nomPiz + ", con " + ing.getNombre()[0] + ", tiene un costo de: " + precioTotal);
                                    break;
                                }

                                else if (nomIng.equals(ing.getNombre()[1])){
                                    int precioPizza = Integer.parseInt(pizzasPrecio.get(i));
                                    int precioIngrediente = ing.getPrecio()[1];

                                    int total = precioPizza+precioIngrediente;

                                    String precioTotal = String.valueOf(total);

                                    resultado.setText(nomPiz + ", con " + ing.getNombre()[1] + ", tiene un costo de: " + precioTotal);
                                    break;
                                }

                                else if (nomIng.equals(ing.getNombre()[2])){
                                    int precioPizza = Integer.parseInt(pizzasPrecio.get(i));
                                    int precioIngrediente = ing.getPrecio()[2];

                                    int total = precioPizza+precioIngrediente;

                                    String precioTotal = String.valueOf(total);

                                    resultado.setText(nomPiz + ", con " + ing.getNombre()[2] + ", tiene un costo de: " + precioTotal);
                                    break;
                                }

                                else if (nomIng.equals(ing.getNombre()[3])){
                                    int precioPizza = Integer.parseInt(pizzasPrecio.get(i));
                                    int precioIngrediente = ing.getPrecio()[3];

                                    int total = precioPizza+precioIngrediente;

                                    String precioTotal = String.valueOf(total);

                                    resultado.setText(nomPiz + ", con " + ing.getNombre()[3] + ", tiene un costo de: " + precioTotal);
                                    break;
                                }

                                else if (nomIng.equals(ing.getNombre()[4])){
                                    int precioPizza = Integer.parseInt(pizzasPrecio.get(i));
                                    int precioIngrediente = ing.getPrecio()[4];

                                    int total = precioPizza+precioIngrediente;

                                    String precioTotal = String.valueOf(total);

                                    resultado.setText(nomPiz + ", con " + ing.getNombre()[4] + ", tiene un costo de: " + precioTotal);
                                    break;
                                }

                            }catch (Exception e){
                                System.out.println(e);
                            }

                        }
                        //seteo de objeto textview en caso de qe no haya pizza
                        else {
                            resultado.setText("la pizza no esta disponible");
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}