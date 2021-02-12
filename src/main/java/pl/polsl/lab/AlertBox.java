package pl.polsl.lab;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Sara Witek
 * @version  1.0
 *
 * The type Alert box.
 */
public class AlertBox {

    /**
     * Display new window, which a alert depending from issue
     *
     * @param title the title of window
     * @param message the message to show
     */
    public static void display(String title,String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);
        window.setMinHeight(150);
        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e-> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene (layout);
        window.setScene(scene);
        window.showAndWait();
    }

    /**
     * Create button button.
     *
     * @param text         the text to show
     * @param typeOfButton the type of button to set style
     * @param width        the width for setup
     * @param height       the height for setup
     * @return the button
     */

    public static Button createButton(String text, int typeOfButton, int width, int height){
        Button button = new Button(text);
        button.setPrefWidth(width);
        button.setPrefHeight(height);
        if (typeOfButton == 0) {
            button.setStyle("-fx-background-color: #aacc9f");
        }
        else if (typeOfButton == 1) {
            button.setStyle("-fx-background-color: #e4e4e4");
        }
        else {
            button.setStyle("-fx-background-color: #ff9e81");
        }
        return button;
    }
}
