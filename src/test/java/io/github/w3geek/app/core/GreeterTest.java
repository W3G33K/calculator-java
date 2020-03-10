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
	private static final String LINE_SPRT = System.lineSeparator();
	private static final String USER_NAME = "W3G33K";

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
	public void testWhenGreetHasBeenInvoked_withLineSeparatorInsertedSet_greetingShouldNotBeEmpty() {
		greeter.setLineSeparatorInserted(true);
		greeter.greet();

		String greeterOutputStreamData = greeterOutputStream.toString();
		assertThat(greeterOutputStreamData, containsString("Hello, world!"));
		assertThat(greeterOutputStreamData, endsWith(LINE_SPRT));
	}

	@Test
	public void testWhenGreetHasBeenInvoked_withNoUserNameSet_greetingShouldNotBeEmpty() {
		greeter.setUsername(null);
		greeter.greet();

		String greeterOutputStreamData = greeterOutputStream.toString();
		assertThat(greeterOutputStreamData, is("Hello, world!"));
	}

	@Test
	public void testWhenGreetHasBeenInvoked_withBlankUserNameSet_greetingShouldNotBeEmpty() {
		greeter.setUsername("");
		greeter.greet();

		String greeterOutputStreamData = greeterOutputStream.toString();
		assertThat(greeterOutputStreamData, is("Hello, world!"));
	}

	@Test
	public void testWhenGreetHasBeenInvoked_withUserNameSet_greetingShouldNotBeEmpty() {
		greeter.setUsername(USER_NAME);
		greeter.greet();

		String greeterOutputStreamData = greeterOutputStream.toString();
		String expectedGreeting = String.format("Hello, %s!", USER_NAME);
		assertThat(greeterOutputStreamData, is(expectedGreeting));
	}

	@Test
	public void testWhenGreetHasBeenInvoked_withLineSeparatorInsertedAndUserNameSet_greetingShouldNotBeEmpty() {
		greeter.setLineSeparatorInserted(true);
		greeter.setUsername(USER_NAME);
		greeter.greet();

		String greeterOutputStreamData = greeterOutputStream.toString();
		String expectedGreeting = String.format("Hello, %s!", USER_NAME);
		assertThat(greeterOutputStreamData, containsString(expectedGreeting));
		assertThat(greeterOutputStreamData, endsWith(LINE_SPRT));
	}
}
