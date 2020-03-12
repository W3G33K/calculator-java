package io.github.w3geek.app.core.impl;

import io.github.w3geek.app.core.IGreetUser;
import io.github.w3geek.app.dataobject.User;

import java.util.Locale;

public class GreetEnglishUser implements IGreetUser {
	@Override
	public boolean when(User user) {
		Locale userLocale = user.getLocale();
		return Locale.CANADA.equals(userLocale) ||
			Locale.UK.equals(userLocale) || Locale.US.equals(userLocale);
	}

	@Override
	public String greet(User user) {
		return String.format("Hello, %s!", user.getName());
	}
}
