package io.github.w3geek.app.core;

import io.github.w3geek.app.config.Constants;
import io.github.w3geek.app.dataobject.User;

import java.util.Locale;

public class UserFactory {
	public static User create() {
		Locale defaultUserLocale = Locale.getDefault();
		String defaultUserName = getDefaultUserName(defaultUserLocale);
		return new User(defaultUserName, defaultUserLocale);
	}

	private static String getDefaultUserName(Locale locale) {
		String userLocale = locale.toString();
		String defaultUserName;
		switch (userLocale) {
			case Constants.ZH_CN:
			case Constants.ZH_TW:
				defaultUserName = Constants.DEFAULT_USER_NAME_ZH;
				break;
			case Constants.FR_CA:
			case Constants.FR_FR:
				defaultUserName = Constants.DEFAULT_USER_NAME_FR;
				break;
			case Constants.EN_CA:
			case Constants.EN_US:
			case Constants.EN_UK:
			default:
				defaultUserName = Constants.DEFAULT_USER_NAME_EN;
		}

		return defaultUserName;
	}
}
