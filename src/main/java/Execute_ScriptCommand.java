public class Execute_ScriptCommand implements Command {
    private Receiver theReceiver;


    public Execute_ScriptCommand(Receiver receiver){
        this.theReceiver = receiver;
    }
    @Override
    public SendThing execute() {
        return theReceiver.execute_scriptCommand();
    }
}
