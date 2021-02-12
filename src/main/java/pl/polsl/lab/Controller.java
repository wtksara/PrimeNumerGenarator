package pl.polsl.lab;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Cell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.VirtualFlow;
import javafx.scene.text.Font;
import pl.polsl.lab.controller.ConsoleController;
import pl.polsl.lab.model.ConsoleModel;
import pl.polsl.lab.view.ConsoleView;
import java.net.URL;
import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

/**
 * The type Controller.
 *
 * @author Sara Witek
 * @version 1.0  The type Controller.
 */
public class Controller implements Initializable {
    /**
     * The Text from number.
     */
    @FXML
    private TextField textFromNumber;
    /**
     * The Text from quantity.
     */
    @FXML
    private TextField textFromQuantity;
    /**
     * The List view.
     */
    @FXML
    private ListView<String> listView;

    /**
     * The list of the input numbers saved in string
     */
    private ObservableList<String> list = FXCollections.observableArrayList();

    /**
     * Initialization of listener for list to update the listView
     */
    @Override
    public void initialize (URL url, ResourceBundle rb){
        list.addListener((javafx.beans.Observable observable)->
        { });
        listView.setItems(list);
    }

    /**
     * Show button clicked.
     */
    public void showButtonClicked() {

        ConsoleModel model = new ConsoleModel();
        ConsoleView view = new ConsoleView(model);
        ConsoleController controller = new ConsoleController(view,model);

        String textNumber = textFromNumber.getText();
        String textQuantity = textFromQuantity.getText();
        boolean state;
        try {
            state = view.getParametersFromUser(textNumber, textQuantity) ; // Check params
        }
        catch(NumberFormatException exception){
            AlertBox.display("Incorrect format", "Entered values have to be a number and has to be higher than 0 !");
            state=false;
        }
        catch(InputMismatchException exception){
            AlertBox.display("Incorrect range", "Quantity has to be in range [0-300]");
            state=false;
        }

        if (state){
            String s = MessageFormat.format("{0} , {1} ", textFromNumber.getText(),textFromQuantity.getText());
            list.add(s);
            // Generation of whole model
            controller.generatePrimeNumbers();
            controller.generateSpacingValues();
            controller.calculateMedianValue();
            view.showArray();
            model.setTheHighestSpacingValue(0); // Set both for 0 to let user repeat generation
            model.setNumberSum(0);
        }
    }
}
