package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

/*

speedr
speed reader

TODO:
    - implement model, view, controller
        - document class
        - view is the gui?
        - controller is the interface
    - main gui
        - open different files instead of hard code
        - full screen option
    - speed slider
    - word chunk size
    - display text
    - keyboard input control
    - text / pdf input

 */


public class Main extends Application {

//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        primaryStage.setTitle("speedr");
//        StackPane root = new StackPane();
//
//        Scene scene = new Scene(root, 400, 400);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//
//        PDDocument document = PDDocument.load(new File("/Users/tylerweston/Desktop/sample.pdf"));
//        Text t = new Text();
//        root.getChildren().add(t);
//        t.setTextAlignment(TextAlignment.CENTER);
//        t.setFont(Font.font("Verdana", 20));
//        StringBuilder doctext = new StringBuilder();
//        if (!document.isEncrypted()) {
//            PDFTextStripper stripper = new PDFTextStripper();
//            doctext.append(stripper.getText(document));
//            System.out.println("Text:" + doctext);
//        }
//        t.setText(doctext.toString());
//        document.close();
//    }

    private Controller controller;

    /**
     * Executes the TagBag program.
     *
     * @param args  main argument to be launched
     */
    public static void main(String[] args) {
        // This is for non-javafx aware environments, this launches the javafx toolkit
        launch(args);
    }

    /**
     * Starts the execution of the program.
     *
     * @param mainStage    the main window that opens when
     *                     the program is first run
     */
    @Override
    public void start(Stage mainStage) {

        Model model = new Model();
        controller = new Controller(model);
        GUI gui = new GUI(mainStage, controller);

        controller.setGUI(gui);

        File f = new File("/Users/tylerweston/Desktop/sample.pdf");
        document doc = new document();
        doc.loadDocument(f);
        System.out.println("Document loaded succesfully");
        for (int i = 0; i < 5; i++) {
            System.out.println("Getting chunk of size 5:");
            String s = doc.getChunk(5);
            System.out.println(s);
        }

    }

    /**
     * Terminates the program.
     */
    @Override
    public void stop() {
        controller.doExit();
    }
}
