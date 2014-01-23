package org.centrepoint.ucl;

import java.util.ArrayList;
import android.util.Log;

/**
 * 
 * THIS CLASS THAT WOULD INTERACT WITH THE DATABASE/SERVER PHP, BUT THE CURRENT
 * DUMMY IMPLEMENTATION INTERACTS WITH DUMMYSERVER
 * 
 */

public class DummyDatabaseService {

	private String server_uri;
	private final String split = "@@split@@";
	private final String end = "@@end@@";

	public DummyDatabaseService() {
		this("ec2-79-125-64-3.eu-west-1.compute.amazonaws.com");
	}

	public DummyDatabaseService(String server_uri) {
		this.server_uri = server_uri;
	}

	// new order: key, category, date, user, score, title, message
	public void sendTopic(long l, String category, String date, String username, int score, String title, String message) {
		if (username == null)
			username = "";
		String dummyreply_in = (l + split + category + split + date + split + username + split + score + split + title + split + message);
		DummyServer.sendTopic(dummyreply_in);
	}

	public void sendReply(long key, long topic_key, String date, String username, int score, String message) {
		if (username == null)
			username = "";
		String dummyreply_in = (key + split + topic_key + split + date + split + username + split + score + split + message);
		Log.i("Sending Reply", dummyreply_in);
		DummyServer.sendReply(dummyreply_in);
	}

	// public String[] retrieveTopic(int index) {
	// if (DummyServer.getTopicsSize() > index) {
	// int size = 7;
	// String[] fields = new String[size];
	// for (int k = 0; k < size ; k++) {
	// String field = DummyServer.getTopicsData().get(index).split(split)[k];
	// if (field != null)
	// fields[k] = field;
	// else
	// fields[k] = "";
	// }
	// return fields;
	// }
	// return null;
	// }

	public String[] retrieveTopic(int index, String category) {
		if (DummyServer.getTopicsSize() > index) {
			ArrayList<String> temp = DummyServer.mySplit(DummyServer.getTopicsData().get(index), split);
			if (category.equals(temp.get(1))) {
				String[] result = new String[temp.size()];
				result = temp.toArray(result);
				return result;
			}
		}
		return null;
	}

	// public String[] retrieveReply(int index) {
	// if (DummyServer.getRepliesSize() > index) {
	// int size = 6;
	// String[] fields = new String[size];
	// for (int k = 0; k < size; k++)
	// fields[k] = DummyServer.getRepliesData().get(index).split("\\")[k];
	// return fields;
	// }
	// return null;
	// }

	public String[] retrieveReply(int index, Integer topic_key) {
		if (DummyServer.getRepliesSize() > index) {
			ArrayList<String> temp = DummyServer.mySplit(DummyServer.getRepliesData().get(index), split);
			if (Integer.toString(topic_key).equals(temp.get(1))) {
				String[] result = new String[temp.size()];
				result = temp.toArray(result);
				return result;
			}
		}
		return null;
	}

	/*
	 * ACTUAL IMPLEMENTATION EXAMPLE METHOD IDEAS: Doesn't account for related
	 * child tables. String jArray = parseJSON(retrieveJSON());
	 */

	public ArrayList<String> retrieveTopicJSON() {
		/*
		 * Example method for server: Execute a HttpTopic to php with entity php
		 * may retrieve JSON encoded results from database append to string or
		 * add to arraylist.etc, return
		 */
		return DummyServer.getTopicsData();
	}

	public ArrayList<String> retrieveReplyJSON() {
		/*
		 * Example method for server: Execute a HttpTopic to php with entity php
		 * may retrieve JSON encoded results from database append to string or
		 * add to arraylist.etc, return
		 */
		Log.i("DatabaseService", "Got data from:" + server_uri);
		return DummyServer.getRepliesData();
	}

	public String parseJSON(String JSON_input) {
		return null; // separate, return real jArray, use with non-dummy
	}

}