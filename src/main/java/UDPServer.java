import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UDPServer {
    // Серверный UDP-сокет запущен на этом порту
    public final static int SERVICE_PORT=21346;
    List<Ticket> list = new LinkedList<>();
    Date creationDate = new Date();
    private static final Logger logger = LoggerFactory.getLogger(UDPServer.class);

    public static void main(String[] args) {
        logger.info("Server started");
        new UDPServer(args);
    }

    public UDPServer(String[] args) {
        Receiver2 receiver2 = new Receiver2(list,creationDate);
        Parser parser = new Parser(list);
        parser.parse(args);
        SendThing sendThing;
        SerializationHelper serializationHelper = new SerializationHelper();
        DeserializationHelper deserializationHelper = new DeserializationHelper();
        Scanner sc = new Scanner(System.in);
        try {
            ByteBuffer bytebufferToSend = ByteBuffer.allocate(2048);
            ByteBuffer bytebufferToReceive = ByteBuffer.allocate(2048);
            DatagramChannel channel = DatagramChannel.open();
            channel.configureBlocking(false);
            SocketAddress socketAddress = new InetSocketAddress("localhost", SERVICE_PORT);
            channel.bind(socketAddress);
            SocketAddress socketAddress1;
            while (true) {
                if (System.in.available() > 0) {
                    String s = sc.next();
                    if (s.equals("save")){
                        String k = receiver2.save();
                        logger.info("The collection is saved in a file with the name " + k);
                    }
                    if (s.equals("exit")){
                        String k = receiver2.save();
                        logger.info("The collection is saved in a file with the name " + k);
                        logger.info("Server is down");
                        System.exit(0);
                    }
                }
                socketAddress1 = channel.receive(bytebufferToReceive);
                if (socketAddress1 != null){
                    logger.info("The server received a request");
                    sendThing = (SendThing) deserializationHelper.deSerialization(bytebufferToReceive);
                    String k = receiver2.receive(sendThing.getCommand(),sendThing.getTicket(),sendThing.getArgument());
                    Answer answer = new Answer(k);
                    bytebufferToSend = serializationHelper.serialize(answer);
                    channel.send(bytebufferToSend, socketAddress1);
                    logger.info("Reply sent");
                    bytebufferToSend.clear();
                    bytebufferToReceive.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}