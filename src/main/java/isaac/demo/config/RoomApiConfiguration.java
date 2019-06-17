package isaac.demo.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class RoomApiConfiguration extends Configuration {

	@NotEmpty
	private String message;

	@JsonProperty
	public String appName;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@Valid
	@NotNull
	private RedisConfiguration redis = new RedisConfiguration();

	public RedisConfiguration getRedis() {
		return redis;
	}

	public void setRedis(RedisConfiguration redis) {
		this.redis = redis;
	}

	public String getAppName() {
		return appName;
	}

}
