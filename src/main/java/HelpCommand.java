public class HelpCommand implements Command {
private Receiver theReceiver;

    public HelpCommand(Receiver receiver){
        this.theReceiver = receiver;
    }
    @Override
    public SendThing execute() {
        return theReceiver.helpCommand();
    }
}
