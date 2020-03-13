package io.github.w3geek.app.core;

import io.github.w3geek.app.core.impl.GreetChineseUser;
import io.github.w3geek.app.core.impl.GreetEnglishUser;
import io.github.w3geek.app.core.impl.GreetFrenchUser;
import io.github.w3geek.app.dataobject.User;

import java.util.ArrayList;
import java.util.List;

public class GreetEngine {
	private List<IGreetUser> rules;

	public GreetEngine() {
		registerRules();
	}

	public void greet(User user) {
		for (IGreetUser rule : rules) {
			if (rule.when(user) != Boolean.FALSE) {
				String greeting = rule.greet(user);
				System.out.println(greeting);
				break;
			}
		}
	}

	private void registerRules() {
		rules = new ArrayList<>();
		rules.add(new GreetChineseUser());
		rules.add(new GreetEnglishUser());
		rules.add(new GreetFrenchUser()); // This kind of rule registration could easily snowball out of control.
	}
}
