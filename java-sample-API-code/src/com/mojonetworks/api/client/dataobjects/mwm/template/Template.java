/*
 * Name: Template.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Template details 
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.mojonetworks.api.client.dataobjects.mwm.LocationId;
import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@Type(value = DeviceTemplate.class, name = "devicetemplate"), 
	@Type(value = SSIDProfile.class, name = "ssidprofile")})
public abstract class Template extends MWMBaseObject{
	protected int templateId;
	protected String templateName;
	protected LocationId createdAtLocationId;
	private String description = "";
	private TemplateType templateType;
	private int mncTemplateId;
	
	public Template(TemplateType templateType) {
		this.templateType = templateType;
	}
	public TemplateType getTemplateType() {
		return templateType;
	}
	public void setTemplateType(TemplateType templateType) {
		this.templateType = templateType;
	}
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocationId getCreatedAtLocationId() {
		return createdAtLocationId;
	}

	public void setCreatedAtLocationId(LocationId createdAtLocationId) {
		this.createdAtLocationId = createdAtLocationId;
	}
	
	public int getMncTemplateId() {
		return mncTemplateId;
	}

	public boolean isMNCTemplate(){
		return mncTemplateId==0?false:true;
	}
	
	public void setMncTemplateId(int mncTemplateId) {
		this.mncTemplateId = mncTemplateId;
	}
	
	@Override
	public String toString() {
		return "SLTemplate [templateId=" + templateId + ", templateName="
				+ templateName + ", createdAtLocation=" + createdAtLocationId
				+ ", description=" + description + "]";
	}
}
