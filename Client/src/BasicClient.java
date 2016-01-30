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
			targetSocket = new Socket(hostName, portNumber);
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