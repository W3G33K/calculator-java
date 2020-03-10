package io.github.w3geek.app;

import io.github.w3geek.app.core.Greeter;

public class App {
	public static void main(String[] args) {
		String username = processUserName(args);
		Greeter greeter = new Greeter(username);
		greeter.greet();
	}

	private static String processUserName(String[] args) {
		String username = null;
		if (args.length >= 1) {
			username = args[0];
		}

		return username;
	}
}
