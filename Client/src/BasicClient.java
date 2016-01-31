// file: BasicClient.java

import java.net.Socket;
import java.io.*;

public class BasicClient {

	private static String hostName;
	private static int portNumber;
	private static Socket targetSocket;
	private static PrintWriter targetWriter;
	private static BufferedReader targetReader;
	private static Console inputScanner;
	private static String inputLine;

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
			System.out.println("");
			targetWriter = new PrintWriter(targetSocket.getOutputStream(), true);
			targetReader = new BufferedReader(
			new InputStreamReader(targetSocket.getInputStream()));
			inputScanner = System.console();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	private static void clientDisconnect() {
		try {
			targetWriter.println("Session terminated");
			targetWriter.println("");
			targetSocket.close();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	private static void inputScanner() {
		while (true) {
			inputLine = inputScanner.readLine(">>");
			if (inputLine.equals("exit()") || inputLine.equals("quit()")) {
				System.out.println("Termination session");
				clientDisconnect();
				System.out.println("Session terminated");
				break;
			}
			if (inputLine != null) {
				targetWriter.println(inputLine);
			}
		}
	}
	public static void main(String[] args) {
		// Init
		clientInit(args[0], Integer.parseInt(args[1]));
		// Main Loop
		inputScanner();
	}
}