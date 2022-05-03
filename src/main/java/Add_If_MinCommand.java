public class Add_If_MinCommand implements Command {
    private Receiver theReceiver;


    public Add_If_MinCommand(Receiver receiver){
        this.theReceiver = receiver;

    }
    @Override
    public SendThing execute() {
        return theReceiver.add_if_minCommand();
    }
}
