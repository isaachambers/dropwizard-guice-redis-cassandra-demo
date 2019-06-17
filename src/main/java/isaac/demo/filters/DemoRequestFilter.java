package isaac.demo.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class DemoRequestFilter implements ContainerRequestFilter {
	private static final Logger LOG = LoggerFactory.getLogger(DemoRequestFilter.class);

	@Inject
	public DemoRequestFilter() {
	}

	@Override
	public void filter(ContainerRequestContext requestContext) {
		LOG.info("DemoRequestFilter triggered!");
	}
}
