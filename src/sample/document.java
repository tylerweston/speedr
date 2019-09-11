package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

/*
TODO:
    - Strip newlines from text?
    -
*/

public class document {
    private int wordIndex;
    private String[] words;
    boolean docLoaded = false;

    public void loadDocument(File documentPath) {
        // given a path (string?) load a document
        // TODO: determine extension and decide how to handle the document
//        String fname = documentPath.toString();
        String ext2 = fileExtension(documentPath);

        switch (ext2) {
            case "pdf":
                loadPDF(documentPath);
                break;
            case "txt":
                loadTXT(documentPath);
                break;
            case "doc":
                loadDOC(documentPath);
                break;
            default:
                // handle can't load here?
                break;
        }
//        try {
//            PDDocument document = PDDocument.load(documentPath);
//
//            StringBuilder doctext = new StringBuilder();
//            if (!document.isEncrypted()) {
//                PDFTextStripper stripper = new PDFTextStripper();
//                doctext.append(stripper.getText(document));
//            }
//
//            document.close();
//            words = doctext.toString().replaceAll("\n","").split(" ");
//            docLoaded = true;
//
//
//        } catch (IOException e) {
//            //TODO: handle file not found
//            System.out.println("File not found!");
//        }

    }

    public String getChunk(int chunkSize) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // TODO:
        //  - what happens if we reach end of words here?
        //  - should this be < words.length or <= words.length??
        //  - this is where we determine if our passage is finished
        //    if it is, we need to tell someone that so we can,
        //    ie. change play->pause, etc.
        while (i < chunkSize && wordIndex + i < words.length) {
            sb.append(words[wordIndex + i]);
            sb.append(" ");
            i++;
        }
        wordIndex += chunkSize;
        return sb.toString();  //return next chunkSize words
    }

    public void setIndex(int wordIndex) {
        this.wordIndex = wordIndex;
    }

    public void resetIndex() {
        wordIndex = 0;
    }

    public boolean isDocLoaded() {
        return docLoaded;
    }

    private void loadPDF(File documentPath) {
        try {
            PDDocument document = PDDocument.load(documentPath);

            StringBuilder doctext = new StringBuilder();
            if (!document.isEncrypted()) {
                PDFTextStripper stripper = new PDFTextStripper();
                doctext.append(stripper.getText(document));
            }

            document.close();
            words = doctext.toString().replaceAll("\n","").split(" ");
            docLoaded = true;
            resetIndex();


        } catch (IOException e) {
            //TODO: handle file not found
            System.out.println("Error loading PDF!");
            docLoaded = false;
        }
    }

    private void loadTXT(File documentPath) {
        //TODO: test this: does it work?
        // code from: https://www.technical-recipes.com/2011/reading-text-files-into-string-arrays-in-java/
        try {
            FileReader fileReader = new FileReader(documentPath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<String>();
            String line = null;

            while ((line = bufferedReader.readLine()) != null)
            {
                lines.add(line);
            }

            bufferedReader.close();
            // TODO: cleaner way to do this!
            words = lines.toString().split(" ");
            docLoaded = true;
            resetIndex();

        } catch (IOException e) {
            //TODO: handle file not found
            System.out.println("Error loading TXT!");
            docLoaded = false;
        }
    }

    private void loadDOC(File documentPath) {
        // TODO:
        docLoaded = false;
        System.out.println("Not supported yet!!");
    }

    // rewrite eventually: (or grab from apache io or something)
    // taken from https://www.tutorialspoint.com/get-file-extension-name-in-java
    private static String fileExtension(File file) {
        String name = file.getName();
        if(name.lastIndexOf(".") != -1 && name.lastIndexOf(".") != 0)
            return name.substring(name.lastIndexOf(".") + 1);
        else
            return "";
    }

}
