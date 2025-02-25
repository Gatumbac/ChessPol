package main.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author gatumbac
 */
public class ChessView extends Application {
    private final ChessBoardView tableroView = new ChessBoardView();
    private static final int TAMANO_CELDA = 80; // Tamaño de cada celda del tablero
    private static final int NUMERO_CELDAS = 8; // Tamaño del tablero (8x8)

    @Override
    public void start(Stage primaryStage) {
        GridPane tablero = tableroView.getTablero();
       
        // Crear la escena y mostrarla en la ventana
        Scene scene = new Scene(tablero, TAMANO_CELDA * NUMERO_CELDAS, TAMANO_CELDA * NUMERO_CELDAS);
        primaryStage.setTitle("ChessPol");
        
        // Deshabilitar la redimensión de la ventana
        primaryStage.setResizable(false);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args); // Iniciar la aplicación JavaFX
    }
}
