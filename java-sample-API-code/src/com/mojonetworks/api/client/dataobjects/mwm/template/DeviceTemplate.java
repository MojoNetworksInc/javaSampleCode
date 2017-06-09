/*
 * Name: DeviceTemplate.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for device template details
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;
import java.util.List;


public class DeviceTemplate extends Template{  

	public static final int SYSTEM_DEFAULT_DEVICE_TEMPLATE_ID = -1;

	private SensorPassword sensorPassword = new SensorPassword();
	private List<AntennaSettings> antennaDetails;
	private DeviceTemplatePlatformToRadioSettingsMapper platformToRadioSettingsMapper = new DeviceTemplatePlatformToRadioSettingsMapper();
	private AccessRadioException accessRadioException;
	private ChannelInfo channelInfo;

	public DeviceTemplate() {
		super(TemplateType.DEVICE_TEMPLATE);
	}

	public List<AntennaSettings> getAntennaDetails() {
		return antennaDetails;
	}

	public void setAntennaDetails(List<AntennaSettings> sensorDetails) {
		this.antennaDetails = sensorDetails;
	}

	public ChannelInfo getChannelInfo() {
		return channelInfo;
	}

	public void setChannelInfo(ChannelInfo channelInfo) {
		this.channelInfo = channelInfo;
	}

	public SensorPassword getSensorPassword() {
		return sensorPassword;
	}

	public void setSensorPassword(SensorPassword sensorPassword) {
		this.sensorPassword = sensorPassword;
	}

	public DeviceTemplatePlatformToRadioSettingsMapper getPlatformToRadioSettingsMapper() {
		return platformToRadioSettingsMapper;
	}

	public void setPlatformToRadioSettingsMapper(DeviceTemplatePlatformToRadioSettingsMapper platformToRadioSettingsMapper) {
		this.platformToRadioSettingsMapper = platformToRadioSettingsMapper;
	}

	public AccessRadioException getAccessRadioException() {
		return accessRadioException;
	}

	public void setAccessRadioException(AccessRadioException accessRadioException) {
		this.accessRadioException = accessRadioException;
	}

	@Override
	public String toString() {
		return super.toString()+ " SLDeviceTemplate [platformToRadioSettingsMapper="
				+ platformToRadioSettingsMapper + "]";
	}
}
