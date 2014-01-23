package org.centrepoint.ucl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import android.util.Log;

/**
 * 
 * THIS CLASS CONTAINS DUMMY DATA AS OPPOSED TO THE REAL IMPLEMENTATION USING A
 * SERVER DATABASE
 * 
 */

public class DummyServer {

	private static ArrayList<String> dummyjArray_topics = new ArrayList<String>();
	private static ArrayList<String> dummyjArray_replies = new ArrayList<String>();

	static final String split = "@@split@@";
	static final String end = "@@end@@";

	/*
	 * public static void initDummyData() { // new order: key, category, date,
	 * user, score, title, message dummyjArray_topics
	 * .add("1\\general\\6th Dec 23:04\\Homeless_Herder\\4\\My topic\\Chat message"
	 * ); dummyjArray_topics .add(
	 * "2\\housing\\7th Dec 11:10\\\\6\\Help! Michael approaches\\It was horrible"
	 * );
	 * 
	 * // new order: key, topic_key, date, user, score, message
	 * dummyjArray_replies.add("1\\1\\7th Dec 10:55\\\\3\\blah blah");
	 * dummyjArray_replies.add("2\\1\\8th Jan 11:30\\Ben\\20\\Synergy"); }
	 */

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
			Log.d("test", e.getMessage());
		}
		return "ERROR";
	}

	public static void toDeathString(String table) {
		String s = "ADD" + table + " ";
		if (table.equals("REP")) {
			for (String st : dummyjArray_replies) {
				s = s.concat(st + end);
			}
		} else {
			for (String st : dummyjArray_topics) {
				s = s.concat(st + end);
			}
		}
		s = s.substring(0, s.length() - end.length());
		Log.i("Sending to server: ", s);
		sendReq(s);
	}

	public static void fromDeathString(String table) {
		String s = sendReq("REQ" + table + " ");
		Log.i("Recieving from server: ", s);
		if (s != null && s.length() != 0) {
			String[] strings = s.split(end);
			if (table.equals("REP")) {
				dummyjArray_replies.clear();
				for (int k = 0; k < strings.length; k++) {
					dummyjArray_replies.add(strings[k]);
				}
			} else {
				dummyjArray_topics.clear();
				for (int k = 0; k < strings.length; k++) {
					dummyjArray_topics.add(strings[k]);
				}
			}
		}
	}

	public static void setRepliesData() {
		toDeathString("REP");
	}

	public static void setTopicsData() {
		toDeathString("TOP");
	}

	public static ArrayList<String> getRepliesData() {
		fromDeathString("REP");
		return dummyjArray_replies;
	}

	public static ArrayList<String> getTopicsData() {
		fromDeathString("TOP");
		return dummyjArray_topics;
	}

	public static void sendTopic(String in) {
		dummyjArray_topics.add(in);
		toDeathString("TOP");
	}

	public static void sendReply(String in) {
		dummyjArray_replies.add(in);
		toDeathString("REP");
	}

	public static int getTopicsSize() {
		return dummyjArray_topics.size();
	}

	public static int getRepliesSize() {
		return dummyjArray_replies.size();
	}

	public static ArrayList<String> mySplit(String s, String remove) {

		ArrayList<String> result = new ArrayList<String>();
		int rSize = remove.length();
		int i = 0;
		while ((i = s.indexOf(remove)) != -1) {
			result.add(s.substring(0, i));
			s = s.substring(i + rSize);
		}

		if (s.length() > 1)
			result.add(s);

		return result;
	}
}
