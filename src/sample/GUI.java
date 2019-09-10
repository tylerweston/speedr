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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.collections.FXCollections.*;

public class GUI {

    // ObservableLists are watched by our ListView (below) so whenever
    // these lists are updated, ListView is updated!

    private final Controller controller;
    private final Stage stage;

//    private final ObservableList<Tag> currentTagsList = observableArrayList();
//    private final ListView<Tag> currentTags;
//    private final ObservableList<Tag> allTagsList = observableArrayList();
//    private final ObservableList<ArrayList<Tag>> tagHistoryList = observableArrayList();
//    private final ObservableList<String> renameHistoryList = observableArrayList();
//    private final ComboBox<ArrayList<Tag>> tagHistoryDisplay;
//    private final ComboBox<String> renameHistoryDisplay;
//    private final ListView<Tag> allTags;
//    private final ScrollPane imagePane;
//    private ArrayList<Tag> currentlySelectedTags;
//    private ArrayList<Tag> currentlySelectedGlobalTag;
//    private String currentRenameHistory;
    private final MainMenu controllerMenu;
//    private ImageView loadedPhoto;
//    private final ContextMenu zoomMenu;

//    private final BooleanProperty buttonsDisabled = new SimpleBooleanProperty(true);
//    private final StringProperty fullFileName = new SimpleStringProperty();
//    private final BooleanProperty hasDirectory = new SimpleBooleanProperty(false);

//    private double zoomFactor = 1;
//    private double photoX;
//    private double photoY;
//
//    private boolean photoLoaded;
//
//    private static final DataFormat tagDataFormat = new DataFormat("Tag");

