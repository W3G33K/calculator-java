package io.github.w3geek.app.core;

import io.github.w3geek.app.config.Constants;

import java.io.PrintStream;

public class Greeter {
	private boolean lineSeparatorInserted;
	private PrintStream stdout;
	private String user = Constants.DEFAULT_USER;

	public Greeter() {
		this(System.out, true);
	}

	protected Greeter(PrintStream stdout) {
		this(stdout, false);
	}

	protected Greeter(PrintStream stdout, boolean lineSeparatorInserted) {
		this.stdout = stdout;
		setLineSeparatorInserted(lineSeparatorInserted);
	}

	public boolean isLineSeparatorInserted() {
		return lineSeparatorInserted;
	}

	public void setLineSeparatorInserted(boolean lineSeparatorInserted) {
		this.lineSeparatorInserted = lineSeparatorInserted;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void greet() {
		String format = "Hello, %s!";
		if (lineSeparatorInserted) {
			format = (format + "%n");
		}

		stdout.printf(format, user);
	}
}
