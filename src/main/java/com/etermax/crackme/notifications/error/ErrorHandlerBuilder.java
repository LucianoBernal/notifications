package com.etermax.crackme.notifications.error;

import com.etermax.users.system.exceptionhandler.ErrorLink;

public class ErrorHandlerBuilder {

	private ErrorHandler errorHandler;

	public ErrorHandlerBuilder() {
		errorHandler = new ErrorHandler();
	}

	public ErrorHandlerBuilder addLink(ErrorLink errorLink) {
		errorHandler.addLink(errorLink);
		return this;
	}

	public ErrorHandler build() {
		return errorHandler;
	}

}
