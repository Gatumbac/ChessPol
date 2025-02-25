package main.java;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author gatumbac
 */
public class ChessBoardView {
    
    private static final int TAMANO_CELDA = 80; // Tamaño de cada celda del tablero
    private static final int NUMERO_CELDAS = 8; // Tamaño del tablero (8x8)
    
    // Colores del tablero
    private static final Color COLOR_CLARO = Color.valueOf("#F0D9B5"); // Beige
    private static final Color COLOR_OSCURO = Color.valueOf("#B58863");  // Verde oscuro
    
    public GridPane tablero;

    public ChessBoardView() {
        tablero = new GridPane();
        inicializarTablero(tablero);
    }
    
    public GridPane getTablero() {
        return tablero;
    }
    
    private void inicializarTablero(GridPane tablero) {
        // Llenar el tablero con celdas (Rectangles)
        for (int row = 0; row < NUMERO_CELDAS; row++) {
            for (int col = 0; col < NUMERO_CELDAS; col++) {
                // Crear un Rectangle para cada celda
                Rectangle tile = new Rectangle(TAMANO_CELDA, TAMANO_CELDA);
                tile.setFill((row + col) % 2 == 0 ? COLOR_CLARO : COLOR_OSCURO);
                tablero.add(tile, col, row); // Agregar al GridPane
            }
        }
        agregarPiezas(tablero);
    }
    
    private void agregarPiezas(GridPane tablero) {
        agregarPeones(tablero);
        agregarTorres(tablero);
        agregarCaballos(tablero);
        agregarAlfiles(tablero);
        agregarReyes(tablero);
        agregarReinas(tablero);
    }
    
    private void agregarPiezaTablero(GridPane tablero, ImageView piezaView, int columna, int fila) {
        tablero.add(piezaView, columna, fila);
    }
    
    private void agregarPeones(GridPane tablero) {
        agregarFilaPeones(tablero, "peon_blanco", 6);
        agregarFilaPeones(tablero, "peon_negro", 1);
    }
    
    private void agregarFilaPeones(GridPane tablero, String peonType, int fila) {
        for (int col = 0; col < NUMERO_CELDAS; col++) {
            ImageView peon = getView(peonType);
            agregarPiezaTablero(tablero, peon, col, fila);
        }
    }
    
    private void agregarTorres(GridPane tablero) {
        agregarParesPiezas(tablero, "torre_negra", 0, 0, 7);
        agregarParesPiezas(tablero, "torre_blanca", 0, 7, 7);
    }
    
    private void agregarCaballos(GridPane tablero) {
        agregarParesPiezas(tablero, "caballo_negro", 1, 0, 5);
        agregarParesPiezas(tablero, "caballo_blanco", 1, 7, 5);
    }
    
    private void agregarAlfiles(GridPane tablero) {
        agregarParesPiezas(tablero, "alfil_negro", 2, 0, 3);
        agregarParesPiezas(tablero, "alfil_blanco", 2, 7, 3);
    }
    
    private void agregarReyes(GridPane tablero) {
        ImageView reyBlanco = getView("rey_blanco");
        ImageView reyNegro = getView("rey_negro");
        agregarPiezaTablero(tablero, reyNegro, 4, 0);
        agregarPiezaTablero(tablero, reyBlanco, 4, 7);
    }
    
    private void agregarReinas(GridPane tablero) {
        ImageView reinaBlanca = getView("reina_blanca");
        ImageView reinaNegra = getView("reina_negra");
        agregarPiezaTablero(tablero, reinaNegra, 3, 0);
        agregarPiezaTablero(tablero, reinaBlanca, 3, 7);
    }
    
    private void agregarParesPiezas(GridPane tablero, String piezaName, int columnaInicial, int fila, int separacion) {
        for(int i = 0; i < 2; i++) {
            ImageView piezaView = getView(piezaName);
            int columna = i == 0 ? columnaInicial : columnaInicial + separacion;
            agregarPiezaTablero(tablero, piezaView, columna, fila);
        }
    }
   
    private ImageView getView(String piezaName) {
        Image pieza = new Image(getClass().getResourceAsStream("../resources/img/" + piezaName + ".png"));
        ImageView piezaView = new ImageView(pieza);
        ajustarImagen(piezaView);
        return piezaView;
    }
    
    private void ajustarImagen(ImageView imagen) {
        imagen.setFitWidth(TAMANO_CELDA);
        imagen.setFitHeight(TAMANO_CELDA);
    }
}
