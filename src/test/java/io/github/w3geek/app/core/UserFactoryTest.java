package io.github.w3geek.app.core;

import io.github.w3geek.app.dataobject.User;
import org.junit.Test;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserFactoryTest {
	private static final String DEFAULT_USER_NAME_EN = "world";
	private static final String DEFAULT_USER_NAME_FR = "le monde";
	private static final String DEFAULT_USER_NAME_ZH = "世界";

	@Test
	public void testWhenLocaleDefaultsToCanada_userFactoryShouldReturnEnglishUser() {
		Locale.setDefault(Locale.CANADA);
		User user = UserFactory.create();
		assertThat(user.getName(), is(DEFAULT_USER_NAME_EN));
		assertThat(user.getLocale(), is(Locale.CANADA));
	}

	@Test
	public void testWhenLocaleDefaultsToUnitedStates_userFactoryShouldReturnEnglishUser() {
		Locale.setDefault(Locale.US);
		User user = UserFactory.create();
		assertThat(user.getName(), is(DEFAULT_USER_NAME_EN));
		assertThat(user.getLocale(), is(Locale.US));
	}

	@Test
	public void testWhenLocaleDefaultsToUnitedKingdom_userFactoryShouldReturnEnglishUser() {
		Locale.setDefault(Locale.UK);
		User user = UserFactory.create();
		assertThat(user.getName(), is(DEFAULT_USER_NAME_EN));
		assertThat(user.getLocale(), is(Locale.UK));
	}

	@Test
	public void testWhenLocaleDefaultsToChina_userFactoryShouldReturnChineseUser() {
		Locale.setDefault(Locale.CHINA);
		User user = UserFactory.create();
		assertThat(user.getName(), is(DEFAULT_USER_NAME_ZH));
		assertThat(user.getLocale(), is(Locale.CHINA));
	}

	@Test
	public void testWhenLocaleDefaultsToPeoplesRepublicOfChina_userFactoryShouldReturnChineseUser() {
		Locale.setDefault(Locale.PRC);
		User user = UserFactory.create();
		assertThat(user.getName(), is(DEFAULT_USER_NAME_ZH));
		assertThat(user.getLocale(), is(Locale.PRC));
	}

	@Test
	public void testWhenLocaleDefaultsToTaiwan_userFactoryShouldReturnChineseUser() {
		Locale.setDefault(Locale.TAIWAN);
		User user = UserFactory.create();
		assertThat(user.getName(), is(DEFAULT_USER_NAME_ZH));
		assertThat(user.getLocale(), is(Locale.TAIWAN));
	}

	@Test
	public void testWhenLocaleDefaultsToFranch_userFactoryShouldReturnFrenchUser() {
		Locale.setDefault(Locale.FRANCE);
		User user = UserFactory.create();
		assertThat(user.getName(), is(DEFAULT_USER_NAME_FR));
		assertThat(user.getLocale(), is(Locale.FRANCE));
	}

	@Test
	public void testWhenLocaleDefaultsToFrenchCanada_userFactoryShouldReturnFrenchUser() {
		Locale.setDefault(Locale.CANADA_FRENCH);
		User user = UserFactory.create();
		assertThat(user.getName(), is(DEFAULT_USER_NAME_FR));
		assertThat(user.getLocale(), is(Locale.CANADA_FRENCH));
	}
}
