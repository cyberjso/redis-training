package exercicio2;
import java.util.Map;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

public class MoviesService {
	private String KEY = "movies";
	private StatefulRedisConnection<String, String> connection;
	private RedisClient redisClient;
	
	public MoviesService() {
		redisClient = RedisClient.create("redis://172.17.0.2/0");
		connection = redisClient.connect();
	}
	
	public void countMovies(String name) {
		long size = connection.sync().hlen(KEY);
		
		// First time accessing the data store. No movies yet saved.
		if (size == 0)
			connection.sync().hset(KEY, name, "1");
		else 
			connection.sync().hincrby(KEY, name, 1);
		
		String currentVote = connection.sync().hget(KEY, name);
		
		System.out.println("Movie: " + name + " , votes: " + currentVote);		
	}
	
	public void listAllMovies() {
		Map<String, String> movies = connection.sync().hgetall(KEY);
		
		for (String movie : movies.keySet()) {
			System.out.println("Movie: " + movie + " , votes: " + movies.get(movie));
		}
	}
	
}

