package io.github.w3geek.app.core.impl;

import io.github.w3geek.app.config.Constants;
import io.github.w3geek.app.core.IGreetUser;
import io.github.w3geek.app.dataobject.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("ResultOfMethodCallIgnored")
public class GreetEnglishUserTest {
	private static final String USER_NAME = "W3G33K";

	private IGreetUser greetUser;

	@Mock
	private User userMock;

	@Before
	public void setUp() {
		greetUser = new GreetEnglishUser();
	}

	@After
	public void tearDown() {
		greetUser = null;
	}

	@Test
	public void testWhenGreetHasBeenInvoked_greetingShouldNotBeEmpty() {
		when(userMock.getName()).thenReturn(Constants.DEFAULT_USER_NAME);
		assertThat(greetUser.greet(userMock), is("Hello, world!"));
		verify(userMock, atLeastOnce()).getName();
	}

	@Test
	public void testWhenGreetHasBeenInvoked_withUsersNameSet_greetingShouldNotBeEmpty() {
		when(userMock.getName()).thenReturn(USER_NAME);
		assertThat(greetUser.greet(userMock), is(String.format("Hello, %s!", USER_NAME)));
		verify(userMock, atLeastOnce()).getName();
	}

	@Test
	public void testWhenUsersLocaleSetToUnitedStates_caseShouldReturnTrue() {
		when(userMock.getLocale()).thenReturn(Locale.US);
		assertThat(greetUser.when(userMock), is(true));
		verify(userMock, atLeastOnce()).getLocale();
	}

	@Test
	public void testWhenUsersLocaleSetToCanada_caseShouldReturnTrue() {
		when(userMock.getLocale()).thenReturn(Locale.CANADA);
		assertThat(greetUser.when(userMock), is(true));
		verify(userMock, atLeastOnce()).getLocale();
	}

	@Test
	public void testWhenUsersLocaleSetToChina_caseShouldReturnFalse() {
		when(userMock.getLocale()).thenReturn(Locale.CHINA);
		assertThat(greetUser.when(userMock), is(false));
		verify(userMock, atLeastOnce()).getLocale();
	}

	@Test
	public void testWhenUsersLocaleIsUnset_edgeCaseShouldReturnFalse() {
		when(userMock.getLocale()).thenReturn(null);
		assertThat(greetUser.when(userMock), is(false));
		verify(userMock, atLeastOnce()).getLocale();
	}
}
