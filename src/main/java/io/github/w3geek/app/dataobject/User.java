package io.github.w3geek.app.dataobject;

import io.github.w3geek.app.config.Constants;

public class User {
	private String name = Constants.DEFAULT_USER_NAME;

	public User() {
		this(null);
	}

	public User(String name) {
		setName(name);
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
