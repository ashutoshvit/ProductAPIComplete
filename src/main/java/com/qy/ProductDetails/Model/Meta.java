package com.qy.ProductDetails.Model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Meta {

	private int status;
	private String code;
	private String description;

	public Meta(int status, String code, String description) {
		super();
		this.status = status;
		this.code = code;
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Meta [status=" + status + ", code=" + code + ", description=" + description + "]";
	}

}
