import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


/**
 * Класс парсер
 */
public class Parser {
    List<Ticket> list;

    public Parser(List<Ticket> list) {
        this.list = list;
    }
    public void parse(String[] args) {

        if (args.length==0) return;
        File file = new File(args[0]);
        try {
            Scanner sc = new Scanner(file);
            int count = 0;
            while (sc.hasNext()) {
                String s = sc.nextLine();
                count++;
            }

            if (count % 19 != 0) {
                System.out.println("Файл содержит некорректные значения");
                System.exit(0);
            }
            sc = new Scanner(file);
            for (int i = 0; i < count / 19; i++) {
                int n = 0;
                String s = "";
                Long id = 0L;
                String name = "";
                float x = 0;
                long y = 0;
                Date creationDate = new Date();
                double price = 0;
                String comment = "";
                boolean refundable = true;
                String type = "";
                Long id1 = 0L;
                String name1 = "";
                String description = "";
                String eventType = "";
                s = sc.nextLine();
                try {
                    id = Long.parseLong(sc.nextLine().replaceFirst("\t\"id\":\"", "").replaceFirst("\",", ""));
                } catch (Exception e) {
                    n++;
                }
                try {
                    name = sc.nextLine().replaceFirst("\t\"name\":\"", "").replaceFirst("\",", "");
                } catch (Exception e) {
                    n++;
                }
                s = sc.nextLine();
                try {
                    x = Float.parseFloat(sc.nextLine().replaceFirst("\t\t\"x\":\"", "").replaceFirst("\",", ""));
                } catch (Exception e) {
                    n++;
                }
                try {
                    y = Long.parseLong(sc.nextLine().replaceFirst("\t\t\"y\":\"", "").replaceFirst("\",", ""));
                } catch (Exception e) {
                    n++;
                }
                s = sc.nextLine();
                try {
                    creationDate = new Date(Long.parseLong(sc.nextLine().replaceFirst("\t\"creationDate\":\"", "").replaceFirst("\",", "")));
                } catch (Exception e) {
                    n++;
                }
                try {
                    price = Double.parseDouble(sc.nextLine().replaceFirst("\t\"price\":\"", "").replaceFirst("\",", ""));
                } catch (Exception e) {
                    n++;
                }
                try {
                    comment = sc.nextLine().replaceFirst("\t\"comment\":\"", "").replaceFirst("\",", "");
                } catch (Exception e) {
                    n++;
                }
                try {
                    refundable = Boolean.parseBoolean(sc.nextLine().replaceFirst("\t\"refundable\":\"", "").replaceFirst("\",", ""));
                } catch (Exception e) {
                    n++;
                }
                try {
                    type = sc.nextLine().replaceFirst("\t\"type\":\"", "").replaceFirst("\",", "").toUpperCase();
                } catch (Exception e) {
                    n++;
                }
                s = sc.nextLine();
                try {
                    id1 = Long.parseLong(sc.nextLine().replaceFirst("\t\t\"id\":\"", "").replaceFirst("\",", ""));
                } catch (Exception e) {
                    n++;
                }
                try {
                    name1 = sc.nextLine().replaceFirst("\t\t\"name\":\"", "").replaceFirst("\",", "");
                } catch (Exception e) {

                }
                try {
                    description = sc.nextLine().replaceFirst("\t\t\"description\":\"", "").replaceFirst("\",", "");
                } catch (Exception e) {
                    n++;
                }
                try {
                    eventType = sc.nextLine().replaceFirst("\t\t\"eventType\":\"", "").replaceFirst("\",", "");
                } catch (Exception e) {
                    n++;
                }
                s = sc.nextLine();
                s = sc.nextLine();


                Coordinates c = new Coordinates(x, y);

                Event e;
                if (description.equals("null") || description.equals("")) description = null;
                if (eventType.equals("null") || eventType.equals("")) {
                    e = new Event(id1, name1, description, null);
                } else e = new Event(id1, name1, description, EventType.valueOf(eventType));

                if (comment.equals("null") || comment.equals("")) comment = null;
                Ticket ticket = new Ticket(id, name, c, creationDate, price, comment, refundable, TicketType.valueOf(type), e);
                list.add(ticket);
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Файл не существует");
        }
    }
}

