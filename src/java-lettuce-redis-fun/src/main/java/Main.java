import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import exercicio4.UserProfileService;

public class Main {
    
	public static void main(String[] args) throws JsonProcessingException {
//		CacheService cacheService =  new CacheService();
//		
//		cacheService.save("person1", new Pessoa("jack", "XXXXXX"));
//		Pessoa jack  = cacheService.get("person1");
//		System.out.println(jack.toString());
//		
//		cacheService.save("person2", new Pessoa("Rose", "XXXXXX"));
//		Pessoa rose  = cacheService.get("person4");
//		System.out.println(rose.toString());
		
		
		UserProfileService userProfileService = new UserProfileService();
		Map<String, String> larissaProfile = new HashMap<String, String>();
		larissaProfile.put("name", "larissa");
		larissaProfile.put("twitterHandle", "@larissa");
		larissaProfile.put("address", "rua xxx");
		larissaProfile.put("dateOfBirth", "01-Jan-1990");
		
		userProfileService.save("larissa@ilegra.com", larissaProfile);
		userProfileService.update("jj@ilegra.com", "address", "rua yyyyyyy");
    }
	
}
