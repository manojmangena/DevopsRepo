package org.acelerit.config.dbconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

public abstract class DatabaseConfiguration {

	private String name;
	private String url;
	private String username;
	private String password;
	
	
	@Profile("prod ")
	@Bean
	public DatabaseConfiguration getProdDatabaseConfiguration() {
		System.out.println(".....prod...");
	   	return new AppConfigurationProd();
	}

	@Profile("dev")
	@Bean
	public DatabaseConfiguration getDevDatabaseConfiguration() {
		System.out.println(".....dev...");
		return new AppConfigurationDev();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
