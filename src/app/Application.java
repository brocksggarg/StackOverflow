package app;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import enums.UserRole;
import exceptions.InvalidQuestionException;
import exceptions.UserAccountException;
import models.Question;
import models.User;
import repository.DataStore;
import service.ModeratorActivityService;
import service.RegisteredUsersActivityService;
import service.UserActivityService;
import service.impl.ModeratorActivityServiceImpl;
import service.impl.RegisteredUsersActivityServiceImpl;

public class Application {
	
	
	public static void main(String ar[]) throws UserAccountException, NumberFormatException, IOException, InvalidQuestionException {
		DataStore dataStore=new DataStore();
		RegisteredUsersActivityService registeredUsersActivityService=new RegisteredUsersActivityServiceImpl(dataStore);
		ModeratorActivityService moderatorActivityService=new ModeratorActivityServiceImpl(dataStore);
		User user=new User("shubham", "password", UserRole.USER.getValue());
		dataStore.addUser(user);
		Set<String> tags=new HashSet<>();
		tags.add("java");
		registeredUsersActivityService.postQuestion("Java", "What is java",tags, user.getId());
		UserActivityService userActivityService=new RegisteredUsersActivityServiceImpl(dataStore);
		Question ques=userActivityService.searchQuestion("java");
		System.out.println(ques.getDescription());
		
		User user2=new User("Karan", "password", UserRole.USER.getValue());
		dataStore.addUser(user2);
		ques=registeredUsersActivityService.addAnswer("Java is an OOP language", ques.getId(), user2.getId());
		for(String userid:ques.getAnswers().keySet()) {
			System.out.println(ques.getAnswers().get(userid).getAnswerText());
		}
		
		
		
		
		/*BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		int choice;
		while(true) {
			displayOptions();
			choice=Integer.parseInt(bufferedReader.readLine());
			switch(choice){
			case 1:
				
				
			}
		}
		*/
		
		
	}

}
