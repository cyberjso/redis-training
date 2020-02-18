package exercicio4;

import java.util.Map;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

public class UserProfileService {
	private String KEY_PREFIX = "profile_";
	private RedisClient redisClient;
	private StatefulRedisConnection<String, String> connection;
	
	public UserProfileService() {
		redisClient = RedisClient.create("redis://172.17.0.2/0");
		connection = redisClient.connect();
	}
	
	public void save(String email, Map<String, String> profileData) {
		connection.sync().hmset(KEY_PREFIX + email, profileData);
		
		System.out.println("Profile " + email + " was successfuly created");
	}
	
	public void update(String email, String attributeName, String newValue) {
		long keySize = connection.sync().hlen(KEY_PREFIX + email);
		
		System.out.println("key size: "  + keySize);
		if (keySize == 0)
			System.out.println("Profile " + email + " does not yet exists. IT needs to be saved first");
		else  {
			connection.sync().hset(KEY_PREFIX + email, attributeName, newValue);
			
			System.out.println("Profile " + email + " was successfuly updated");
		}
		
	}
	
}
