package isaac.demo.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class DemoResponseFilter implements ContainerResponseFilter {
	private static final Logger LOG = LoggerFactory.getLogger(DemoResponseFilter.class);

	@Inject
	public DemoResponseFilter() {
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
		LOG.info("DemoResponseFilter triggered!");
	}
}
