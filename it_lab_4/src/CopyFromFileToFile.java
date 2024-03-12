import java.io.*;
import java.nio.channels.FileChannel;

public class CopyFromFileToFile {
    public static void main(String[] args) {
        copy(new File("source.txt"), new File("destination.txt"));
    }
    public static void copy(final File file1, final File file2) {
        FileChannel src = null;
        try {
            src = new FileInputStream(file1).getChannel();
        } catch (FileNotFoundException e) {
            System.out.println("Исходный файл не найден");
        }
        FileChannel dest = null;
        try {
            dest = new FileOutputStream(file2).getChannel();
        } catch (FileNotFoundException e) {
            System.out.println("Файл записи не найден");
        }
        try {
            dest.transferFrom(src, 0, src.size());
        } catch (IOException e) {
            System.out.println("Ошибка чтения или записи");
        }
    }
}
