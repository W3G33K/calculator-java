package io.github.w3geek.app;

import io.github.w3geek.app.core.GreetDefaultUser;
import io.github.w3geek.app.core.IGreetUser;
import io.github.w3geek.app.dataobject.User;

public class App {
	public static void main(String[] args) {
		User user = new User();
		user.setName(processUserName(args));
		IGreetUser greetUser = new GreetDefaultUser();
		if (greetUser.when(user) == Boolean.TRUE) {
			System.out.println(greetUser.greet(user));
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
