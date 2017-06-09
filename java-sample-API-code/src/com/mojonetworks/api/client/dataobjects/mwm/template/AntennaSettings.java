/*
 * Name: AntennaSettings.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Antenna settings
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = AntennaSettingsC60.class, name = "c60"), @Type(value = AntennaSettingsC10.class, name = "c10"),  @Type(value = AntennaSettingsC50.class, name = "c50"), @Type(value = AntennaSettingsSS200.class, name = "ss200"),@Type(value = AntennaSettingsModelAgnostic.class, name = "modelAgnostic")})
public interface AntennaSettings{

	public int getPlatformId();
}
