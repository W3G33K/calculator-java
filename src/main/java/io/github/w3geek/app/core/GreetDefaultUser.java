package io.github.w3geek.app.core;

import io.github.w3geek.app.dataobject.User;

public class GreetDefaultUser implements IGreetUser {
	@Override
	public boolean when(User user) {
		return true;
	}

	@Override
	public String greet(User user) {
		return String.format("Hello, %s!", user.getName());
	}
}
