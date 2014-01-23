package org.centrepoint.ucl;

import java.util.ArrayList;

public class Topic {

	private String title;
	private String username;
	private String message;
	private String date;
	private String category;
	private Integer score;
	private Integer topic_key;

	private ArrayList<Reply> replies = new ArrayList<Reply>();
	//new order: key, category, date, user, score, title, message
	public Topic(Integer topic_key, String category, String date, String username,
			Integer score, String title, String message)
	{
		if (username == null || username.trim().equals(""))
			this.username = "Anonymous";
		else
			this.username = username;
		this.title = title;
		this.date = date;
		this.category = category;
		this.score = score;
		this.message = message;
		this.topic_key = topic_key;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String content) {
		this.category = content;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	public Integer getTopicKey() {
		return topic_key;
	}
	
	public void settopicKey(Integer topic_key) {
		this.topic_key = topic_key;
	}

	public ArrayList<Reply> getReplies() {
		return replies;
	}

	public void setReplies(ArrayList<Reply> replies) {
		this.replies = replies;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumberOfReplies() {
		return replies.size();
	}
}
