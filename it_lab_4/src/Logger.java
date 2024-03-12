import java.io.*;

public class Logger {
    protected File loggingFile;

    public Logger() {
        loggingFile = new File("log.txt");
    }

    public void logToFile(String s) {
        FileOutputStream fileStream = null;
        try {
            fileStream = new FileOutputStream(loggingFile, true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            fileStream.write(s.getBytes());
            fileStream.write("\n".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
