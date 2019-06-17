package isaac.demo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.name.Named;

@Path("room")
public class RoomsResource {
	private final String message;

	final Logger logger = LoggerFactory.getLogger(RoomsResource.class);

	@Inject
	public RoomsResource(@Named("message") String message) {
		this.message = message;

	}

	@GET
	public String hello() {
		return message;
	}

}
