import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class SerializationHelper {
    //Serialization
    ByteArrayOutputStream outputStream;
    ObjectOutputStream oos;


    public SerializationHelper() {
        try {
            outputStream = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(outputStream);

        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public ByteBuffer serialize(Serializable obj) {
        outputStream.reset();
        this.outputStream = new ByteArrayOutputStream();
        try{
            this.oos = new ObjectOutputStream(outputStream);
            oos.writeObject(obj);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ByteBuffer.wrap(outputStream.toByteArray());
    }
}
