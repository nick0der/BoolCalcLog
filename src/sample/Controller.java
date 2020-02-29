package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.animation.FadeTransition;
import javafx.animation.Animation;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Controller {

    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("./src/log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Controller.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    //Interface elements:
    @FXML
    private Pane mainPane;
    @FXML
    private ChoiceBox xChoice;
    @FXML
    private ChoiceBox yChoice;
    @FXML
    private ChoiceBox functionChoice;
    @FXML
    private Button calculateButton;
    @FXML
    private Label resultLabel;

    @FXML
    public void initialize() {
        LOGGER.log(Level.INFO,"Controller class starts to work"); /* 7 */
        //Background
        mainPane.setStyle("-fx-background-color: rgb(235,245,255);");
        LOGGER.log(Level.INFO,"Background color is initialized");  /* 8 */

        LOGGER.log(Level.INFO,"First value option list is initialized");  /* 9 */
        //Set choices for x
       xChoice.setItems(FXCollections.observableArrayList(
                "NULL", "TRUE", "FALSE")
        );
        LOGGER.log(Level.INFO,"NULL is selected for first value ");  /* 10 */
        xChoice.getSelectionModel().selectFirst();

        LOGGER.log(Level.INFO,"Second value option list is initialized");  /* 11 */
        //Set choices for y
        yChoice.setItems(FXCollections.observableArrayList(
                "NULL", "TRUE", "FALSE")
        );
        LOGGER.log(Level.INFO,"NULL is selected for second value ");  /* 12 */
        yChoice.getSelectionModel().selectFirst();


        LOGGER.log(Level.INFO,"Function option list initialized");  /* 13 */
        //Set choices for functions
        functionChoice.setItems(FXCollections.observableArrayList(
                "\u22a5 (contradiction)", "\u2227 (conjunction)", "\u2285 (nonimplication)",
                "\u004c (left projection)", "\u2284 (converse nonimplication)", "\u0052 (right projection)",
                "\u2295 (exclusive conjunction)", "\u2228 (disjunction)", "\u22bd(nondisjunction)",
                "\u007e (equivalence)", "\uff32" + "\u0305" + " (right complenemtation)", "\u2282 (converse implication)",
                "\u004c" + "\u0305" + "(left complenemtation)", "\u2283 (implication)", "\u22bc (nonconjunction)",
                "\u22a4 (affirmation)"
                )
        );
        LOGGER.log(Level.INFO,"Contradiction is selected as a function");  /* 14 */
        functionChoice.getSelectionModel().selectFirst();



        //Set button action
        calculateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                LOGGER.log(Level.INFO,"Setting action for button starts to work");  /* 15 */

                LOGGER.log(Level.INFO,"Animation is set"); /* 16 */
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), resultLabel);
                fadeTransition.setFromValue(0.0);
                fadeTransition.setToValue(1.0);
                //fadeTransition.setCycleCount(1);
                fadeTransition.play();
                LOGGER.log(Level.INFO,"Animation played");  /* 17 */

                //Two variables - x and y
                AdvancedBoolean boolX;
                LOGGER.log(Level.INFO,"First boolean value is created"); /* 18 */
                boolX = AdvancedBoolean.NULL;
                LOGGER.log(Level.INFO,"First boolean value equals NULL"); /* 19 */
                AdvancedBoolean boolY;
                LOGGER.log(Level.INFO,"Second boolean value is created"); /* 20 */
                boolY = AdvancedBoolean.NULL;
                LOGGER.log(Level.INFO,"Second boolean value equals NULL"); /* 21 */

                //Set x value
                LOGGER.log(Level.INFO,"Setting first boolean value"); /* 22 */
                switch (xChoice.getSelectionModel().getSelectedIndex())
                {
                    case 0:
                        boolX = AdvancedBoolean.NULL;
                        LOGGER.log(Level.INFO,"First boolean value changed to NULL"); /* 23 */
                    break;

                    case 1:
                        boolX = AdvancedBoolean.TRUE;
                        LOGGER.log(Level.INFO,"First boolean value changed to TRUE"); /* 24 */
                        break;
                    case 2:
                        boolX = AdvancedBoolean.FALSE;
                        LOGGER.log(Level.INFO,"First boolean value changed to FALSE"); /* 25 */
                        break;
                }

                //Set y value
                LOGGER.log(Level.INFO,"Setting second boolean value"); /* 26 */
                switch (yChoice.getSelectionModel().getSelectedIndex())
                {
                    case 0:
                        boolY = AdvancedBoolean.NULL;
                        LOGGER.log(Level.INFO,"Second boolean value changed to NULL"); /* 27 */
                        break;

                    case 1:
                        boolY = AdvancedBoolean.TRUE;
                        LOGGER.log(Level.INFO,"Second boolean value changed to TRUE"); /* 28 */
                        break;
                    case 2:
                        boolY = AdvancedBoolean.FALSE;
                        LOGGER.log(Level.INFO,"Second boolean value changed to FALSE"); /* 29 */
                        break;
                }

                //Creating calculating class
                LOGGER.log(Level.INFO,"Calculation class is created"); /* 30 */
                BooleanCalculation calculation = new BooleanCalculation(boolX, boolY);


                //Show result of calculation
                LOGGER.log(Level.INFO,"Displaying result"); /* 31 */
                switch (functionChoice.getSelectionModel().getSelectedIndex())
                {
                    case 0:
                        LOGGER.log(Level.INFO,"Contradiction is calculated, result is displayed"); /* 32 */
                        resultLabel.setText(calculation.contradiction().toString());
                        LOGGER.log(Level.INFO,"Calculation result (contradiction) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.contradiction().toString()); /* 33 */
                        break;
                    case 1:
                        LOGGER.log(Level.INFO,"Conjunction is calculated, result is displayed"); /* 34 */
                        resultLabel.setText(calculation.conjunction().toString());
                        LOGGER.log(Level.INFO,"Calculation result (conjunction) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.conjunction().toString()); /* 35 */
                        break;
                    case 2:
                        LOGGER.log(Level.INFO,"NonImplication is calculated, result is displayed"); /* 36 */
                        resultLabel.setText(calculation.nonImplication().toString());
                        LOGGER.log(Level.INFO,"Calculation result (nonImplication) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.nonImplication().toString()); /* 37 */
                        break;
                    case 3:
                        LOGGER.log(Level.INFO,"LeftProjection is calculated, result is displayed"); /* 38 */
                        resultLabel.setText(calculation.leftProjection().toString());
                        LOGGER.log(Level.INFO,"Calculation result (leftProjection) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.leftProjection().toString()); /* 39 */

                        break;
                    case 4:
                        LOGGER.log(Level.INFO,"ConverseNonimplication is calculated, result is displayed"); /* 40 */
                        resultLabel.setText(calculation.converseNonimplication().toString());
                        LOGGER.log(Level.INFO,"Calculation result (converseNonimplication) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.converseNonimplication().toString()); /* 41 */
                        break;
                    case 5:
                        LOGGER.log(Level.INFO,"RightProjection is calculated, result is displayed"); /* 42 */
                        resultLabel.setText(calculation.rightProjection().toString());
                        LOGGER.log(Level.INFO,"Calculation result (rightProjection) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.rightProjection().toString()); /* 43 */
                        break;
                    case 6:
                        LOGGER.log(Level.INFO,"ExclusiveDisjunction is calculated, result is displayed"); /* 44 */
                        resultLabel.setText(calculation.exclusiveDisjunction().toString());
                        LOGGER.log(Level.INFO,"Calculation result (exclusiveDisjunction) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.exclusiveDisjunction().toString()); /* 45 */
                        break;
                    case 7:
                        LOGGER.log(Level.INFO,"Disjunction is calculated, result is displayed"); /* 46 */
                        resultLabel.setText(calculation.disjunction().toString());
                        LOGGER.log(Level.INFO,"Calculation result (disjunction) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.disjunction().toString()); /* 47 */
                        break;
                    case 8:
                        LOGGER.log(Level.INFO,"NonDisjunction is calculated, result is displayed"); /* 48 */
                        resultLabel.setText(calculation.nonDisjunction().toString());
                        LOGGER.log(Level.INFO,"Calculation result (nonDisjunction) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.nonDisjunction().toString()); /* 49 */
                        break;
                    case 9:
                        LOGGER.log(Level.INFO,"Equivalence is calculated, result is displayed"); /* 50 */
                        resultLabel.setText(calculation.equivalence().toString());
                        LOGGER.log(Level.INFO,"Calculation result (equivalence) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.equivalence().toString()); /* 51 */
                        break;
                    case 10:
                        LOGGER.log(Level.INFO,"RightComplementation is calculated, result is displayed"); /* 52 */
                        resultLabel.setText(calculation.rightComplementation().toString());
                        LOGGER.log(Level.INFO,"Calculation result (rightComplementation) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.rightComplementation().toString()); /* 53 */
                        break;
                    case 11:
                        LOGGER.log(Level.INFO,"ConverseImplication is calculated, result is displayed"); /* 54 */
                        resultLabel.setText(calculation.converseImplication().toString());
                        LOGGER.log(Level.INFO,"Calculation result (converseImplication) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.converseImplication().toString()); /* 55 */
                        break;
                    case 12:
                        LOGGER.log(Level.INFO,"LeftComplementation is calculated, result is displayed"); /* 56 */
                        resultLabel.setText(calculation.leftComplementation().toString());
                        LOGGER.log(Level.INFO,"Calculation result (leftComplementation) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.leftComplementation().toString()); /* 57 */
                        break;
                    case 13:
                        LOGGER.log(Level.INFO,"Implication is calculated, result is displayed"); /* 58 */
                        resultLabel.setText(calculation.implication().toString());
                        LOGGER.log(Level.INFO,"Calculation result (implication) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.implication().toString()); /* 59 */
                        break;
                    case 14:
                        LOGGER.log(Level.INFO,"NonConjunction is calculated, result is displayed"); /* 60 */
                        resultLabel.setText(calculation.nonConjunction().toString());
                        LOGGER.log(Level.INFO,"Calculation result (nonConjunction) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.nonConjunction().toString()); /* 61 */
                        break;
                    case 15:
                        LOGGER.log(Level.INFO,"Affirmation is calculated, result is displayed"); /* 62 */
                        resultLabel.setText(calculation.affirmation().toString());
                        LOGGER.log(Level.INFO,"Calculation result (affirmation) : First is " + calculation.getBool1().toString() + ", Second is " +
                                calculation.getBool2().toString() + ", Result is " +
                                calculation.affirmation().toString()); /* 63 */
                        break;

                    default:
                      break;
                }
                LOGGER.log(Level.INFO,"Action event is over");  /* 64 */
            }
        });
        LOGGER.log(Level.INFO,"Action for button is set");  /* 65 */

        xChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                LOGGER.log(Level.INFO,"First value changed from " + xChoice.getItems().get(number.intValue()) +
                        " to " + xChoice.getItems().get(t1.intValue()) );  /* 66 */
            }
        });

        yChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                LOGGER.log(Level.INFO,"Second value changed from " + yChoice.getItems().get(number.intValue()) +
                        " to " + yChoice.getItems().get(t1.intValue()) );  /* 67 */
            }
        });

        functionChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                LOGGER.log(Level.INFO,"Function value changed from " + functionChoice.getItems().get(number.intValue()) +
                        " to " + functionChoice.getItems().get(t1.intValue()) );  /* 68 */
            }
        });

        LOGGER.log(Level.INFO,"Controller class initialization finished");  /* 69 */

    }
}
