package com.smoothstack.utopiaairlines;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smoothstack.Users.services.UserService;
import com.smoothstack.Users.models.User;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.*;
import org.junit.*;

@SpringBootTest
class UtopiaAirlinesApplicationTests {

	private String userTableName = "test_user_table";

	@Before
	void setUp() {
		UserService.createUserTable(userTableName);
	}


	@Test
	void addUserTest(){
		Random rd = new Random();
		//generate a number between 1-100
		int randomId = rd.nextInt(100 - 1 + 1) + 1;
		try {
			UserService.addUser(randomId ,"testUserName123", "test.email@smoothstack.com", "password");
		} catch (Exception e) {
			fail();
		}
	}


	@Test
	void findUserById(){
		User testUser = new User(0, "Thatfakeuser", "thatfakeuser@smoothstack.com", "randompassword");
		try {
            User user = UserService.getUserById(0);
            if(user == null) {
                fail();
            }
            else {
                assertEquals(user, testUser);
            }
        }
        catch(Exception _ex) {
            fail();
        }
	}


	@Test
	void deleteUserByIdTest(){

		try {
           UserService.deleteUserById(0, userTableName);
		   UserService.getUserById(0);
            User testUser = UserService.getUserById(0);
            if(testUser != null) {
                fail();
            }
            else {
                assertEquals(true, true);
            }
        }
        catch(Exception _ex) {
            fail();
        }
	}

	@Test
	void updateUserTest(){
		try {
			UserService.addUser(0 ,"testUserName123", "test.email@smoothstack.com", "password");
			UserService.updateUser(0, "updatedUserName234", "fake.updatedUserEmail@gmail.com");
			User testUser = UserService.getUserById(0);
			if(testUser == null){
				fail();
			}else{
				assertEquals(UserService.getUserById(0), testUser);
			}
		} catch (Exception e) {
			fail();
		}
	}
	*/
}
