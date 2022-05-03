/**
 * Класс клиент
 */
public class Computer {

    static String history1 = "";
    static String history2 = "";
    static String history3 = "";
    static String history4 = "";
    static String history5 = "";
    static String history6 = "";
    public static SendThing loop(String s) {

        Receiver r = new Receiver();
        Command helpCommand = new HelpCommand(r);
        Command infoCommand = new InfoCommand(r);
        Command showCommand = new ShowCommand(r);
        Command addCommand = new AddCommand(r);
        Command updateCommand = new UpdateCommand(r);
        Command remote_by_idCommand = new Remove_By_IdCommand(r);
        Command clearCommand = new ClearCommand(r);
        Command exitCommand = new ExitCommand(r);
        Command add_if_minCommand = new Add_If_MinCommand(r);
        Command remove_greaterCommand = new Remove_GreaterCommand(r);
        Command remove_any_priceCommand = new Remove_Any_By_PriceCommand(r);
        Command count_by_typeCommand = new Count_By_TypeCommand(r);
        Command filter_less_than_commentCommand = new Filter_Less_Than_CommentCommand(r);
        Command historyCommand = new HistoryCommand(r);
        Command execute_scriptCommand = new Execute_ScriptCommand(r);

        Invoker i = new Invoker(helpCommand, infoCommand, showCommand, addCommand, updateCommand,
                remote_by_idCommand, clearCommand, exitCommand, add_if_minCommand,
                remove_greaterCommand, remove_any_priceCommand, count_by_typeCommand, filter_less_than_commentCommand,
                historyCommand, execute_scriptCommand);


        history1 = history2;
        history2 = history3;
        history3 = history4;
        history4 = history5;
        history5 = history6;
        history6 = s;

            switch (s) {
                case "help":
                    return i.help();
                case "info":
                    return i.info();
                case "show":
                    return i.show();
                case "add":
                    return i.add();
                case "exit":
                    return i.exit();
                case "history":
                    i.history();
                    break;
                case "execute_script":
                    return i.execute_script();
                case "update":
                    return i.update();
                case "remove_by_id":
                    return i.remove_by_id();
                case "clear":
                    return i.clear();
                case "add_if_min":
                    return i.add_if_min();
                case "remove_greater":
                    return i.remove_greater();
                case "remove_any_by_price":
                    return i.remove_any_price();
                case "count_by_type":
                    return i.count_by_type();
                case "filter_less_than_comment":
                    return i.filter_less_than_comment();
                default:
                    System.out.println("Такой команды не существует");
            }
            return null;
    }
}
