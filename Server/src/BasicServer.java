// file: BasicServer.java

import java.net.Socket;
import java.io.*;

public class BasicServer {
	
	private static int portNumber;
	private static ServerSocket serverSocket;
	private static Socket targetSocket;
	private static PrintWriter targetWriter;
	private static BufferedReader targetReader;

	public static void main(String[] args) {
		// Init
		portNumber = Interger.parseInt(args[0]);
		// IO Init
		try {
			serverSocket = new ServerSocket(portNumber);
			targetSocket = serverSocket.accept();
			targetWriter = new PrintWriter(targetSocket.getOutputStream());
			targetReader = new BufferedReader(
				new InputStreamReader(targetSocket.getInputStream()));
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		// Main Loop
		System.out.println(0);
	}
}