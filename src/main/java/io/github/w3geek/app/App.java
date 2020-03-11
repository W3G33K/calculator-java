package io.github.w3geek.app;

import io.github.w3geek.app.core.Greeter;
import io.github.w3geek.app.dataobject.User;

public class App {
	public static void main(String[] args) {
		User user = new User();
		user.setName(processUserName(args));
		Greeter greeter = new Greeter();
		greeter.greet(user);
	}

	private static String processUserName(String[] args) {
		String username = null;
		if (args.length >= 1) {
			username = args[0];
		}

		return username;
	}
}
