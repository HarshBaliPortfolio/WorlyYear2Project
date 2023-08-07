package com.example.worly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.worly.repository.UserRepository;
import com.example.worly.service.UserService;
import com.example.worly.user.User;
import com.example.worly.user.UserRole;




@Component
	public class AddAdmin implements CommandLineRunner{	
		@Autowired
		UserService userService;
		@Autowired
		UserRepository userRepos;

		@Override
		public void run(String... args) throws Exception {
			
			// set to false to stop adding the admin again and again 
			boolean addAdmin = true;
			
			if (addAdmin) {

				//add here to become admin
				User adminUser = new User("name","surname","jane@gmail.com","password","postcode", UserRole.ADMIN);
				userRepos.save(adminUser);
				userService.createAdminForUser(adminUser);
				userService.enableUser(adminUser.getEmail());
			}
		}
	}


