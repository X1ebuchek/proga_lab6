import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Receiver2 {
    List<Ticket> list;
    Date creationDate;

    public Receiver2(List<Ticket> list, Date creationDate) {
        this.list = list;
        this.creationDate = creationDate;
    }

    public String receive(String command, Ticket ticket, String argument){
        switch (command){
            case "add":
                return add(ticket);
            case "update":
                return update(ticket,argument);
            case "show":
                return show();
            case "info":
                return info();
            case "clear":
                return clear();
            case "add_if_min":
                return add_if_min(ticket);
            case "remove_by_id":
                return remove_by_id(argument);
            case "remove_greater":
                return remove_greater(ticket);
            case "history":
            case "remove_any_by_price":
                return remove_any_by_price(argument);
            case "count_by_type":
                return count_by_type(argument);
            case "filter_less_than_comment":
                return filter_less_than_comment(argument);
        }
        return null;
    }
    public String add(Ticket ticket){
        list.add(ticket);
        return "Элемент успешно добавлен";
    }
    public String update(Ticket ticket, String argument){
        try {
            Ticket t = list.stream().filter(x->x.getId().equals(Long.parseLong(argument))).findFirst().get();
            list.remove(t);
            list.add(ticket);
            Collections.sort(list);
            return "Элемент успешно заменён";
        }catch (Exception e){
            return "Элемента с данным id нет в коллекции";
        }
    }
    public String show(){
        String s = "";
        for (Ticket ticket : list) {
            s = s + ticket.toString() + "\n";
        }
        return s;
    }
    public String info(){
        String s = "";
        s += "Тип: LinkedList\n";
        s += "Время инициализации: " + creationDate + "\n";
        s += "Количество элементов: " + list.size();
        return s;
    }
    public String remove_by_id(String argument){
        try {
            Ticket t = list.stream().filter(x->x.getId().equals(Long.parseLong(argument))).findFirst().get();
            list.remove(t);
            return "Элемент успешно удалён";
        }catch (Exception e){
            return "Элемента с данным id нет в коллекции";
        }
    }
    public String clear(){
        list.clear();
        return "Коллекция очищена";
    }
    public String add_if_min(Ticket ticket){
        Ticket t = list.stream().min((x1,x2)->x1.getPrice().compareTo(x2.getPrice())).get();
        if (ticket.getPrice()<t.getPrice()){
            list.add(ticket);
            return "Элемент успешно добавлен";
        }
        return "Элемент не был добавлен, т.к. его цена не наименьшая";
    }
    public String remove_greater(Ticket ticket){
        list = list.stream().filter(x->x.getPrice()<ticket.getPrice()).collect(Collectors.toList());
        return "Элементы удалены";
    }
    public String remove_any_by_price(String argument){
        try {
            Ticket t = list.stream().filter(x->x.getPrice().equals(Double.parseDouble(argument))).findFirst().get();
            list.remove(t);
            return "Элемент с заданной ценой удалён";
        }catch (Exception e){
            return "Элемента с заданной ценой нет в коллекции";
        }
    }

    public String count_by_type(String argument){
        return String.valueOf(list.stream().filter(x->x.getType().equals(TicketType.valueOf(argument))).count());
    }

    public String filter_less_than_comment(String argument){
        return list.stream().filter(x->x.getComment().length()<argument.length()).map(Ticket::toString).collect(Collectors.joining("\n"));
    }
    public String save(){
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (true) {
            System.out.print("Введите название файла: ");
            s = sc.next();
            File file = new File(s);
            try {
                FileWriter writer = new FileWriter(file);
                for (int i = 0; i < list.size(); i++) {
                    writer.write("\"" + "Ticket" + (i + 1) + "\"" + ":{" + "\n");
                    writer.write("\t" + "\"" + "id" + "\"" + ":\"" + list.get(i).getId() + "\"," + "\n");
                    writer.write("\t" + "\"" + "name" + "\"" + ":\"" + list.get(i).getName() + "\"," + "\n");
                    writer.write("\t" + "\"" + "Coordinates" + "\"" + ":{" + "\n");
                    writer.write("\t\t" + "\"" + "x" + "\"" + ":\"" + list.get(i).getCoordinates().getX() + "\"," + "\n");
                    writer.write("\t\t" + "\"" + "y" + "\"" + ":\"" + list.get(i).getCoordinates().getY() + "\"," + "\n");
                    writer.write("\t}\n");
                    writer.write("\t" + "\"" + "creationDate" + "\"" + ":\"" + list.get(i).getCreationDate() + "\"," + "\n");
                    writer.write("\t" + "\"" + "price" + "\"" + ":\"" + list.get(i).getPrice() + "\"," + "\n");
                    writer.write("\t" + "\"" + "comment" + "\"" + ":\"" + list.get(i).getComment() + "\"," + "\n");
                    writer.write("\t" + "\"" + "refundable" + "\"" + ":\"" + list.get(i).isRefundable() + "\"," + "\n");
                    writer.write("\t" + "\"" + "type" + "\"" + ":\"" + list.get(i).getType() + "\"," + "\n");
                    writer.write("\t" + "\"" + "Event" + "\"" + ":{" + "\n");
                    writer.write("\t\t" + "\"" + "id" + "\"" + ":\"" + list.get(i).getEvent().getId() + "\"," + "\n");
                    writer.write("\t\t" + "\"" + "name" + "\"" + ":\"" + list.get(i).getEvent().getName() + "\"," + "\n");
                    writer.write("\t\t" + "\"" + "description" + "\"" + ":\"" + list.get(i).getEvent().getDescription() + "\"," + "\n");
                    writer.write("\t\t" + "\"" + "eventType" + "\"" + ":\"" + list.get(i).getEvent().getEventType() + "\"," + "\n");
                    writer.write("\t}\n");
                    if (i == list.size() - 1) {
                        writer.write("}");
                    } else writer.write("}\n");
                }
                System.out.println("Файл создан");
                writer.close();
                break;
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("Файл уже существует");
            }
        }
        return s;
    }
}
