public class Count_By_TypeCommand implements Command {
    private Receiver theReceiver;


    public Count_By_TypeCommand(Receiver receiver){
        this.theReceiver = receiver;

    }
    @Override
    public SendThing execute() {
        return theReceiver.count_by_typeCommand();
    }
}
