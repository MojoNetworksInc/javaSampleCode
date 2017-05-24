/*
 * Name: LocationId.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Location Id object fetched from MWM
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
	@Type(value = LocalLocationId.class, name = "locallocationid"),
	@Type(value = RemoteLocationId.class, name = "remotelocationid")
	})
@JsonIgnoreProperties(ignoreUnknown=true)
public class LocationId {
	public static final int ROOT_LOCATION_ID = 0;

}
