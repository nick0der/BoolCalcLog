package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
//hello


public class Main extends Application {

    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("./src/log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Main.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        LOGGER.log(Level.INFO,"Main class starts to work"); /* 1 */
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        LOGGER.log(Level.INFO,"Resources have been loaded"); /* 2 */
        primaryStage.setTitle("Hello World");
        LOGGER.log(Level.INFO,"Title is set"); /* 3 */
        primaryStage.setScene(new Scene(root, 600, 400));
        LOGGER.log(Level.INFO,"Scene is set"); /* 4 */
        primaryStage.show();
        LOGGER.log(Level.INFO,"Window appears"); /* 5 */
    }


    public static void main(String[] args) {
        launch(args);
        LOGGER.log(Level.INFO,"Program ended successfully"); /* 6 */
    }


}
