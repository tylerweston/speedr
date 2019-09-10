package sample;

import java.io.File;
import java.io.IOException;
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

    public void loadDocument(File documentPath) {
        // given a path (string?) load a document
        try {
            PDDocument document = PDDocument.load(documentPath);

            StringBuilder doctext = new StringBuilder();
            if (!document.isEncrypted()) {
                PDFTextStripper stripper = new PDFTextStripper();
                doctext.append(stripper.getText(document));
            }

            document.close();
            words = doctext.toString().split(" ");

        } catch (IOException e) {
            //TODO: handle file not found
            System.out.println("File not found!");
        }
    }

    public String getChunk(int chunkSize) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // TODO:
        //  - what happens if we reach end of words here?
        //  - should this be < words.length or <= words.length??
        while (i < chunkSize && wordIndex < words.length) {
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
}
