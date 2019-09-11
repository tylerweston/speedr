package sample;

import javafx.scene.control.Alert;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    // TODO:
    // - controller will hold timer that keep everything humming along
    // - how to implement a timer properly? will handle keypresses here?


    GUI gui;
    document doc;

    // TODO: default chunk size
    int chunkSize = 4;
    int wordSpeed = 200;

    Timer timer;
    TimerTask task;

    boolean playing = false;
    boolean hasTask = false;

    public Controller() {
        // create new Controller, do any init. here

        timer = new Timer();
//        final long start = System.currentTimeMillis();
        task = new TimerTask() {
            @Override
            public void run() {
                if (playing && doc.isDocLoaded()) {
                    doNextChunk();
                }
            }
        };
        // TODO: this only works first time
        changeSpeed(200);

    }

    public void doExit() {
        // handle closing duties here
        System.exit(0);
    }

    public void setGUI(GUI setGui) {
        // link our GUI to controller, if we need to make any change to GUI from controller
        this.gui = setGui;
    }

    public void changeSpeed(int speed) {
        // TODO:
        //  - This doesn't work, we can't change the speed of timers like this
        //  figure out a better way to do it!
        //  - Maybe count every msec and once a goal is hit, switch to the next chunk?
        //  maybe inefficient?
        wordSpeed = speed;
        int msWordSpeed = bpmToMsec(wordSpeed);
        timer.scheduleAtFixedRate(task, 0, msWordSpeed);
//        timer.schedule(task, msWordSpeed);
        hasTask = true;
    }

    public void changeChunk(int chunk) {
        chunkSize = chunk;
    }

    public void openFile() {
        // open a new file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.pdf", "*.txt", "*.doc"));

        File selectedFile = fileChooser.showOpenDialog(this.gui.getStage());
        if (selectedFile != null) {
            doc.loadDocument(selectedFile);
        } else {
            // TODO: make an error logging / display class maybe?
            Alert fAlert = new Alert(Alert.AlertType.INFORMATION);
            fAlert.setTitle("File format not supported");
            fAlert.setHeaderText("Try a different file.");
            fAlert.showAndWait();
        }
        // clear main text area
        gui.setText("");

    }

    public void showAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(gui.getStage());

        alert.setTitle("About");
        alert.setHeaderText("speedr");
        alert.setContentText("By: Tyler Weston ");
        // TODO: ADD ICON and EASTER EGG HERE??
//        Image image = new Image("/resources/bagIcon.png");
//        ImageView logo = new ImageView(image);
//        logo.setOnMouseClicked((ae) -> {
//            Random rnd = new Random();
//            BlendMode[] blends = {
//                    BlendMode.COLOR_BURN,
//                    BlendMode.EXCLUSION,
//                    BlendMode.DIFFERENCE,
//                    BlendMode.GREEN,
//                    BlendMode.RED,
//                    BlendMode.HARD_LIGHT
//            };
//            logo.setBlendMode(blends[rnd.nextInt(blends.length)]);
//        });
//        alert.setGraphic(logo);
        alert.showAndWait();
    }

    public void showPreferences () {
        // show preference window
    }

    public void doNextChunk() {
        String s = doc.getChunk(chunkSize);
        if (!s.isEmpty()) {
            gui.setText(s);
        }
    }

    public void doPlay() {
        // Begin playing the words
        if (doc.isDocLoaded()) {
            playing = true;
            gui.setToPause();
        }
    }

    public void doPause() {
        playing = false;
        gui.setToPlay();
    }

    public void setDoc(document doc) {
        // Set a new document
        this.doc = doc;
    }

    public void doRewind() {
        // Reset everything
        if (doc.isDocLoaded()) {
            playing = false;
            gui.setText("");
            gui.setToPlay();
            doc.resetIndex();
        }
    }

    private int bpmToMsec(int bpm) {
        // translates from BPM that the sliders use to MSEC
        return (int) (60000 / bpm);
    }

}
