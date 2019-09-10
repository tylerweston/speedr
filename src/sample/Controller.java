package sample;

public class Controller {

    // TODO:
    // - controller will hold timer that keep everything humming along
    // - how to implement a timer properly? will handle keypresses here?

    Model model;
    GUI gui;

    public Controller(Model setModel) {
        // create new Controller, do any init. here
        this.model = setModel;
    }

    public void doExit() {
        // handle closing duties here
        System.exit(0);
    }

    public void setGUI(GUI setGui) {
        // link our GUI to controller, if we need to make any change to GUI from controller
        this.gui = setGui;
    }

}
