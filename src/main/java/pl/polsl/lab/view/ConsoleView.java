package pl.polsl.lab.view;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.polsl.lab.AlertBox;
import pl.polsl.lab.model.ConsoleModel;

import java.util.InputMismatchException;
import java.util.stream.Stream;

/**
 * @author Sara Witek
 * @version  1.0
 *
 * The type Console view.
 */
public class ConsoleView {

    private ConsoleModel model;
    private Integer index;
    /**
     * Instantiates a new Console view.
     *
     */
    public ConsoleView() { this.index = 0; };

    /**
     * Instantiates a new Console view and initialize the model
     *
     * @param model the model
     */
    public ConsoleView(ConsoleModel model) {
        this.model = model;
        this.index = 0;
    }

    /**
     * Generate new window to show a prime number array as a chart of buttons
     */
    public void showArray() {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Generation");
        window.setWidth(1000);
        window.setHeight(840);
        window.setResizable(false);
        TilePane tilePane = new TilePane();
        tilePane.setPadding(new Insets (20));

        Stream <Integer> streamPrimeNumbers =  model.getArrayOfPrimeNumbers().stream();
        streamPrimeNumbers.forEach((p)-> {

            Button primeButton = AlertBox.createButton(Integer.toString(p),0,45,15);

            Button spacingButton;
            if( index < model.getQuantity()-1) { // There is no spacing value after the last prime number

                int valueOfSpacing = model.getSpacingValue(index);
                if (valueOfSpacing == model.getTheHighestSpacingValue()) { // Generate different style of button if is the highest spacing
                    spacingButton = AlertBox.createButton(Integer.toString(valueOfSpacing), 2, 45, 15);
                }
                else { // Generate buttons with spacing value
                    spacingButton = AlertBox.createButton(Integer.toString(valueOfSpacing),1, 45, 15);
                }
                tilePane.getChildren().addAll(primeButton,spacingButton);
                index++;
            }
            else {
                tilePane.getChildren().add(primeButton);
            }

        });

        // Show alert box about sum and mean average before showing the prime number generation
        AlertBox.display("Generation information",
                "  Sum:  " +  Integer.toString(model.getNumberSum()) +
                        "\n  Mean average:  " + Integer.toString(model.getNumberSum()/model.getQuantity()) +
                        "\n  Median:  " + Double.toString(model.getMedian()));
        Scene scene = new Scene(tilePane);
        window.setScene(scene);
        window.showAndWait();
    }



    /**
     * Gets parameters from user, passed them to model to check if there are correct
     *
     * @param inputPrimeNumber the input prime number
     * @param inputRange       the input range
     * @return if the initialization was successful
     */
    public boolean getParametersFromUser(String inputPrimeNumber, String inputRange) throws NumberFormatException, InputMismatchException {

            // Checking if the inputs are in correct range and if there are characters
            model.setInputNumber(Integer.parseInt(inputPrimeNumber));
            model.setQuantity(Integer.parseInt(inputRange));;
            return true;
    }
}
