package model;

import java.util.Date;

public class Users {
	private int id;
	private String sender;
	private String getter;
	private String content;
	private Date sendTime;
	private int isGet;

	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id= id;
	}

	public String getSender(){
		return this.sender;
	}
	public void setSender(String sender){
		this.sender= sender;
	}

	public String getGetter(){
		return this.getter;
	}
	public void setGetter(String getter){
		this.getter= getter;
	}

	public String getContent(){
		return this.content;
	}
	public void setContent(String content){
		this.content= content;
	}

	public Date getSendTime(){
		return this.sendTime;
	}
	public void setSendTime(Date sendTime){
		this.sendTime= sendTime;
	}

	public int getIsGet(){
		return this.isGet;
	}
	public void setIsGet(int isGet){
		this.isGet= isGet;
	}

}
