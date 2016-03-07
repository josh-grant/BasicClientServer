// file: BasicClient.java
//
// author: Josh Grant 2016
//
// Lightweight client which streams input to socket

import java.net.Socket;
import java.io.*;

public class BasicClient {

	private static String hostName;
	private static int portNumber;
	private static Socket targetSocket;
	private static PrintWriter targetWriter;
	private static Console inputScanner;
	private static String outputLine;

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
			inputScanner = System.console();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	private static void clientDisconnect() {
		try {
			targetWriter.println("Session terminated");
			targetSocket.close();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	private static void inputScanner() {
		while (true) {
			outputLine = inputScanner.readLine(">>");
			if (outputLine.equals("exit()") || outputLine.equals("quit()")) {
				System.out.println("Terminating session");
				clientDisconnect();
				System.out.println("Session terminated");
				break;
			}
			if (outputLine != null) {
				targetWriter.println(outputLine);
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