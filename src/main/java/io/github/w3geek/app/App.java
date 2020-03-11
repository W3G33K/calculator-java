package io.github.w3geek.app;

import io.github.w3geek.app.core.GreetUser;
import io.github.w3geek.app.dataobject.User;

public class App {
	public static void main(String[] args) {
		User user = new User();
		user.setName(processUserName(args));
		GreetUser greetUser = new GreetUser();
		if (greetUser.when(user) == Boolean.TRUE) {
			greetUser.greet(user);
		}
	}

	private static String processUserName(String[] args) {
		String username = null;
		if (args.length >= 1) {
			username = args[0];
		}

		return username;
	}
}
