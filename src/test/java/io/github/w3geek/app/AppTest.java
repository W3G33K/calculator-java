package io.github.w3geek.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppTest {
	private ByteArrayOutputStream testOutputStream = new ByteArrayOutputStream();
	private PrintStream originalOutputStream = System.out;

	@Before
	public void setUp() {
		System.setOut(new PrintStream(testOutputStream));
	}

	@After
	public void tearDown() {
		System.setOut(originalOutputStream);
	}

	@Test
	public void testHello() {
		String[] args = new String[0];
		App.main(args);

		String testOutputStreamData = testOutputStream.toString();
		assertThat(testOutputStreamData, containsString("Hello, world!"));
	}
}
