package org.centrepoint.ucl;

public class Reply {

	private String username;
	private String date;
	private String message;
	private int score;
	private int topic_key;
	private int key;

	public Reply(int key, int topic_key, String date, String username,
			Integer score, String message)
	{
		if (username == null || username.equals(""))
			this.username = "Anonymous";
		else
			this.username = username;
		this.date = date;
		this.message = message;
		this.score = score;
		this.topic_key = key;
		this.key = key;
	}


	@Override
	public String toString() {
		return "Reply [username=" + username + ", date=" + date + ", content="
				+ message + ", score=" + score + "]";
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return message;
	}

	public void setContent(String content) {
		this.message = content;
	}

	public int getScore() {
		return score;
	}
	
	public void settopicKey(int key) {
		this.topic_key = key;
	}

	public int gettopicKey() {
		return topic_key;
	}
	
	public int getKey() {
		return key;
	}

	public void incrementScore() {
		score++;
	}
	
	public void decrementScore() {
		score--;
	}
	
}
