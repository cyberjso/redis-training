import com.fasterxml.jackson.core.JsonProcessingException;

import exercicio3.CacheService;
import exercicio3.Pessoa;

public class Main {
    
	public static void main(String[] args) throws JsonProcessingException {
		CacheService cacheService =  new CacheService();
		
		cacheService.save("person1", new Pessoa("jack", "XXXXXX"));
		Pessoa jack  = cacheService.get("person1");
		System.out.println(jack.toString());
		
		cacheService.save("person2", new Pessoa("Rose", "XXXXXX"));
		Pessoa rose  = cacheService.get("person4");
		System.out.println(rose.toString());
		
    }
	
}