    /**
     * Creates a graphical user interface (GUI) for the program.
     *
     * @param mainStage    main stage to host the program
     * @param setController    a controller object to manage
     *                         executive functions
     */
    public GUI(Stage mainStage, Controller setController) {

        mainStage.setTitle("TagBag");
//        mainStage.getIcons().add(new Image("/resources/bagIcon.png"));
        stage = mainStage;
        controller = setController;

        BorderPane root = new BorderPane();
        root.setPrefSize(600, 500);
        Scene theScene = new Scene(root);

        mainStage.setScene(theScene);

        // left side image box

        VBox centerBox = new VBox();

//        renameHistoryDisplay = new ComboBox<>(renameHistoryList);
//        renameHistoryDisplay.disableProperty().bind(buttonsDisabled);
//        renameHistoryDisplay.getSelectionModel().selectedItemProperty()
//                .addListener((c, oldTag, newTag) ->
//                        currentRenameHistory = renameHistoryDisplay.getSelectionModel().getSelectedItem());

//        centerBox.getChildren().add(renameHistoryDisplay);
//        Button doRename = new Button();
//        doRename.setText("Revert Filename");
//        doRename.disableProperty().bind(buttonsDisabled);
//        centerBox.getChildren().add(doRename);
//
//        doRename.setOnMouseClicked((me) -> controller.renameFromHistory());
//
//        imagePane = new ScrollPane();
//        imagePane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
//        imagePane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
//        imagePane.setPannable(true);
//        imagePane.disableProperty().bind(buttonsDisabled);
//
//        // https://stackoverflow.com/questions/27461643/javafx-disable-scrolling-by-mousewheel-in-scrollpane
//        imagePane.addEventFilter(ScrollEvent.ANY, mh -> {
//            double zoomWay = mh.getDeltaY();
//            if (zoomWay < 0) zoomOut();
//            if (zoomWay > 0) zoomIn();
//            mh.consume();
//        });
//
//        imagePane.setOnScroll((mh) -> {
//            if (photoLoaded) {
//                double zoomWay = mh.getDeltaY();
//                if (zoomWay < 0) zoomOut();
//                if (zoomWay > 0) zoomIn();
//                mh.consume();
//            }
//        });
//
//        zoomMenu = new ContextMenu();
//        MenuItem actualSize = new MenuItem("Actual Size");
//        MenuItem fitToWindow = new MenuItem("Fit to Window");
//        MenuItem centerImage = new MenuItem("Center Image");
//        zoomMenu.getItems().addAll(actualSize, fitToWindow, centerImage);
//
//        actualSize.setOnAction((ae) -> zoomActualSize());
//        fitToWindow.setOnAction((ae) -> zoomFitWindow());
//
//        centerBox.getChildren().add(imagePane);
//
//        tagHistoryDisplay = new ComboBox<>(tagHistoryList);
//        tagHistoryDisplay.disableProperty().bind(buttonsDisabled);
//
//        Button revertHistory = new Button("Revert to Previous tags");
//        revertHistory.disableProperty().bind(buttonsDisabled);
//        revertHistory.disableProperty().bind(buttonsDisabled);
//        revertHistory.setOnMouseClicked((ae) -> {
//            controller.updateTags(tagHistoryDisplay.getValue());
//            controller.saveFile();
//                });
//
//        centerBox.getChildren().add(tagHistoryDisplay);
//        centerBox.getChildren().add(revertHistory);
//
//        centerBox.setAlignment(Pos.CENTER);
//
//        root.setCenter(centerBox);
//
//        // right hand tag editing box
//        VBox tagBox = new VBox();
//        tagBox.setPadding(new Insets(10, 10, 10, 10));
//
//        // current tags, top section
//        Label currentTagsLabel = new Label("Current tags");
//        currentTags = new ListView<>(currentTagsList);
//        currentTags.disableProperty().bind(buttonsDisabled);
//        currentTags.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        currentTags.getSelectionModel().selectedItemProperty()
//                .addListener((c, oldTag, newTag) ->
//                        currentlySelectedTags = new ArrayList<>(currentTags.getSelectionModel().getSelectedItems()));
//
//        currentTags.setOnKeyPressed((ke) -> {
//            if (ke.getCode() == KeyCode.DELETE || ke.getCode() == KeyCode.BACK_SPACE) {
//                controller.removeTagsFromPhoto();
//            }
//        });
//
//        BorderPane currentTagEditBox = new BorderPane();
//        Button addCurrentTag = new Button("Add to photo");
//        Button removeCurrentTag = new Button("Remove from photo");
//        addCurrentTag.disableProperty().bind(buttonsDisabled);
//        removeCurrentTag.disableProperty().bind(buttonsDisabled);
//
//        currentTagEditBox.setPadding(new Insets(2, 0, 5, 0));
//
//        addCurrentTag.setOnMouseClicked((ae) ->
//                controller.addTagsToPhoto(getCurrentlySelectedGlobalTags()));
//        removeCurrentTag.setOnMouseClicked((ae) -> controller.removeTagsFromPhoto());
//
//        currentTagEditBox.setCenter(addCurrentTag);
//        currentTagEditBox.setRight(removeCurrentTag);
//
//        tagBox.getChildren().add(currentTagsLabel);
//        tagBox.getChildren().add(currentTags);
//        tagBox.getChildren().add(currentTagEditBox);
//
//        // global tags, bottom section
//
//        Label allTagsLabel = new Label("Tag Bag");
//        allTags = new ListView<>(allTagsList);
//        allTags.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        allTags.getSelectionModel().selectedItemProperty()
//                .addListener((c, oldTag, newTag) ->
//                        currentlySelectedGlobalTag = new ArrayList<>(allTags.getSelectionModel().getSelectedItems()));
//
//        BorderPane globalTagEditBox = new BorderPane();
//
//        Button addGlobalTag = new Button("Add Tag to Bag");
//        Button removeGlobalTag = new Button("Remove Tag from Bag");
//        globalTagEditBox.setPadding(new Insets(2, 0, 5, 0));
//
//        addGlobalTag.setOnMouseClicked((ae) -> controller.addTagToGlobal());
//        removeGlobalTag.setOnMouseClicked((ae) -> controller.removeTagFromGlobal());
//
//        globalTagEditBox.setCenter(addGlobalTag);
//        globalTagEditBox.setRight(removeGlobalTag);
//
//        // Right click sorting menu
//
//        final ContextMenu sortMenu = new ContextMenu();
//        MenuItem sortBy = new MenuItem("Sort by...");
//        sortBy.setDisable(true);
//        MenuItem alphabetAZ = new MenuItem("Name A-Z");
//        MenuItem alphabetZA = new MenuItem("Name Z-A");
//
//        sortMenu.getItems().addAll(sortBy, alphabetAZ, alphabetZA);
//
//        alphabetAZ.setOnAction((ae) -> controller.sortTagsAZ());
//        alphabetZA.setOnAction((ae) -> controller.sortTagsZA());
//
//        allTags.setContextMenu(sortMenu);
//
//        // Make global tags double clickable
//        // code apapted from:
//        // https://stackoverflow.com/questions/10949461/javafx-2-click-and-double-click
//        allTags.setOnMouseClicked((me) ->
//        {
//            if (photoLoaded && me.getButton() == MouseButton.PRIMARY && me.getClickCount() == 2) {
//                controller.addTagsToPhoto(getCurrentlySelectedGlobalTags());
//            }
//        });
//
//        // Make it so you can drag from globals to photo
//        // code adapted from:
//        // https://javafxdeveloper.wordpress.com/2013/10/28/simple-drag-and-drop-tutorial/
//        // &
//        // http://www.rockhoppertech.com/blog/javafx-drag-and-drop-custom-data/
//
//        allTags.setOnDragDetected((me) ->
//        {
//            Dragboard dragBoard = allTags.startDragAndDrop(TransferMode.MOVE);
//            ClipboardContent content = new ClipboardContent();
//            Tag dragTag = allTags.getSelectionModel().getSelectedItem();
//            content.put(tagDataFormat, dragTag);
//            // adapted from:
//            // https://stackoverflow.com/questions/40662745/
//            // how-convert-any-text-or-letter-to-image-in-javafx
//            Text t = new Text(dragTag.toString());
//            Image dragImage = new Group(t).snapshot(null, null);
//            dragBoard.setDragView(dragImage);
//            dragBoard.setContent(content);
//        });
//
//        currentTags.setOnDragEntered((de) -> currentTags.setBlendMode(BlendMode.OVERLAY));
//
//        currentTags.setOnDragExited((de) -> currentTags.setBlendMode(null));
//
//        currentTags.setOnDragOver((de) -> de.acceptTransferModes(TransferMode.MOVE));
//
//        currentTags.setOnDragDropped((de) ->
//        {
//            controller.addTagsToPhoto(getCurrentlySelectedGlobalTags());
//            de.setDropCompleted(true);
//        });
//
//        allTags.setOnKeyPressed((ke) -> {
//            if (ke.getCode() == KeyCode.DELETE || ke.getCode() == KeyCode.BACK_SPACE) {
//                controller.removeTagFromGlobal();
//            } else if (ke.getCode() == KeyCode.ENTER && photoLoaded) {
//                controller.addTagsToPhoto(getCurrentlySelectedGlobalTags());
//            }
//        });
//
//        tagBox.getChildren().add(allTagsLabel);
//        tagBox.getChildren().add(allTags);
//        tagBox.getChildren().add(globalTagEditBox);
//
//        root.setRight(tagBox);
//
//        // build main menu
        controllerMenu = new MainMenu(controller);
        controllerMenu.prefWidthProperty().bind(theScene.widthProperty());
        root.setTop(controllerMenu);
//
//        Tooltip filePopup = new Tooltip();
//        filePopup.textProperty().bind(fullFileName);
//
//        Label fullFilePath = new Label();
//        fullFilePath.textProperty().bind(fullFileName);
//        fullFilePath.setPrefHeight(14);
//        fullFilePath.setFont(new Font(12));
//        fullFilePath.setTextOverrun(OverrunStyle.LEADING_ELLIPSIS);
//        fullFilePath.setTooltip(filePopup);
//
//        BorderPane bottomDisplay = new BorderPane();
//
//        Button lastPhoto = new Button("<");
//        lastPhoto.disableProperty().bind(hasDirectory.not());
//        lastPhoto.setTextOverrun(OverrunStyle.CLIP);
//        lastPhoto.setPrefWidth(20);
////        lastPhoto.setOnMouseClicked((ae) -> controller.lastPhoto());
//        lastPhoto.setTooltip(new Tooltip("Load previous photo in directory"));
//
//        Button nextPhoto = new Button(">");
//        nextPhoto.disableProperty().bind(hasDirectory.not());
//        nextPhoto.setTextOverrun(OverrunStyle.CLIP);
//        nextPhoto.setPrefWidth(20);
////        nextPhoto.setOnMouseClicked((ae) -> controller.doNothing());
//        nextPhoto.setTooltip(new Tooltip("Load next photo in directory"));
//
//        bottomDisplay.setLeft(lastPhoto);
//        bottomDisplay.setCenter(fullFilePath);
//        bottomDisplay.setRight(nextPhoto);
//
//        root.setBottom(bottomDisplay);


        mainStage.show();

    }


    /**
     * Returns the main stage that hosts the program.
     */
    public Stage getStage() {
        return stage;
    }

    public void doNothing() {}


}
