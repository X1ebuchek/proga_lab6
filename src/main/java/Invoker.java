/**
 * Класс отправитель
 */
public class Invoker {
    private Command helpCommand;
    private Command infoCommand;
    private Command showCommand;
    private Command addCommand;
    private Command updateCommand;
    private Command remove_by_idCommand;
    private Command clearCommand;
    private Command exitCommand;
    private Command add_if_minCommand;
    private Command remove_greaterCommand;
    private Command remove_any_priceCommand;
    private Command count_by_typeCommand;
    private Command filter_less_than_commentCommand;
    private Command historyCommand;
    private Command execute_scriptCommand;

    public Invoker(Command helpCommand, Command infoCommand, Command showCommand, Command addCommand, Command updateCommand,
                   Command remove_by_idCommand, Command clearCommand, Command exitCommand,
                   Command add_if_minCommand, Command remove_greaterCommand, Command remove_any_priceCommand,
                   Command count_by_typeCommand, Command filter_less_than_commentCommand, Command historyCommand, Command execute_scriptCommand){
        this.helpCommand = helpCommand;
        this.infoCommand = infoCommand;
        this.showCommand = showCommand;
        this.addCommand = addCommand;
        this.updateCommand = updateCommand;
        this.remove_by_idCommand = remove_by_idCommand;
        this.clearCommand = clearCommand;
        this.exitCommand = exitCommand;
        this.add_if_minCommand = add_if_minCommand;
        this.remove_greaterCommand = remove_greaterCommand;
        this.remove_any_priceCommand = remove_any_priceCommand;
        this.count_by_typeCommand = count_by_typeCommand;
        this.filter_less_than_commentCommand = filter_less_than_commentCommand;
        this.historyCommand = historyCommand;
        this.execute_scriptCommand = execute_scriptCommand;
    }

    public SendThing help(){
        return helpCommand.execute();
    }
    public SendThing info(){
        return infoCommand.execute();
    }
    public SendThing show(){
        return showCommand.execute();
    }
    public SendThing add(){
        return addCommand.execute();
    }
    public SendThing update(){
        return updateCommand.execute();
    }
    public SendThing remove_by_id(){
        return remove_by_idCommand.execute();
    }
    public SendThing clear(){
        return clearCommand.execute();
    }
    public SendThing exit(){
        return exitCommand.execute();
    }
    public SendThing add_if_min(){
        return add_if_minCommand.execute();
    }
    public SendThing remove_greater(){
        return remove_greaterCommand.execute();
    }
    public SendThing remove_any_price(){
        return remove_any_priceCommand.execute();
    }
    public SendThing count_by_type(){
        return count_by_typeCommand.execute();
    }
    public SendThing filter_less_than_comment(){
        return filter_less_than_commentCommand.execute();
    }
    public void history(){
        historyCommand.execute();
    }
    public SendThing execute_script(){
        return execute_scriptCommand.execute();
    }

}
