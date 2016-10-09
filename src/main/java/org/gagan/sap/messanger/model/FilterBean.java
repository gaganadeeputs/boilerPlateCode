package org.gagan.sap.messanger.model;

import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;

public class FilterBean {
	
	@MatrixParam("param") String matrixParam;
    @HeaderParam("hearderParam") String headerParam;
    @CookieParam("name") String cookie;
	public String getMatrixParam() {
		return matrixParam;
	}
	public void setMatrixParam(String matrixParam) {
		this.matrixParam = matrixParam;
	}
	public String getHeaderParam() {
		return headerParam;
	}
	public void setHeaderParam(String headerParam) {
		this.headerParam = headerParam;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

}
