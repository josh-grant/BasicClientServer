// file: BasicClient.java

import java.net.Socket;
import java.io.*;

public class BasicClient {

	private static String hostName;
	private static int portNumber;
	private static Socket targetSocket;
	private static PrintWriter targetWriter;
	private static BufferedReader targetReader;

	public static void main(String[] args) {
		// Init
		hostName = args[0];
		portNumber = Integer.parseInt(args[1]);
		// IO Init
		try {
			System.out.println(0);
			targetSocket = new Socket(hostName, portNumber);
			System.out.println(1);
			targetWriter = new PrintWriter(targetSocket.getOutputStream());
			System.out.println(2);
			targetReader = new BufferedReader(
			new InputStreamReader(targetSocket.getInputStream()));
			System.out.println(4);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		// Main Loop
		System.out.println(0);
	}
}