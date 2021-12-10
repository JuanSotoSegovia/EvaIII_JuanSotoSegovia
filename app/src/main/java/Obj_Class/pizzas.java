package Obj_Class;

//clase pizzas la cual alamcenara a los objetos traidos de firebase
public class pizzas {

    private String nombre;
    private String precio;
    private String id;
    private String locazion;

    public pizzas (){

    }

    public pizzas(String nombre) {
        this.nombre = nombre;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getLocazion() {
        return locazion;
    }

    public void setLocazion(String locazion) {
        this.locazion = locazion;
    }

    //creamos el metodo toString para mostrar en el listView
    @Override
    public String toString() {
        return nombre;
    }
}
