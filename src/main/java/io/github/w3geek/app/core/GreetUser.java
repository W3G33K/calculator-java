package io.github.w3geek.app.core;

import io.github.w3geek.app.dataobject.User;

import java.io.PrintStream;
import java.util.Locale;

public class GreetUser implements IGreetUser {
	private boolean lineSeparatorInserted;
	private PrintStream stdout;

	public GreetUser() {
		this(System.out, true);
	}

	protected GreetUser(PrintStream stdout) {
		this(stdout, false);
	}

	private GreetUser(PrintStream stdout, boolean lineSeparatorInserted) {
		this.stdout = stdout;
		setLineSeparatorInserted(lineSeparatorInserted);
	}

	protected boolean isLineSeparatorInserted() {
		return lineSeparatorInserted;
	}

	protected void setLineSeparatorInserted(boolean lineSeparatorInserted) {
		this.lineSeparatorInserted = lineSeparatorInserted;
	}

	@Override
	public boolean when(User user) {
		return Locale.US.equals(user.getLocale());
	}

	@Override
	public void greet(User user) {
		String format = "Hello, %s!";
		if (lineSeparatorInserted) {
			format = (format + "%n");
		}

		stdout.printf(format, user.getName());
	}
}
