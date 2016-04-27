package com.etermax.crackme.notifications.error;

import java.util.List;

import com.etermax.apps.error.ApplicationException;
import com.etermax.users.system.exceptionhandler.AccountClosedExceptionLink;
import com.etermax.users.system.exceptionhandler.AlreadyLinkedFacebookAccountExceptionLink;
import com.etermax.users.system.exceptionhandler.AlreadyUsedIdentifierExceptionLink;
import com.etermax.users.system.exceptionhandler.DefaultExceptionLink;
import com.etermax.users.system.exceptionhandler.EmailNoLinkedToFacebookExceptionLink;
import com.etermax.users.system.exceptionhandler.ErrorLink;
import com.etermax.users.system.exceptionhandler.FacebookAccessTokenExpiredExceptionLink;
import com.etermax.users.system.exceptionhandler.FacebookAccessTokenInvalidExceptionLink;
import com.etermax.users.system.exceptionhandler.FacebookConnectionExceptionLink;
import com.etermax.users.system.exceptionhandler.IncompleteUserDataExceptionLink;
import com.etermax.users.system.exceptionhandler.InvalidEmailCharactersExceptionLink;
import com.etermax.users.system.exceptionhandler.InvalidEmailDomainExceptionLink;
import com.etermax.users.system.exceptionhandler.InvalidEmailExceptionLink;
import com.etermax.users.system.exceptionhandler.InvalidFacebookIdExceptionLink;
import com.etermax.users.system.exceptionhandler.InvalidPasswordExceptionLink;
import com.etermax.users.system.exceptionhandler.InvalidProfilePictureExceptionLink;
import com.etermax.users.system.exceptionhandler.InvalidUserSearchExceptionLink;
import com.etermax.users.system.exceptionhandler.InvalidUsernameExceptionLink;
import com.etermax.users.system.exceptionhandler.NoEmailReturnedByFacebookExceptionLink;
import com.etermax.users.system.exceptionhandler.NotCorrectFormatCountryCodeLink;
import com.etermax.users.system.exceptionhandler.UserHasForgotPassExceptionLink;
import com.etermax.users.system.exceptionhandler.UserHasNoPassExceptionLink;
import com.etermax.users.system.exceptionhandler.UserHasPassExceptionLink;
import com.etermax.users.system.exceptionhandler.UserNotFoundExceptionLink;
import com.google.common.collect.Lists;

public class ErrorHandler {

	private List<ErrorLink> errorLinks;

	public ErrorHandler() {
		errorLinks = Lists.newArrayList();
		// Facebook Login
		errorLinks.add(new FacebookAccessTokenExpiredExceptionLink());
		errorLinks.add(new FacebookAccessTokenInvalidExceptionLink());
		errorLinks.add(new NoEmailReturnedByFacebookExceptionLink());
		errorLinks.add(new EmailNoLinkedToFacebookExceptionLink());
		errorLinks.add(new AlreadyLinkedFacebookAccountExceptionLink());
		errorLinks.add(new FacebookConnectionExceptionLink());
		errorLinks.add(new NoEmailReturnedByFacebookExceptionLink());
		// Others
		errorLinks.add(new InvalidFacebookIdExceptionLink());
		errorLinks.add(new AlreadyUsedIdentifierExceptionLink());
		errorLinks.add(new UserNotFoundExceptionLink());
		errorLinks.add(new InvalidEmailExceptionLink());
		errorLinks.add(new IncompleteUserDataExceptionLink());
		errorLinks.add(new AccountClosedExceptionLink());
		errorLinks.add(new InvalidPasswordExceptionLink());
		errorLinks.add(new UserHasPassExceptionLink());
		errorLinks.add(new UserHasForgotPassExceptionLink());
		errorLinks.add(new UserHasNoPassExceptionLink());
		errorLinks.add(new InvalidUserSearchExceptionLink());
		errorLinks.add(new InvalidEmailDomainExceptionLink());
		errorLinks.add(new InvalidEmailCharactersExceptionLink());
		errorLinks.add(new InvalidProfilePictureExceptionLink());
		errorLinks.add(new InvalidUsernameExceptionLink());
		errorLinks.add(new NotCorrectFormatCountryCodeLink());
	}

	public ApplicationException handleException(Exception e) {
		// for (ErrorLink errorLink : errorLinks) {
		// if (errorLink.canHandle(e)) {
		// return errorLink.doHandle(e);
		// }
		// }
		return new DefaultExceptionLink().doHandle(e);
	}

	public void addLink(ErrorLink link) {
		errorLinks.add(link);
	}
}
