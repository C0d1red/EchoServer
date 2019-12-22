import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client{
	
	public static void main(String[] args) throws IOException {
		System.out.println("Client start");
		Socket fromServer = null;
		fromServer = new Socket("localHost", 4443);

		PrintWriter out = null;
		out = new PrintWriter(fromServer.getOutputStream());
		out.flush();

		InputStreamReader in = new InputStreamReader(fromServer.getInputStream());
		BufferedReader buff = new BufferedReader(in);

		System.out.println("Print message from client: ");
		Scanner sc = new Scanner(System.in);

		String msg = sc.nextLine();
		out.println(msg);
		out.flush();
		String input = buff.readLine();
		System.out.println("Server: " + input);

		sc.close();
		buff.close();
		fromServer.close();
		in.close();
		out.close();
		
	}
	
}
