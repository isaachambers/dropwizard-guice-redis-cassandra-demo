package isaac.demo;

import com.hubspot.dropwizard.guicier.GuiceBundle;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import isaac.demo.config.RoomApiConfiguration;

public class RoomsApiApplication extends Application<RoomApiConfiguration> {

	public static void main(final String[] args) throws Exception {
		new RoomsApiApplication().run(args);
	}

	@Override
	public String getName() {
		return "rooms-api";
	}

	@Override
	public void initialize(final Bootstrap<RoomApiConfiguration> bootstrap) {
		GuiceBundle<RoomApiConfiguration> guiceBundle = GuiceBundle.defaultBuilder(RoomApiConfiguration.class)
				.modules(new GuiceModule()).build();
		bootstrap.addBundle(guiceBundle);

	}

	@Override
	public void run(final RoomApiConfiguration configuration, final Environment environment) {

	}

}
