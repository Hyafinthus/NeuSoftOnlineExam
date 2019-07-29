package com.neuedu.exam.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private String addresser;
	private String recipient;
	private String content;
	private String messagedate;
	
	public Message(String addresser, String recipient, String content) {
		this.addresser = addresser;
		this.recipient = recipient;
		this.content = content;
		Date temp = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		messagedate = sdf.format(temp);
	}
	
	public Message(String addresser, String recipient, String content, String messagedate) {
		super();
		this.addresser = addresser;
		this.recipient = recipient;
		this.content = content;
		this.messagedate = messagedate;
	}

	public String getMessagedate() {
		return messagedate;
	}
	
	public void setMessagedate(String messagedate) {
		this.messagedate = messagedate;
	}
	
	public String getAddresser() {
		return addresser;
	}
	
	public void setAddresser(String addresser) {
		this.addresser = addresser;
	}
	
	public String getRecipient() {
		return recipient;
	}
	
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

}
