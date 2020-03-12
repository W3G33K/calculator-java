package io.github.w3geek.app.core.impl;

import io.github.w3geek.app.core.IGreetUser;
import io.github.w3geek.app.dataobject.User;

import java.util.Locale;

public class GreetChineseUser implements IGreetUser {
	@Override
	public boolean when(User user) {
		Locale userLocale = user.getLocale();
		return Locale.CHINA.equals(userLocale) ||
			Locale.PRC.equals(userLocale) || Locale.TAIWAN.equals(userLocale);
	}

	@Override
	public String greet(User user) {
		return String.format("你好， %s！", user.getName());
	}
}
