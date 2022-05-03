import java.io.Serializable;

public class SendThing implements Serializable {
    private Ticket ticket;
    private String command;
    private String argument;

    public SendThing(Ticket ticket, String command, String argument) {
        this.ticket = ticket;
        this.command = command;
        this.argument = argument;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getCommand() {
        return command;
    }

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return "SendThing{" +
                "ticket=" + ticket +
                ", command='" + command + '\'' +
                ", argument='" + argument + '\'' +
                '}';
    }
}
