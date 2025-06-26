/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.testing.aopsimple.runner;

import com.jackson.testing.aopsimple.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * AppRunner Class.
 * <p>
 * </p>
 *
 * @author
 */

@Component
class AppRunner implements CommandLineRunner {

    private final UserService userService;

    public AppRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        userService.createUser("Alice");
        userService.deleteUser(42);
        try {
            userService.getUserById(1);
            userService.getUserById(0); // triggers exception
        } catch (Exception ignored) {}
    }
}
