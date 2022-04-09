package com.techboat.firstwebservice.exceptions;

import java.time.LocalDate;

public class ErrorDetails {
	private String errormessage;
	private String url;
	private LocalDate errortime;

	public ErrorDetails() {
		this.errortime = LocalDate.now();
	}

	public ErrorDetails(String errormessage, String url) {
		this.errormessage = errormessage;
		this.url = url;
		this.errortime = LocalDate.now();
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDate getErrortime() {
		return errortime;
	}

	public void setErrortime(LocalDate errortime) {
		this.errortime = errortime;
	}

}
