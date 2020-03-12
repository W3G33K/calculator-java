package io.github.w3geek.app.dataobject;

import org.junit.Test;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {
	private static final String DEFAULT_USER_NAME_EN = "world";
	private static final String DEFAULT_USER_NAME_ZH = "世界";

	private static final String USER_NAME = "W3G33K";

	@Test
	public void testWhenAnyUserDoesProvidesName_shouldReturnTheProvidedName() {
		User user = new User(USER_NAME);
		assertThat(user.getName(), is(USER_NAME));
	}

	@Test
	public void testWhenEnglishUserDoesNotProvideName_shouldReturnDefaultUserName() {
		Locale.setDefault(Locale.CANADA);
		User user = new User();
		assertThat(user.getName(), is(DEFAULT_USER_NAME_EN));
	}

	@Test
	public void testWhenEnglishUserDoesProvideName_butProvidedNameIsNull_shouldReturnDefaultUserName() {
		Locale.setDefault(Locale.US);
		User user = new User(null);
		assertThat(user.getName(), is(DEFAULT_USER_NAME_EN));
	}

	@Test
	public void testWhenEnglishUserDoesProvideName_butProvidedNameIsEmpty_shouldReturnDefaultUserName() {
		Locale.setDefault(Locale.UK);
		User user = new User("");
		assertThat(user.getName(), is(DEFAULT_USER_NAME_EN));
	}

	@Test
	public void testWhenEnglishUserDoesProvideName_butProvidedNameIsBlank_shouldReturnDefaultUserName() {
		Locale.setDefault(Locale.CANADA);
		User user = new User("   ");
		assertThat(user.getName(), is(DEFAULT_USER_NAME_EN));
	}

	@Test
	public void testWhenChineseUserDoesNotProvideName_shouldReturnDefaultUserName() {
		Locale.setDefault(Locale.CHINA);
		User user = new User();
		assertThat(user.getName(), is(DEFAULT_USER_NAME_ZH));
	}

	@Test
	public void testWhenChineseUserDoesProvideName_butProvidedNameIsNull_shouldReturnDefaultUserName() {
		Locale.setDefault(Locale.PRC);
		User user = new User(null);
		assertThat(user.getName(), is(DEFAULT_USER_NAME_ZH));
	}

	@Test
	public void testWhenChineseUserDoesProvideName_butProvidedNameIsEmpty_shouldReturnDefaultUserName() {
		Locale.setDefault(Locale.TAIWAN);
		User user = new User("");
		assertThat(user.getName(), is(DEFAULT_USER_NAME_ZH));
	}

	@Test
	public void testWhenChineseUserDoesProvideName_butProvidedNameIsBlank_shouldReturnDefaultUserName() {
		Locale.setDefault(Locale.CHINA);
		User user = new User("   ");
		assertThat(user.getName(), is(DEFAULT_USER_NAME_ZH));
	}
}
