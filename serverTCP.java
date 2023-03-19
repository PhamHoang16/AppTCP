import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
public class serverTCP {
    public final static String IP_SERVER = "192.168.1.14";
    public final static int PORT_SERVER = 6543;

    public static void main(String argv[]) throws Exception
    {
        String sentence_from_client;
        String sentence_to_client;

        //Tạo socket server, chờ tại cổng '6543'
        ServerSocket welcomeSocket = new ServerSocket(PORT_SERVER);
        System.out.println("SERVER is running!");

        while (true) {
            //chờ yêu cầu từ client
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("Connect is successful!");

            //Tạo input stream, nối tới Socket
            BufferedReader inFromClient =
                    new BufferedReader(new
                            InputStreamReader(connectionSocket.getInputStream()));

            //Tạo outputStream, nối tới socket
            DataOutputStream outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());

            //Đọc thông tin từ socket
            sentence_from_client = inFromClient.readLine();
            System.out.println("Received data from CLIENT");

            //Xử lý chuỗi chuyển sang Uppercase
            sentence_to_client = sentence_from_client.toUpperCase() + '\n';

            //ghi dữ liệu ra socket
            outToClient.writeBytes(sentence_to_client);
            System.out.println("Sent data to CLIENT");

        }
    }
}