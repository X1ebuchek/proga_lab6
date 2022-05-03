public class Remove_Any_By_PriceCommand implements Command {
    private Receiver theReceiver;


    public Remove_Any_By_PriceCommand(Receiver receiver){
        this.theReceiver = receiver;

    }
    @Override
    public SendThing execute() {
        return theReceiver.remove_any_by_priceCommand();
    }
}
