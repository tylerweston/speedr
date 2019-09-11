package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;

/*

speedr
speed reader

TODO:
    - fix up timer! how to go about this?
    - add options window?
    - changing value in textfields should change value of sliders
    - add textfield for font size?
    - add a way to color FG and BG to help the text stand out more
    - parse input text better?
 */


public class Main extends Application {

    private Controller controller;

    public static void main(String[] args) {
        // This is for non-javafx aware environments, this launches the javafx toolkit
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {

        controller = new Controller();
        GUI gui = new GUI(mainStage, controller);
        controller.setGUI(gui);

        document doc = new document();
        controller.setDoc(doc);

    }

    @Override
    public void stop() {
        controller.doExit();
    }
}
