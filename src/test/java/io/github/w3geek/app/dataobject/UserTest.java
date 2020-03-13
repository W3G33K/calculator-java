package io.github.w3geek.app.dataobject;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {
	private static final String USER_NAME = "W3G33K";

	@Test
	public void testWhenAnyUserDoesProvidesName_shouldReturnTheProvidedName() {
		User user = new User(USER_NAME);
		assertThat(user.getName(), is(USER_NAME));
	}
}
