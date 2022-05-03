import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Класс для подсчёта строк в файле
 */
public class LineCounter {
    public static int count(String n){
        File file = new File(n);
        Scanner sc = new Scanner(n);

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        byte[] byteArray = new byte[(int)file.length()];
        try {
            fis.read(byteArray);
        } catch (IOException e) {
            //e.printStackTrace();
        }
        String data = new String(byteArray);
        String[] stringArray = data.split("\r\n");
        return stringArray.length;
    }
}
