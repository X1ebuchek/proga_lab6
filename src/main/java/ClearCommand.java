public class ClearCommand implements Command {
    private Receiver theReceiver;


    public ClearCommand(Receiver receiver){
        this.theReceiver = receiver;

    }
    @Override
    public SendThing execute() {
        return theReceiver.clearCommand();
    }
}
