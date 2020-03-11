package io.github.w3geek.app.core;

import io.github.w3geek.app.config.Constants;
import io.github.w3geek.app.dataobject.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("ResultOfMethodCallIgnored")
public class GreetUserTest {
	private static final String LINE_SPRT = System.lineSeparator();
	private static final String USER_NAME = "W3G33K";

	private ByteArrayOutputStream greetUserOutputStream;
	private PrintStream greetUserPrintStream;
	private GreetUser greetUser;

	@Mock
	private User mockUser;

	@Before
	public void setUp() {
		greetUserOutputStream = new ByteArrayOutputStream();
		greetUserPrintStream = new PrintStream(greetUserOutputStream);
		greetUser = new GreetUser(greetUserPrintStream);
	}

	@After
	public void tearDown() {
		greetUserPrintStream.close();
		greetUserPrintStream = null;
		greetUserOutputStream = null;
		greetUser = null;
	}

	@Test
	public void testWhenGreetHasNotBeenInvoked_greetingShouldBeEmpty() {
		String greeterOutputStreamData = greetUserOutputStream.toString();
		assertThat(greeterOutputStreamData, isEmptyString());
	}

	@Test
	public void testWhenGreetHasBeenInvoked_greetingShouldNotBeEmpty() {
		when(mockUser.getName()).thenReturn(Constants.DEFAULT_USER_NAME);
		greetUser.greet(mockUser);

		String greeterOutputStreamData = greetUserOutputStream.toString();
		assertThat(greeterOutputStreamData, is("Hello, world!"));
		verify(mockUser, atLeastOnce()).getName();
	}

	@Test
	public void testWhenGreetHasBeenInvoked_withLineSeparatorInsertedSet_greetingShouldNotBeEmpty() {
		when(mockUser.getName()).thenReturn(Constants.DEFAULT_USER_NAME);
		greetUser.setLineSeparatorInserted(true);
		greetUser.greet(mockUser);

		String greeterOutputStreamData = greetUserOutputStream.toString();
		assertThat(greeterOutputStreamData, containsString("Hello, world!"));
		assertThat(greeterOutputStreamData, endsWith(LINE_SPRT));
		verify(mockUser, atLeastOnce()).getName();
	}

	@Test
	public void testWhenGreetHasBeenInvoked_withNoUserNameSet_greetingShouldNotBeEmpty() {
		when(mockUser.getName()).thenReturn(Constants.DEFAULT_USER_NAME);
		greetUser.greet(mockUser);

		String greeterOutputStreamData = greetUserOutputStream.toString();
		assertThat(greeterOutputStreamData, is("Hello, world!"));
		verify(mockUser, atLeastOnce()).getName();
	}

	@Test
	public void testWhenGreetHasBeenInvoked_withBlankUserNameSet_greetingShouldNotBeEmpty() {
		when(mockUser.getName()).thenReturn(Constants.DEFAULT_USER_NAME);
		greetUser.greet(mockUser);

		String greeterOutputStreamData = greetUserOutputStream.toString();
		assertThat(greeterOutputStreamData, is("Hello, world!"));
		verify(mockUser, atLeastOnce()).getName();
	}

	@Test
	public void testWhenGreetHasBeenInvoked_withUserNameSet_greetingShouldNotBeEmpty() {
		when(mockUser.getName()).thenReturn(USER_NAME);
		greetUser.greet(mockUser);

		String greeterOutputStreamData = greetUserOutputStream.toString();
		String expectedGreeting = String.format("Hello, %s!", USER_NAME);
		assertThat(greeterOutputStreamData, is(expectedGreeting));
		verify(mockUser, atLeastOnce()).getName();
	}

	@Test
	public void testWhenGreetHasBeenInvoked_withLineSeparatorInsertedAndUserNameSet_greetingShouldNotBeEmpty() {
		when(mockUser.getName()).thenReturn(USER_NAME);
		greetUser.setLineSeparatorInserted(true);
		greetUser.greet(mockUser);

		String greeterOutputStreamData = greetUserOutputStream.toString();
		String expectedGreeting = String.format("Hello, %s!", USER_NAME);
		assertThat(greeterOutputStreamData, containsString(expectedGreeting));
		assertThat(greeterOutputStreamData, endsWith(LINE_SPRT));
		verify(mockUser, atLeastOnce()).getName();
	}

	public void testWhenGreetHasBeenInvoked_withDefaultLocaleSetToUnitedStates_greetingShouldNotBeEmpty() {
		when(mockUser.getLocale()).thenReturn(Locale.US);
		assertThat(greetUser.when(mockUser), is(true));
		verify(mockUser, atLeastOnce()).getLocale();
	}
}
