package io.github.w3geek.app.core;

import io.github.w3geek.app.dataobject.User;

public interface IGreetUser {
	boolean when(User user);
	void greet(User user);
}
