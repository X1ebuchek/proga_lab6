import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Класс, который определяет откуда надо считывать(клавиатура, скрипт)
 */
public class Reader {
    int i = 0;
    static long w = 0;

    public String read(String n){
        if (n.isEmpty()){
            UDPClient.str = "";
            return UDPClient.sc.next();
        }
        if (!UDPClient.str.equals(n) || Receiver.kek){
            UDPClient.lineCounter = 0;
            Receiver.kek = false;
            UDPClient.str = n;
            try {
                File file = new File(n);
                UDPClient.sc1 = new Scanner(file);
                while (UDPClient.sc1.hasNext()) {
                    String s = UDPClient.sc1.nextLine();
                    UDPClient.lineCounter++;
                }
                UDPClient.sc1 = new Scanner(file);
                if (UDPClient.sc1.hasNext()){
                    String q = UDPClient.sc1.next();
                    System.out.println(q);
                    if (q.equals("update") || q.equals("remove_by_id") || q.equals("execute_script") || q.equals("remove_any_by_price")
                            || q.equals("count_by_type") || q.equals("filter_less_than_comment")) UDPClient.lineCounter++;
                    UDPClient.lineCounter--;
                    if (UDPClient.lineCounter<=0){
                        UDPClient.script = false;
                        UDPClient.str = "";
                        Receiver.scriptNow = "";
                        UDPClient.lineCounter = 0;
                    }
                    return q;
                }
                else {
                    UDPClient.str = "";
                    return UDPClient.sc.next();
                }
            } catch (FileNotFoundException e) {
                //e.printStackTrace();
                UDPClient.str = "";
                return UDPClient.sc.next();
            }
        }
        if (!(UDPClient.sc1 == null) && UDPClient.sc1.hasNext()){
            String e = UDPClient.sc1.next();
            System.out.println(e);
            if (e.equals("update") || e.equals("remove_by_id") || e.equals("execute_script") || e.equals("remove_any_by_price")
            || e.equals("count_by_type") || e.equals("filter_less_than_comment")) UDPClient.lineCounter++;
            UDPClient.lineCounter--;
            if (UDPClient.lineCounter<=0){
                UDPClient.script = false;
                UDPClient.str = "";
                Receiver.scriptNow = "";
                UDPClient.lineCounter = 0;
            }
            return e;
        }
        UDPClient.str = "";
        return UDPClient.sc.next();
    }
}
