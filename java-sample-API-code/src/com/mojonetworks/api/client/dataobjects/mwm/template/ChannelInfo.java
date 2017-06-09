/*
 * Name: ChannelInfo.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Channel information
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import java.util.ArrayList;
import java.util.List;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;

public class ChannelInfo extends MWMBaseObject{

	private Country country;
	private boolean scanIllegalChannels;
	private List<Channel> channelsScanA = new ArrayList<Channel>();
	private List<Channel> channelsDefendA = new ArrayList<Channel>();
	private List<Channel> channelsScanB = new ArrayList<Channel>();
	private List<Channel> channelsDefendB = new ArrayList<Channel>();
	private List<Channel> channelScanATurbo = new ArrayList<Channel>();
	private List<Channel> channelScanBTurbo = new ArrayList<Channel>();
	
	public ChannelInfo() {
	}
	
	private List<Channel> copy(List<Channel> channels) {
		List<Channel> listCopy = new ArrayList<Channel>();
		for (Channel channel : channels) {
			listCopy.add(new Channel(channel));
		}
		return listCopy;
	}

	public ChannelInfo(ChannelInfo chanInfo){
		this.country = chanInfo.getCountry();
		this.channelScanATurbo = copy(chanInfo.getChannelScanATurbo());
		this.channelScanBTurbo = copy(chanInfo.getChannelScanBTurbo());
		this.channelsDefendA = copy(chanInfo.getChannelsDefendA());
		this.channelsDefendB = copy(chanInfo.getChannelsDefendB());
		this.channelsScanA = copy(chanInfo.getChannelsScanA());
		this.channelsScanB = copy(chanInfo.getChannelsScanB());
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Channel> getChannelsScanA() {
		return channelsScanA;
	}

	public void setChannelsScanA(List<Channel> channelsScanA) {
		this.channelsScanA = channelsScanA;
	}

	public void addChannelScanA(Channel channel){
		channelsScanA.add(channel);
	}
	
	public List<Channel> getChannelsDefendA() {
		return channelsDefendA;
	}

	public void setChannelsDefendA(List<Channel> channelsDefendA) {
		this.channelsDefendA = channelsDefendA;
	}

	public void addChannelDefendA(Channel channel){
		channelsDefendA.add(channel);
	}
	
	public List<Channel> getChannelsScanB() {
		return channelsScanB;
	}

	public void setChannelsScanB(List<Channel> channelsScanB) {
		this.channelsScanB = channelsScanB;
	}

	public void addChannelScanB(Channel channel){
		channelsScanB.add(channel);
	}
	
	public List<Channel> getChannelsDefendB() {
		return channelsDefendB;
	}

	public void setChannelsDefendB(List<Channel> channelsDefendB) {
		this.channelsDefendB = channelsDefendB;
	}

	public void addChannelDefendB(Channel channel){
		channelsDefendB.add(channel);
	}

	public List<Channel> getChannelScanATurbo() {
		return channelScanATurbo;
	}

	public void setChannelScanATurbo(List<Channel> channelScanATurbo) {
		this.channelScanATurbo = channelScanATurbo;
	}

	public void addChannelScanTurboA(Channel channel){
		channelScanATurbo.add(channel);
	}
	
	public List<Channel> getChannelScanBTurbo() {
		return channelScanBTurbo;
	}

	public void setChannelScanBTurbo(List<Channel> channelScanBTurbo) {
		this.channelScanBTurbo = channelScanBTurbo;
	}
	
	public void addChannelScanTurboB(Channel channel){
		channelScanBTurbo.add(channel);
	}

	public boolean isScanIllegalChannels() {
		return scanIllegalChannels;
	}

	public void setScanIllegalChannels(boolean scanIllegalChannels) {
		this.scanIllegalChannels = scanIllegalChannels;
	}
}
