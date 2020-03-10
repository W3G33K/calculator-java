package io.github.w3geek.app.core;

import io.github.w3geek.app.config.Constants;

import java.io.PrintStream;

public class Greeter {
	private boolean lineSeparatorInserted;
	private PrintStream stdout;
	private String username = Constants.DEFAULT_USER_NAME;

	public Greeter() {
		this(System.out, true);
	}

	protected Greeter(PrintStream stdout) {
		this(stdout, false);
	}

	private Greeter(PrintStream stdout, boolean lineSeparatorInserted) {
		this.stdout = stdout;
		setLineSeparatorInserted(lineSeparatorInserted);
	}

	protected boolean isLineSeparatorInserted() {
		return lineSeparatorInserted;
	}

	protected void setLineSeparatorInserted(boolean lineSeparatorInserted) {
		this.lineSeparatorInserted = lineSeparatorInserted;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (username != null && !username.isEmpty()) {
			this.username = username;
		}
	}

	public void greet() {
		String format = "Hello, %s!";
		if (lineSeparatorInserted) {
			format = (format + "%n");
		}

		stdout.printf(format, username);
	}
}
