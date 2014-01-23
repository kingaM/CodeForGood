package org.centrepoint.ucl;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerMethods {

	public static String sendReq(String req) {

		// ADDREP String, ADDTOP String, REQREP, REQTOP
		
		try {
			Socket skt = new Socket("ec2-79-125-64-3.eu-west-1.compute.amazonaws.com", 1234);
			PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));

			out.println(req);

			while (!in.ready()) {
			}
			String input = in.readLine();
			in.close();
			out.close();
			skt.close();
			return input;
		} catch (Exception e) {
		}
		return "ERROR";
	}

}
