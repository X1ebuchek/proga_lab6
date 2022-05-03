public class SendObject {
    private Object object;
    private String command;

    public SendObject(Object object, String command) {
        this.object = object;
        this.command = command;
    }

    @Override
    public String toString() {
        return "SendObject{" +
                "object=" + object +
                ", command='" + command + '\'' +
                '}';
    }
}
