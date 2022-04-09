package com.techboat.firstwebservice.exceptions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ValidExceptions {

	private String uri;
	private LocalDate localDate;
	private List<String> errorsList;

	public ValidExceptions() {
		this.localDate = LocalDate.now();
		this.errorsList = new ArrayList<String>();
	}

	public void addError(String error) {
		this.errorsList.add(error);
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public List<String> getErrorsList() {
		return errorsList;
	}

	public void setErrorsList(List<String> errorsList) {
		this.errorsList = errorsList;
	}

}
