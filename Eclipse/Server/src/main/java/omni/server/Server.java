package omni.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

public class Server {

	private static final Logger log = Logger.getLogger(Server.class);

	private static final int port = 9876;
	private static Socket socket;
	private static boolean serverStatus;
	private static DataInputStream input;
	private static String request;

	public static void main(String[] args) {

		serverStatus = true;
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			log.info("Server started and listening at port : " + port);
			do {
				socket = serverSocket.accept();
				input = new DataInputStream(socket.getInputStream());
				request = input.readUTF();

				if (request.equals("STOP_SERVER"))
					serverStatus = false;
				else
					log.info("Request from client : " + request);

			} while (serverStatus);
		} catch (IOException ioe) {
			log.error(ioe);
		}
	}
}