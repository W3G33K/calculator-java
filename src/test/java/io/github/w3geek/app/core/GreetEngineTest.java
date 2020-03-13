package io.github.w3geek.app.core;

import io.github.w3geek.app.dataobject.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintStream;
import java.util.Locale;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("ResultOfMethodCallIgnored")
public class GreetEngineTest {
	private static final String DEFAULT_USER_NAME_EN = "world";
	private static final String DEFAULT_USER_NAME_FR = "le monde";
	private static final String DEFAULT_USER_NAME_ZH = "世界";
	private static final String USER_NAME = "W3G33K";

	private PrintStream stdout;
	private PrintStream stdoutMock;

	@Mock
	private User userMock;

	@Before
	public void setUp() {
		stdout = System.out;
		stdoutMock = mock(PrintStream.class);
		System.setOut(stdoutMock);
	}

	@After
	public void tearDown() {
		System.setOut(stdout);
	}

	@Test
	public void testGreetUserWhen1() {
		when(userMock.getName()).thenReturn(DEFAULT_USER_NAME_EN);
		when(userMock.getLocale()).thenReturn(Locale.US);

		GreetEngine greetEngine = new GreetEngine();
		greetEngine.greet(userMock);

		verify(userMock, atLeastOnce()).getName();
		verify(userMock, atLeastOnce()).getLocale();
		verify(stdoutMock).println(eq("Hello, world!"));
	}

	@Test
	public void testGreetUserWhen2() {
		when(userMock.getName()).thenReturn(DEFAULT_USER_NAME_FR);
		when(userMock.getLocale()).thenReturn(Locale.CANADA_FRENCH);

		GreetEngine greetEngine = new GreetEngine();
		greetEngine.greet(userMock);

		verify(userMock, atLeastOnce()).getName();
		verify(userMock, atLeastOnce()).getLocale();
		verify(stdoutMock).println(eq("Bonjour le monde!"));
	}

	@Test
	public void testGreetUserWhen3() {
		when(userMock.getName()).thenReturn(DEFAULT_USER_NAME_ZH);
		when(userMock.getLocale()).thenReturn(Locale.CHINA);

		GreetEngine greetEngine = new GreetEngine();
		greetEngine.greet(userMock);

		verify(userMock, atLeastOnce()).getName();
		verify(userMock, atLeastOnce()).getLocale();
		verify(stdoutMock).println(eq("你好， 世界！"));
	}
}
