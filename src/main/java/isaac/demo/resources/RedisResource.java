package isaac.demo.resources;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Path("redisdemo")
public class RedisResource {

	private final Jedis jedis;
	final Logger logger = LoggerFactory.getLogger(RedisResource.class);

	@Inject
	public RedisResource(@Named("redisPool") JedisPool redisPool) {
		this.jedis = redisPool.getResource();
	}

	@GET
	public String basicInfo() {
		return jedis.info();
	}

}
