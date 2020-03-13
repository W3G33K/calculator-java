package io.github.w3geek.app;

import io.github.w3geek.app.core.GreetEngine;
import io.github.w3geek.app.core.UserFactory;
import io.github.w3geek.app.dataobject.User;

public class App {
	public static void main(String[] args) {
		GreetEngine greetEngine = new GreetEngine();

		User user = UserFactory.create();
		user.setName(processUserName(args));
		greetEngine.greet(user);
	}

	private static String processUserName(String[] args) {
		String username = null;
		if (args.length >= 1) {
			username = args[0];
		}

		return username;
	}
}
