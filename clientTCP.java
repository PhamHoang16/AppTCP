import java.io.*;
import java.net.Socket;
public class clientTCP {
    public final static String IP_SERVER = "192.168.1.14";
    public final static int PORT_SERVER = 6543;
    public static void main(String argv[]) throws Exception
    {
        String sentence_to_server;
        String sentence_from_server;
        System.out.println("Network Application using TCP protocol");
        System.out.println("    --------------------------");
        while (true) {
            System.out.print("Input from client: ");
            BufferedReader inFromUser =
                    new BufferedReader(new InputStreamReader(System.in));

            //Lấy chuỗi ký tự nhập từ bàn phím
            sentence_to_server = inFromUser.readLine();

            //Tạo socket cho client kết nối đến server qua ID address và port number
            Socket clientSocket = new Socket(IP_SERVER, PORT_SERVER);

            //Tạo OutputStream nối với Socket
            DataOutputStream outToServer =
                    new DataOutputStream(clientSocket.getOutputStream());

            //Tạo inputStream nối với Socket
            BufferedReader inFromServer =
                    new BufferedReader(new
                            InputStreamReader(clientSocket.getInputStream()));

            //Gửi chuỗi ký tự tới Server thông qua outputStream đã nối với Socket
            outToServer.writeBytes(sentence_to_server + '\n');
            System.out.println("Data was sent to SERVER");

            //Đọc tin từ Server thông qua InputSteam đã nối với Socket
            sentence_from_server = inFromServer.readLine();

            System.out.println("FROM SERVER: " + sentence_from_server);

            //clientSocket.close();
        }
    }
}