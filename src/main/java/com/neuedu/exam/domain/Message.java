package com.neuedu.exam.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private String addresserName;
	private String recipientName;
	private String addresserId;
	private String recipientId;
	private String content;
	private String messagedate;
	
	public Message(String addresserName, String recipientName, String addresserId, String recipientId, String content) {
		this.addresserName = addresserName;
		this.recipientName = recipientName;
		this.addresserId = addresserId;
		this.recipientId = recipientId;
		this.content = content;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.messagedate = sdf.format(new Date());
		
	}
	
	public Message(String addresserName, String recipientName, String addresserId, String recipientId, String content, String messagedate) {
		super();
		this.addresserName = addresserName;
		this.recipientName = recipientName;
		this.addresserId = addresserId;
		this.recipientId = recipientId;
		this.content = content;
		this.messagedate = messagedate;
	}
	
	public Message() {
		super();
	}

	public String getAddresserName() {
		return addresserName;
	}

	public void setAddresserName(String addresserName) {
		this.addresserName = addresserName;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getAddresserId() {
		return addresserId;
	}

	public void setAddresserId(String addresserId) {
		this.addresserId = addresserId;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMessagedate() {
		return messagedate;
	}

	public void setMessagedate(String messagedate) {
		this.messagedate = messagedate;
	}

}
