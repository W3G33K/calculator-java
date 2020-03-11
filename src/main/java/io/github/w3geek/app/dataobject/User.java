package io.github.w3geek.app.dataobject;

import io.github.w3geek.app.config.Constants;

import java.util.Locale;

public class User {
	private Locale locale;
	private String name = Constants.DEFAULT_USER_NAME;

	public User() {
		this(null, Locale.getDefault());
	}

	public User(String name) {
		this(name, Locale.getDefault());
	}

	public User(String name, Locale locale) {
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
		if (name == null || name.isEmpty()) {
			return;
		}

		this.name = name;
	}
}
