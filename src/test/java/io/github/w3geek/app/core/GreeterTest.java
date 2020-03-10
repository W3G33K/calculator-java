package io.github.w3geek.app.core;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;

@SuppressWarnings("unused")
public class GreeterTest {
	@Test
	public void testWhenGreetHasNotBeenInvoked_greetingShouldBeEmpty() {
		ByteArrayOutputStream greeterOutputStream = new ByteArrayOutputStream();
		Greeter greeter = new Greeter(new PrintStream(greeterOutputStream));

		String greeterOutputStreamData = greeterOutputStream.toString();
		assertThat(greeterOutputStreamData, isEmptyString());
	}

	@Test
	public void testWhenGreetHasBeenInvoked_greetingShouldNotBeEmpty() {
		ByteArrayOutputStream testOutputStream = new ByteArrayOutputStream();
		Greeter greeter = new Greeter(new PrintStream(testOutputStream));
		greeter.greet();

		String testOutputStreamData = testOutputStream.toString();
		assertThat(testOutputStreamData, containsString("Hello, world!"));
	}
}
