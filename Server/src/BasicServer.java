// file: BasicServer.java

import java.net.*;
import java.io.*;

public class BasicServer {
	
	private static int portNumber;
	private static ServerSocket serverSocket;
	private static Socket targetSocket;
	private static PrintWriter targetWriter;
	private static BufferedReader targetReader;

	private static void serverInit(int initPortNumber) {
		// Init
		portNumber = initPortNumber;
		// IO Init
		try {
			System.out.println("Initialising server");
			System.out.println("Opening ServerSocket @ Port: " + portNumber);
			serverSocket = new ServerSocket(portNumber);
			System.out.println("Waiting for client");
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	private static void openConnection() {
		// Opens connection with client
		try {
			targetSocket = serverSocket.accept();
			System.out.println("Connected to client");
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// Server Initialisation
		serverInit(Integer.parseInt(args[0]));
		// Find & Connect w/Client
		openConnection();
		// Main Loop
		System.out.println(0);
	}
}