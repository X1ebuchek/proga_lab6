public class HistoryCommand implements Command {
    private Receiver theReceiver;


    public HistoryCommand(Receiver receiver){
        this.theReceiver = receiver;
    }
    @Override
    public SendThing execute() {
        return theReceiver.historyCommand();
    }
}
