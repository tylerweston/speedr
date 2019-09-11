package sample;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

class MainMenu extends MenuBar {

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

        optionsMenu.getItems().add(optionsPreferences);

        // about menu

        final Menu aboutMenu = new Menu("About");
        aboutMenu.setOnAction((ae) -> controller.showAbout());

        this.getMenus().addAll(fileMenu, optionsMenu, aboutMenu);
    }

}
