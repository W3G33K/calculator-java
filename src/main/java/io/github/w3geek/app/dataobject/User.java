package io.github.w3geek.app.dataobject;

import io.github.w3geek.app.config.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public class User {
	private Locale locale;
	private String name;

	public User() {
		this(null, Locale.getDefault());
	}

	public User(String name) {
		this(name, Locale.getDefault());
	}

	protected User(String name, Locale locale) {
		setDefaultName(locale);
		setName(name);
		setLocale(locale);
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (StringUtils.isNotBlank(name)) {
			this.name = name;
		}
	}

	private void setDefaultName(Locale locale) {
		String userLocale = locale.toString();
		switch (userLocale) {
			case Constants.ZH_CN:
			case Constants.ZH_TW:
				setName(Constants.DEFAULT_USER_NAME_ZH);
				break;
			case Constants.EN_CA:
			case Constants.EN_US:
			case Constants.EN_UK:
			default:
				setName(Constants.DEFAULT_USER_NAME_EN);
		}
	}
}
