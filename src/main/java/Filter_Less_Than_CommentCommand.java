public class Filter_Less_Than_CommentCommand implements Command {
    private Receiver theReceiver;


    public Filter_Less_Than_CommentCommand(Receiver receiver){
        this.theReceiver = receiver;

    }
    @Override
    public SendThing execute() {
        return theReceiver.filter_less_than_commentCommand();
    }
}
