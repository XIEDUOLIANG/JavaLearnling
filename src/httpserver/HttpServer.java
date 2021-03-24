package httpserver;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/*public class HttpServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("server is running ...");
        for(;;){
            Socket socket = serverSocket.accept();
            System.out.println("connection from:"+socket.getRemoteSocketAddress());
            Thread thread = new Thread(new Handler(socket));
            thread.start();
        }
    }
}

class Handler implements Runnable{

    private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(InputStream inputStream = this.socket.getInputStream()){
            try(OutputStream outputStream = this.socket.getOutputStream()){
                handle(inputStream,outputStream);
            }
        }catch (Exception e){
            try {
                this.socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            ;
        }
    }

    private void handle(InputStream inputStream,OutputStream outputStream) throws IOException {
        System.out.println("process new HttpRequest ...");
        var reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        var writer = new BufferedWriter(new OutputStreamWriter(outputStream,StandardCharsets.UTF_8));

        boolean requestOk = false;
        String first = reader.readLine();
        if(first.startsWith("GET / HTTP/1.")){
            requestOk = true;
        }
        while (true){
            String header = reader.readLine();
            if(header.isEmpty()){
                break;
            }
            System.out.println(header);
        }
        System.out.println(requestOk ? "responseOk" : "responseError");
        if (!requestOk) {
            // 发送错误响应:
            writer.write("404 Not Found\r\n");
            writer.write("Content-Length: 0\r\n");
            writer.write("\r\n");
        } else {
            // 发送成功响应:
            String data = "<html><body><h1>Hello, world!</h1></body></html>";
            int length = data.getBytes(StandardCharsets.UTF_8).length;
            writer.write("HTTP/1.0 200 OK\r\n");
            writer.write("Connection: close\r\n");
            writer.write("Content-Type: text/html\r\n");
            writer.write("Content-Length: " + length + "\r\n");
            writer.write("\r\n"); // 空行标识Header和Body的分隔
            writer.write(data);
        }
        writer.flush();

    }
}*/
