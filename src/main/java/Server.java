import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class Server {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Server start");
		ServerSocket server = new ServerSocket(4443);
		Socket fromClient = server.accept();

		InputStreamReader in = new InputStreamReader(fromClient.getInputStream());
		PrintWriter out = new PrintWriter(fromClient.getOutputStream());
		BufferedReader buff = new BufferedReader(in);

		String input = buff.readLine();
		out.println(input);
		out.flush();

		in.close();
		out.close();
		server.close();
		fromClient.close();
	}
}
