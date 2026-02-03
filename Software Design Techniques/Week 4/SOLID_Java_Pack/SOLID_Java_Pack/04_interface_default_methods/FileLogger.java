import java.io.File;       // Import the File class
import java.io.IOException; // Import IOException to handle errors
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;


public class FileLogger implements Logger {
    final private String fileName;

    public FileLogger(){
        fileName = "log.txt";
    }

    private void createFile(File f) throws IOException{
        f.createNewFile();
    }

    private boolean checkIfFileExists(File f){
        return (f.exists() && !f.isDirectory());
    }

    @Override
    public void log(String level, String message) {
        message = message + '\n';
        File f = new File(this.fileName);

        if (!checkIfFileExists(f)){
            try {
                createFile(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        try {
            Files.writeString(f.toPath(), message, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
