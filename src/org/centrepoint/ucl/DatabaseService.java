package org.centrepoint.ucl;

import java.util.ArrayList;

public interface DatabaseService {
	public void sendTopic(String title, String message,
			String username, String date, String category, int key);
	public void sendReply(String message, String username,
			String date, int score, int post_key);
	public String[] retrieveTopic(int index);
	public String[] retrieveReply(int index);
	public String[] retrieveReply(int index, Integer post_key);
	public ArrayList<String> retrieveTopicJSON();
	public ArrayList<String> retrieveReplyJSON();
	public String parseJSON(String JSON_input);
	public int getTotalTopics();
	public int getTotalReplies();
}