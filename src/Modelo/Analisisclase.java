package modelo;

public class AnalizadorCatalogo {

    private Producto[] productos;

    public AnalizadorCatalogo(Producto[] productos) {
        this.productos = productos;
    }

    public String listarProductos() {
        String resultado = "";

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                resultado += productos[i].mostrarInformacion() + "\n";
            }
        }

        return resultado;
    }

    public int contarDisponibles() {
        int contador = 0;

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null &&
                    productos[i].isDisponible()) {
                contador++;
            }
        }

        return contador;
    }

    public double calcularPrecioPromedio() {
        double suma = 0;
        int contador = 0;

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                suma += productos[i].getPrecio();
                contador++;
            }
        }

        if (contador == 0) {
            return 0;
        }

        return suma / contador;
    }

    public Producto buscarPorCodigo(String codigo) {

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null &&
                    productos[i].getCodigo().equals(codigo)) {
                return productos[i];
            }
        }

        return null;
    }

    // Desafio adicional
    public Producto obtenerProductoMasCaro() {
        Producto mayor = null;

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                if (mayor == null ||
                        productos[i].getPrecio() > mayor.getPrecio()) {
                    mayor = productos[i];
                }
            }
        }

        return mayor;
    }
}