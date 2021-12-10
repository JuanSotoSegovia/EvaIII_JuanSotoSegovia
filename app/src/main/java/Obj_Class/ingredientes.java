package Obj_Class;

//clases ingredientes
public class ingredientes {

    private int[] id = {1,2,3,4,5};
    private String[] nombre = {"Albahaca","Champiñon","Extra Queso","Salame","Tocino"};
    private int[] precio = {450, 250, 500, 300, 350};

    public ingredientes() {

    }

    public ingredientes(String[] nombre) {
        this.nombre = nombre;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }

    public String[] getNombre() {
        return nombre;
    }

    public void setNombre(String[] nombre) {
        this.nombre = nombre;
    }

    public int[] getPrecio() {
        return precio;
    }

    public void setPrecio(int[] precio) {
        this.precio = precio;
    }
}
