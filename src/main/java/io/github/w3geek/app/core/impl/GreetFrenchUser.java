package io.github.w3geek.app.core.impl;

import io.github.w3geek.app.core.IGreetUser;
import io.github.w3geek.app.dataobject.User;

import java.util.Locale;

public class GreetFrenchUser implements IGreetUser {
	@Override
	public boolean when(User user) {
		Locale userLocale = user.getLocale();
		return Locale.CANADA_FRENCH.equals(userLocale) || Locale.FRANCE.equals(userLocale);
	}

	@Override
	public String greet(User user) {
		return String.format("Bonjour %s!", user.getName());
	}
}
