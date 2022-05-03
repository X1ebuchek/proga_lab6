public class ShowCommand implements Command {
    private Receiver theReceiver;

    public ShowCommand(Receiver receiver){
        this.theReceiver = receiver;
    }
    @Override
    public SendThing execute() {
        return theReceiver.showCommand();
    }
}
