package pl.polsl.lab;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;

/**
 * @author Sara Witek
 * @version  1.0
 *
 * The type Main.
 */
public class Main extends Application {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Main method responsible for start of the GUI. Generate the main window for interaction with the user
     *
     * @param primaryStage set window
     * @throws Exception in case of incorrect way of using GUI
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(new File("C:/Users/Sara/IdeaProjects/exercise1/src/main/java/pl/polsl/lab/sample.fxml").toURI().toURL());
        Parent root = loader.load();
        primaryStage.setTitle("Generate prime numbers");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}

