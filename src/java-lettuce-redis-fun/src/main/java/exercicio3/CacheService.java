package exercicio3;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

public class CacheService {
	private RedisClient redisClient;
	private StatefulRedisConnection<String, String> connection;
	private ObjectMapper jackson  = new ObjectMapper();
	
	public CacheService() {
		redisClient = RedisClient.create("redis://172.17.0.2/0");
		connection = redisClient.connect();
	}
	
	public void save(String key,  Pessoa pessoa) throws JsonProcessingException {
		String content  = jackson.writeValueAsString(pessoa);
		
		connection.sync().set(key, content);
	}
	
	public Pessoa get(String  key) throws JsonMappingException, JsonProcessingException {
		String content = connection.sync().get(key);
		
		return jackson.readValue(content, Pessoa.class);
	}
	
}
