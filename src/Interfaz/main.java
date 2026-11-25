package interfaz;

import modelo.Producto;
import modelo.AnalizadorCatalogo;

public class Main {

    public static void main(String[] args) {

        Producto[] productos = new Producto[5];

        productos[0] = new Producto("P01", "Mouse", 25.50, true);
        productos[1] = new Producto("P02", "Teclado", 45, true);
        productos[2] = new Producto("P03", "Monitor", 150, false);
        productos[3] = new Producto("P04", "Audifonos", 35, true);
        productos[4] = new Producto("P05", "Camara", 60, false);

        AnalizadorCatalogo analizador =
                new AnalizadorCatalogo(productos);

        System.out.println("=== CATALOGO DIGITAL ===");

        System.out.println(analizador.listarProductos());

        System.out.println("Productos disponibles: "
                + analizador.contarDisponibles());

        System.out.println("Precio promedio: $"
                + analizador.calcularPrecioPromedio());

        Producto encontrado = analizador.buscarPorCodigo("P02");

        if (encontrado != null) {
            System.out.println("Producto encontrado: "
                    + encontrado.mostrarInformacion());
        } else {
            System.out.println("Producto no encontrado");
        }

        Producto inexistente = analizador.buscarPorCodigo("P10");

        if (inexistente == null) {
            System.out.println("El producto P10 no existe");
        }

        Producto mayor = analizador.obtenerProductoMasCaro();

        if (mayor != null) {
            System.out.println("Producto mas caro: "
                    + mayor.mostrarInformacion());
        }
    }
}