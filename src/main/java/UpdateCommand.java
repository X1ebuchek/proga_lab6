public class UpdateCommand implements Command {
    private Receiver theReceiver;


    public UpdateCommand(Receiver receiver){
        this.theReceiver = receiver;

    }
    @Override
    public SendThing execute() {
        return theReceiver.updateCommand();
    }
}
