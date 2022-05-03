public class ExitCommand implements Command {
    private Receiver theReceiver;


    public ExitCommand(Receiver receiver){
        this.theReceiver = receiver;

    }
    @Override
    public SendThing execute() {
        return theReceiver.exitCommand();
    }
}
