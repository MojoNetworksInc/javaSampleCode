/*
 * Name: ISecurityMode.java
 *
 * Created by jitendrag on Jan 30, 2012
 *
 * Description: Marker interface for wireless security mode.
 *
 * Copyright (C) 2003-2012 AirTight Networks, Inc. All rights reserved.
 *
 * The information and contents of this file are the
 * proprietary information of AirTight Networks and may not
 * be disclosed or used without the formal written approval of
 * AirTight Networks.
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * Marker interface for wireless security mode.
 * Security mode (OpenSecurity, WEP, WPA, WPA2, WPA2MixedMode) implementation classes implement this interface.
 * @author jitendrag
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = OpenSecurity.class, name = "open"), 
	@Type(value = WEPSecurity.class, name = "wep"),  
	@Type(value = WPA2Security.class, name = "wpa2"), 
	@Type(value = WPA2MixedSecurity.class, name = "wpa2Mixed"),
	@Type(value = OSENSecurity.class, name = "osen")})
public interface ISecurityMode {

}
