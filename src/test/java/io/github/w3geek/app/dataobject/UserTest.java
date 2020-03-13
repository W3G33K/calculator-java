package io.github.w3geek.app.dataobject;

import org.junit.Test;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {
	private static final String USER_NAME = "W3G33K";

	@Test
	public void testWhenAnyUserDoesProvidesName_thenShouldReturnTheProvidedName() {
		User user = new User(USER_NAME);
		assertThat(user.getName(), is(USER_NAME));
	}

	@Test
	public void testWhenAnyUserDoesProvidesLocale_thenShouldReturnTheProvidedLocale() {
		User user = new User();
		user.setLocale(Locale.FRANCE);
		assertThat(user.getLocale(), is(Locale.FRANCE));
	}
}
