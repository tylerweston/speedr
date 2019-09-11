package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

class MainMenu extends MenuBar {

    private final BooleanProperty setDisabled = new SimpleBooleanProperty(true);

    /**
     * Creates a new main Menu for the program.
     *
     * @param controller    a controller object to manage
     *                      executive functions
     */
    MainMenu(Controller controller) {

        // file menu

        final Menu fileMenu = new Menu("_File");
        fileMenu.setAccelerator(new KeyCodeCombination(KeyCode.F, KeyCombination.SHORTCUT_DOWN));

        MenuItem fileOpen = new MenuItem("_Open");
        fileOpen.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.SHORTCUT_DOWN));
        fileOpen.setOnAction((ae) -> controller.openFile());
        fileMenu.getItems().add(fileOpen);

        fileMenu.getItems().add(new SeparatorMenuItem());

        MenuItem fileExit = new MenuItem("E_xit");
        fileExit.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.SHORTCUT_DOWN));
        fileExit.setOnAction((ae) -> controller.doExit());
        fileMenu.getItems().add(fileExit);



        // tools menu

        final Menu optionsMenu = new Menu("_Options");
        optionsMenu.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.SHORTCUT_DOWN));

        MenuItem optionsPreferences = new MenuItem("_Preferences");
        optionsPreferences.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCombination.SHORTCUT_DOWN));
        optionsPreferences.setOnAction((ae) -> controller.showPreferences());
//        optionsPreferences.disableProperty().bind(setDisabled);
//
//
//        MenuItem toolsRenamingLog = new MenuItem("_Renaming Log");
//        toolsRenamingLog.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.SHORTCUT_DOWN));
////        toolsRenamingLog.setOnAction((ae) -> controller.openLog());
//
//        MenuItem toolsTagFolder = new MenuItem("Tag _Folder");
//        toolsTagFolder.setAccelerator(new KeyCodeCombination(KeyCode.F, KeyCombination.SHORTCUT_DOWN));
////        toolsTagFolder.setOnAction((ae) -> controller.TagFolder());



        optionsMenu.getItems().add(optionsPreferences);
//        optionsMenu.getItems().add(new SeparatorMenuItem());
//        optionsMenu.getItems().add(toolsRenamingLog);
//        optionsMenu.getItems().add(toolsTagFolder);


        // about menu

        final Menu aboutMenu = new Menu("About");
//        MenuItem aboutItem = new MenuItem("About");
        aboutMenu.setOnAction((ae) -> controller.showAbout());
//        aboutMenu.getItems().add(aboutItem);

        this.getMenus().addAll(fileMenu, optionsMenu, aboutMenu);
    }

    /**
     * Enable menu options that should only be available when a photo is loaded
     */
    void enableView() {
        setDisabled.setValue(false);
    }
}
