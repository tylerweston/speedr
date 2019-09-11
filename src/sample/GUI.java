package sample;

//import controller.Controller;
//import controller.IController;
//import tags.Tag;
//import photo.Photo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.collections.FXCollections.*;

public class GUI {

    private final Controller controller;
    private final Stage stage;

    private final MainMenu controllerMenu;
    private Text mainText;

    Button playPauseButton;
    TextField wordSpeedText;
    TextField chunkSizeText;
//        root.getChildren().add(t);
//        t.setTextAlignment(TextAlignment.CENTER);
//        t.setFont(Font.font("Verdana", 20));


    /**
     * Creates a graphical user interface (GUI) for the program.
     *
     * @param mainStage    main stage to host the program
     * @param setController    a controller object to manage
     *                         executive functions
     */
    public GUI(Stage mainStage, Controller setController) {

        mainStage.setTitle("speedr");
//        mainStage.getIcons().add(new Image("/resources/bagIcon.png"));
        stage = mainStage;
        controller = setController;

        BorderPane root = new BorderPane();
        root.setPrefSize(600, 300);
        Scene theScene = new Scene(root);

        mainStage.setScene(theScene);

        // left side image box

        mainText = new Text();
        mainText.setTextAlignment(TextAlignment.CENTER);
        mainText.setFont(Font.font("Verdana", 20));

        VBox centerBox = new VBox();

//        // build main menu
        controllerMenu = new MainMenu(controller);
        controllerMenu.prefWidthProperty().bind(theScene.widthProperty());
        root.setTop(controllerMenu);

        HBox bottomDisplay = new HBox();

        Button rewindWords = new Button("<<");
        rewindWords.setTextOverrun(OverrunStyle.CLIP);
        rewindWords.setPrefWidth(40);
        rewindWords.setOnMouseClicked((ae) -> controller.doRewind());
        rewindWords.setTooltip(new Tooltip("Rewind"));

        playPauseButton = new Button(">");
        playPauseButton.setTextOverrun(OverrunStyle.CLIP);
        playPauseButton.setPrefWidth(40);
        playPauseButton.setOnMouseClicked((ae) -> controller.doPlay());
        // TODO: This changes when play is clicked
        playPauseButton.setTooltip(new Tooltip("Play"));

        Slider wordSpeedSlide = new Slider(10, 1000, 200);
        wordSpeedSlide.setPrefWidth(180);
        wordSpeedSlide.setOnMouseClicked((ae) ->
            {
                controller.changeSpeed((int) wordSpeedSlide.getValue());
                Integer newVal = (int) wordSpeedSlide.getValue();
                wordSpeedText.setText(newVal.toString());
            }
            );
        wordSpeedSlide.setTooltip(new Tooltip("Word Speed"));

        wordSpeedText = new TextField();
        wordSpeedText.setPrefWidth(60);
        wordSpeedText.setText("200");

        Slider chunkSizeSlide = new Slider(1, 10, 4);
        chunkSizeSlide.setPrefWidth(120);
        chunkSizeSlide.setOnMouseClicked((ae) ->
            {
                controller.changeChunk((int) chunkSizeSlide.getValue());
                Integer newVal = (int) chunkSizeSlide.getValue();
                chunkSizeText.setText(newVal.toString());
            }
            );
        chunkSizeSlide.setTooltip(new Tooltip("Chunk Size"));

        chunkSizeText = new TextField();
        chunkSizeText.setPrefWidth(40);
        chunkSizeText.setText("4");

        Slider textSizeSlide = new Slider(8, 90, 20);
        textSizeSlide.setPrefWidth(120);
        textSizeSlide.setOnMouseClicked((ae) -> setFontSize((int) textSizeSlide.getValue()));
        textSizeSlide.setTooltip(new Tooltip("Font Size"));

        bottomDisplay.getChildren().add(rewindWords);
        bottomDisplay.getChildren().add(playPauseButton);
        bottomDisplay.getChildren().add(wordSpeedSlide);
        bottomDisplay.getChildren().add(wordSpeedText);
        bottomDisplay.getChildren().add(chunkSizeSlide);
        bottomDisplay.getChildren().add(chunkSizeText);
        bottomDisplay.getChildren().add(textSizeSlide);

        bottomDisplay.setAlignment(Pos.CENTER);

        root.setCenter(mainText);

        root.setBottom(bottomDisplay);

        mainStage.show();

    }


    /**
     * Returns the main stage that hosts the program.
     */
    public Stage getStage() {
        return stage;
    }

    public void setToPause() {
        // set pause/play to be the pause button
        playPauseButton.setText("||");
        playPauseButton.setOnMouseClicked((ae) -> controller.doPause());
        playPauseButton.setTooltip(new Tooltip("Pause"));
    }

    public void setToPlay() {
        // set pause/play to be the play button
        playPauseButton.setText(">");
        playPauseButton.setOnMouseClicked((ae) -> controller.doPlay());
        playPauseButton.setTooltip(new Tooltip("Play"));
    }

    public void setText(String s) {
        // display the main text
        mainText.setText(s);
    }

    public void setFontSize(int size) {
        mainText.setFont(Font.font("Verdana", size));
    }

    public void doNothing() {}


}
