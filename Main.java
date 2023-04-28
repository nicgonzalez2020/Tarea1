import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Primero se crea una lista con todas las bebidas disponibles y sus respectivos precios.
    public static void main(String[] args) {
        ArrayList<Bebida> bebidas = new ArrayList<>();
        bebidas.add(new Bebida("Coca-Cola", 1.5));
        bebidas.add(new Bebida("Sprite", 1.5));
        bebidas.add(new Bebida("Agua", 1.0));
        bebidas.add(new Bebida("Jugo", 2.0));
        Maquina maquina = new Maquina(bebidas);
        // Muestra el menú de bebidas y permite comprarlas
        maquina.mostrarMenu();
        maquina.comprar();
    }
}
// Aquí, se crean las distintas clases; una para las características de las bebidas y otra para el funcionamiento de
// la máquina expendedora.
class Bebida {
    // Cada bebida tendrá un nombre y un precio.
    private String nombre;
    private double precio;
    public Bebida(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

class Maquina {
    // Se añade la lista de las bebidas.
    private ArrayList<Bebida> bebidas;

    public Maquina(ArrayList<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public void mostrarMenu() {
        System.out.println("Este es el menú de bebidas:");

        for (int i = 0; i < bebidas.size(); i++) {
            Bebida bebida = bebidas.get(i);
            System.out.println((i + 1) + ". " + bebida.getNombre() + " - $" + bebida.getPrecio());
        }
    }

    public void comprar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor seleccione una bebida (ingrese el número):");
        int seleccion = scanner.nextInt();

        if (seleccion < 1 || seleccion > bebidas.size()) {
            System.out.println("Selección inválida. Por favor seleccione un número entre 1 y " + bebidas.size() + ".");
            comprar();
            return;
        }

        Bebida bebidaSeleccionada = bebidas.get(seleccion - 1);

        System.out.println("Ha seleccionado la bebida: " + bebidaSeleccionada.getNombre() + " - $" + bebidaSeleccionada.getPrecio());
        System.out.println("Por favor ingrese el monto:");

        double monto = scanner.nextDouble();

        if (monto < bebidaSeleccionada.getPrecio()) {
            System.out.println("Monto insuficiente. Por favor ingrese un monto igual o mayor a $" + bebidaSeleccionada.getPrecio() + ".");
            comprar();
            return;
        }

        double cambio = monto - bebidaSeleccionada.getPrecio();

        System.out.println("Compra realizada con éxito. Disfrute su bebida!");
        System.out.println("Cambio: $" + cambio);
    }
}