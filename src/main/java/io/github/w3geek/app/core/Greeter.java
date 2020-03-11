package io.github.w3geek.app.core;

import io.github.w3geek.app.dataobject.User;

import java.io.PrintStream;

public class Greeter {
	private boolean lineSeparatorInserted;
	private PrintStream stdout;

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

	public void greet(User user) {
		String format = "Hello, %s!";
		if (lineSeparatorInserted) {
			format = (format + "%n");
		}

		stdout.printf(format, user.getName());
	}
}
