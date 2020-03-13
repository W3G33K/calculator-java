package io.github.w3geek.app.dataobject;

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
		if (StringUtils.isNotBlank(name)) {
			this.name = name;
		}
	}
}
