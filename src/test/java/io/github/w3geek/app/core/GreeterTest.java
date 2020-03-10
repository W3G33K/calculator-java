package io.github.w3geek.app.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;

public class GreeterTest {
	private ByteArrayOutputStream greeterOutputStream;
	private Greeter greeter;

	@Before
	public void setUp() {
		greeterOutputStream = new ByteArrayOutputStream();
		greeter = new Greeter(new PrintStream(greeterOutputStream));
	}

	@After
	public void tearDown() throws Exception {
		try {
			greeterOutputStream.close();
		} finally {
			greeterOutputStream = null;
			greeter = null;
		}
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
		assertThat(greeterOutputStreamData, containsString("Hello, world!"));
	}
}
