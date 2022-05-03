import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class UDPClient {
    public static String str = "";
    public static boolean script = false;
    public static int lineCounter = 0;
    public static Scanner sc1;
    public static Scanner sc = new Scanner(System.in);
    public final static int SERVICE_PORT = 21346;

    public static void main(String[] args) {
        SerializationHelper serializationHelper = new SerializationHelper();
        DeserializationHelper deserializationHelper = new DeserializationHelper();
        Answer answer;
        boolean send = false;
        int q = 1;
        try {
            ByteBuffer bytebufferToReceive = ByteBuffer.allocate(4096);
            DatagramChannel channel = DatagramChannel.open();
            channel.configureBlocking(false);
            SocketAddress socketAddress = new InetSocketAddress("localhost", SERVICE_PORT);

            System.out.print("Введите команду: ");
            w:while (true) {
                if (System.in.available() > 0) {
                    send = true;
                    String s = sc.next();

                    if (s.equals("execute_script")) q=0;
                    SendThing sendThing;
                    while (script || q==0){
                        q++;
                        System.out.print("Введите команду: ");
                        sendThing = Computer.loop(s);
                        if (sendThing == null){
                            System.out.print("Введите команду: ");
                            continue;
                        }
                        if (sendThing.getCommand().equals("help")){
                            System.out.println(sendThing.getArgument());
                            System.out.print("Введите команду: ");
                            continue;
                        }
                        ByteBuffer bytebufferToSend = serializationHelper.serialize(sendThing);
                        channel.send(bytebufferToSend, socketAddress);
                        bytebufferToSend.clear();
                        SocketAddress socketAddress1 = null;
                        Long time1 = System.currentTimeMillis();
                        while(socketAddress1==null) {
                            socketAddress1 = channel.receive(bytebufferToReceive);
                            Long time2 = System.currentTimeMillis();
                            if (time2-time1>5000 && send){
                                System.out.println("Сервер не доступен");
                                System.out.print("Введите команду: ");
                                send = false;
                                continue w;
                            }
                        }
                        if (socketAddress1 != null) {
                            answer = (Answer) deserializationHelper.deSerialization(bytebufferToReceive);
                            String k = answer.getS();
                            System.out.println(k);
                            bytebufferToReceive.clear();
                        }
                    }
                    Receiver.scripts.clear();
                    if(s.equals("execute_script")){
                        continue;
                    }else sendThing = Computer.loop(s);

                    if (sendThing == null){
                        System.out.print("Введите команду: ");
                        continue;
                    }
                    if (sendThing.getCommand().equals("help")){
                        System.out.println(sendThing.getArgument());
                        System.out.print("Введите команду: ");
                        continue;
                    }
                    ByteBuffer bytebufferToSend = serializationHelper.serialize(sendThing);
                    channel.send(bytebufferToSend, socketAddress);
                    bytebufferToSend.clear();

                    SocketAddress bebra = null;
                    Long time1 = System.currentTimeMillis();
                    while (bebra==null){
                        bebra = channel.receive(bytebufferToReceive);
                        Long time2 = System.currentTimeMillis();
                        if (time2-time1>5000 && send){
                            System.out.println("Сервер не доступен");
                            System.out.print("Введите команду: ");
                            send = false;
                            continue w;
                        }
                    }
                    if (bebra != null) {
                        answer = (Answer) deserializationHelper.deSerialization(bytebufferToReceive);
                        String k = answer.getS();
                        System.out.println(k);
                        bytebufferToReceive.clear();
                        bebra = null;
                        System.out.print("Введите команду: ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public SendThing send(Ticket ticket, String command, String argument){
        return new SendThing(ticket, command, argument);
    }
}
