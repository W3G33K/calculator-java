package io.github.w3geek.app.dataobject;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {
	private static final String DEFAULT_USER_NAME = "world";
	private static final String USER_NAME = "W3G33K";

	@Test
	public void testWhenUserDoesNotProvideName_shouldReturnDefaultUserName() {
		User user = new User();
		assertThat(user.getName(), is(DEFAULT_USER_NAME));
	}

	@Test
	public void testWhenUserDoesProvideName_shouldReturnProvidedName() {
		User user = new User(USER_NAME);
		assertThat(user.getName(), is(USER_NAME));
	}

	@Test
	public void testWhenUserDoesProvideName_butProvidedNameIsBlank_shouldReturnDefaultUserName() {
		User user = new User("");
		assertThat(user.getName(), is(DEFAULT_USER_NAME));
	}
}
