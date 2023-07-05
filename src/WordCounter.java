import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        // okay implement a program that opens up a directory then fetches the document and says how many words are there
        String path = "C:\\Users\\Paul\\Documents";
        File directory = new File(path);
        Desktop desktop = Desktop.getDesktop();

        int getCount = getWordCount(desktop,directory);
        System.out.println(getCount);
        System.exit(0);

    }
    public static int getWordCount(Desktop desktop, File directory) throws IOException {
        if (desktop.isSupported(Desktop.Action.OPEN) && directory.exists() && directory.isDirectory()){
            FileDialog fileDialog = new FileDialog((Dialog) null, "Select a file", FileDialog.LOAD);
            fileDialog.setDirectory(directory.getAbsolutePath());
            fileDialog.setVisible(true);
            String selectedFile = fileDialog.getFile();
            File otherFile = new File(directory, selectedFile);
            FileReader fileReader = new FileReader(otherFile);
            int count =0;

            while(fileReader.read()!=-1){
                count++;
            }

            return count;
        }
        return 0;
    }
}
