package isaac.demo;

import com.google.inject.Binder;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.hubspot.dropwizard.guicier.DropwizardAwareModule;

import isaac.demo.config.RedisConfiguration;
import isaac.demo.config.RoomApiConfiguration;
import isaac.demo.filters.DemoRequestFilter;
import isaac.demo.filters.DemoResponseFilter;
import isaac.demo.health.ExampleHealthCheck;
import isaac.demo.health.ExampleManaged;
import isaac.demo.health.ExampleServerLifecycleListener;
import isaac.demo.health.ExampleTask;
import isaac.demo.resources.RedisResource;
import isaac.demo.resources.RoomsResource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class GuiceModule extends DropwizardAwareModule<RoomApiConfiguration> {

	@Override
	public void configure(Binder binder) {
//		Resources
		binder.bind(RoomsResource.class);
		binder.bind(RedisResource.class);

//		Filters
		binder.bind(DemoRequestFilter.class);
		binder.bind(DemoResponseFilter.class);
//		Others
		binder.bind(ExampleManaged.class);
		binder.bind(ExampleTask.class);
		binder.bind(ExampleHealthCheck.class);
		binder.bind(ExampleServerLifecycleListener.class);
	}

	@Provides
	@Named("message")
	public String provideMessage(RoomApiConfiguration roomApiConfiguration) {
		return roomApiConfiguration.getMessage();
	}

	@Provides
	@Named("appName")
	public String provideAppName(RoomApiConfiguration roomApiConfiguration) {
		return roomApiConfiguration.getAppName();
	}

	@Provides
	@Named("redisPool")
	public JedisPool provideJedisPool(RoomApiConfiguration roomApiConfiguration) {
		RedisConfiguration redisConfig = roomApiConfiguration.getRedis();
		return new JedisPool(new JedisPoolConfig(), redisConfig.getHostname(), redisConfig.getPort());
	}
}
