public class Remove_By_IdCommand implements Command {
    private Receiver theReceiver;


    public Remove_By_IdCommand(Receiver receiver){
        this.theReceiver = receiver;

    }
    @Override
    public SendThing execute() {
        return theReceiver.remove_by_idCommand();
    }
}
