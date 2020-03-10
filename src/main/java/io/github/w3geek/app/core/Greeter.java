package io.github.w3geek.app.core;

import java.io.PrintStream;

public class Greeter {
	private PrintStream stdout;

	public Greeter() {
		this.stdout = System.out;
	}

	protected Greeter(PrintStream stdout) {
		this.stdout = stdout;
	}

	public void greet() {
		stdout.println("Hello, world!");
	}
}
