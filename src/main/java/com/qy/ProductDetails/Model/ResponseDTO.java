package com.qy.ProductDetails.Model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> {
	private Meta meta;
	private T data;

	public ResponseDTO(Meta meta, T data) {
		super();
		this.meta = meta;
		this.data = data;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseDTO [meta=" + meta + ", data=" + data + "]";
	}

}
