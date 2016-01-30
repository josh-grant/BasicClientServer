// file: BasicClient.java

import java.net.Socket;
import java.io.*;

public class BasicClient {

	private static String hostName;
	private static int portNumber;
	private static Socket targetSocket;
	private static PrintWriter targetWriter;
	private static BufferedReader targetReader;
	private final static String killCode = "Terminate Process";

	private static void clientInit(String initHostName, int initPortNumber) {
		// Init
		System.out.println("Initialising client");
		hostName = initHostName;
		portNumber = initPortNumber;
		// IO Init
		try {
			System.out.println("Initialising socket connection");
			targetSocket = new Socket(hostName, portNumber);
			System.out.println("Connected to server");
			targetWriter = new PrintWriter(targetSocket.getOutputStream(), true);
			targetReader = new BufferedReader(
			new InputStreamReader(targetSocket.getInputStream()));
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// Init
		clientInit(args[0], Integer.parseInt(args[1]));
		// Main Loop
		targetWriter.println(1);
		targetWriter.println(2);
		targetWriter.println(killCode);
		targetWriter.println(3);
	}
}