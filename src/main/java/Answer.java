import java.io.Serializable;

public class Answer implements Serializable {
    private String s;

    public Answer(String s){
        this.s = s;
    }

    public String getS() {
        return s;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "s='" + s + '\'' +
                '}';
    }
}
