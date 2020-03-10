package io.github.w3geek.app.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;

public class GreeterTest {
	private ByteArrayOutputStream greeterOutputStream;
	private PrintStream greeterPrintStream;
	private Greeter greeter;

	@Before
	public void setUp() {
		greeterOutputStream = new ByteArrayOutputStream();
		greeterPrintStream = new PrintStream(greeterOutputStream);
		greeter = new Greeter(greeterPrintStream);
	}

	@After
	public void tearDown() {
		greeterPrintStream.close();
		greeterPrintStream = null;
		greeterOutputStream = null;
		greeter = null;
	}

	@Test
	public void testWhenGreetHasNotBeenInvoked_greetingShouldBeEmpty() {
		String greeterOutputStreamData = greeterOutputStream.toString();
		assertThat(greeterOutputStreamData, isEmptyString());
	}

	@Test
	public void testWhenGreetHasBeenInvoked_greetingShouldNotBeEmpty() {
		greeter.greet();

		String greeterOutputStreamData = greeterOutputStream.toString();
		assertThat(greeterOutputStreamData, is("Hello, world!"));
	}

	@Test
	public void testWhenGreetHasBeenInvoked_withLineSeparatorInsertedIsTrue_greetingShouldNotBeEmpty() {
		greeter.setLineSeparatorInserted(true);
		greeter.greet();

		String greeterOutputStreamData = greeterOutputStream.toString();
		assertThat(greeterOutputStreamData, containsString("Hello, world!"));
		assertThat(greeterOutputStreamData, endsWith(System.lineSeparator()));
	}
}
