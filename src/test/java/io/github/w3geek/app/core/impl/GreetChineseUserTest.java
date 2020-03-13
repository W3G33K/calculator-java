package io.github.w3geek.app.core.impl;

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
public class GreetChineseUserTest {
	private static final String DEFAULT_USER_NAME_ZH = "世界";
	private static final String USER_NAME = "W3G33K";

	private IGreetUser greetUser;

	@Mock
	private User userMock;

	@Before
	public void setUp() {
		greetUser = new GreetChineseUser();
	}

	@After
	public void tearDown() {
		greetUser = null;
	}

	@Test
	public void testWhenGreetHasBeenInvoked_greetingShouldNotBeEmpty() {
		when(userMock.getName()).thenReturn(DEFAULT_USER_NAME_ZH);
		assertThat(greetUser.greet(userMock), is("你好， 世界！"));
		verify(userMock, atLeastOnce()).getName();
	}

	@Test
	public void testWhenGreetHasBeenInvoked_withUsersNameSet_greetingShouldNotBeEmpty() {
		when(userMock.getName()).thenReturn(USER_NAME);
		assertThat(greetUser.greet(userMock), is(String.format("你好， %s！", USER_NAME)));
		verify(userMock, atLeastOnce()).getName();
	}

	@Test
	public void testWhenUsersLocaleSetToUnitedStates_caseShouldReturnFalse() {
		when(userMock.getLocale()).thenReturn(Locale.US);
		assertThat(greetUser.when(userMock), is(false));
		verify(userMock, atLeastOnce()).getLocale();
	}

	@Test
	public void testWhenUsersLocaleSetToChina_caseShouldReturnTrue() {
		when(userMock.getLocale()).thenReturn(Locale.CHINA);
		assertThat(greetUser.when(userMock), is(true));
		verify(userMock, atLeastOnce()).getLocale();
	}

	@Test
	public void testWhenUsersLocaleSetToTaiwan_caseShouldReturnTrue() {
		when(userMock.getLocale()).thenReturn(Locale.TAIWAN);
		assertThat(greetUser.when(userMock), is(true));
		verify(userMock, atLeastOnce()).getLocale();
	}

	@Test
	public void testWhenUsersLocaleIsUnset_edgeCaseShouldReturnFalse() {
		when(userMock.getLocale()).thenReturn(null);
		assertThat(greetUser.when(userMock), is(false));
		verify(userMock, atLeastOnce()).getLocale();
	}
}
