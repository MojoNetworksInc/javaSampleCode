/*
 * Name: Channel.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Channel
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;
import com.mojonetworks.api.client.dataobjects.mwm.Radio.Protocol;

public class Channel extends MWMBaseObject{

	private boolean scan = false;
	private boolean defend = false;
	private int number;
	private int id;
	private String name;
	private Protocol protocol;
	private boolean turboMode;
	private boolean scanLegal = false;
	private boolean defendLegal = false;
	private boolean dFSChannel = false;

	public Channel() {
	}

	public Channel(Channel channel){
		this.scan = channel.isScan();
		this.scanLegal = channel.isScanLegal();
		this.defend = channel.isDefend();
		this.defendLegal = channel.isDefendLegal();
		this.number = channel.getNumber();
		this.id = channel.getId();
		this.name = channel.getName();
		this.protocol = channel.getProtocol();
		this.turboMode = channel.isTurboMode();
		this.dFSChannel = channel.isdFSChannel();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Protocol getProtocol() {
		return protocol;
	}

	public boolean isdFSChannel() {
		return dFSChannel;
	}
	
	public void setDFSChannel(Boolean dFSChannel) {
		this.dFSChannel = dFSChannel.booleanValue();
	}
	
	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}

	public boolean isScan() {
		return scan;
	}

	public void setScan(Boolean scan) {
		this.scan = scan.booleanValue();
	}

	public boolean isDefend() {
		return defend;
	}

	public void setDefend(Boolean defend) {
		this.defend = defend.booleanValue();
	}

	public boolean isTurboMode() {
		return turboMode;
	}

	public void setTurboMode(Boolean turboMode) {
		this.turboMode = turboMode.booleanValue();
	}

	public boolean isScanLegal() {
		return scanLegal;
	}

	public void setScanLegal(Boolean scanLegal) {
		this.scanLegal = scanLegal.booleanValue();
	}

	public boolean isDefendLegal() {
		return defendLegal;
	}

	public void setDefendLegal(Boolean defendLegal) {
		this.defendLegal = defendLegal.booleanValue();
	}

	@Override
	public String toString() {
		return "Channel [scan=" + scan + ", defend=" + defend + ", number="
				+ number + ", id=" + id + ", name=" + name + ", protocol="
				+ protocol + ", turboMode=" + turboMode + ", scanLegal="
				+ scanLegal + ", defendLegal=" + defendLegal + "]";
	}

}
