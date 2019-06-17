package isaac.demo.health;

import com.codahale.metrics.health.HealthCheck;
import com.google.inject.name.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ExampleHealthCheck extends HealthCheck {
	private static final Logger LOG = LoggerFactory.getLogger(ExampleHealthCheck.class);

	private static String appName;

	@Inject
	public ExampleHealthCheck(@Named("appName") String appName) {
		this.appName = appName;
	}

	@Override
	protected Result check() {
		LOG.info("ExampleHealthCheck triggered!");
		LOG.info("App Name is: {}", appName);
		if ("Rooms-api-demo".equalsIgnoreCase(appName)) {
			return Result.healthy();
		}
		return Result.unhealthy("DropwizardRedis Service is down");
	}
}
