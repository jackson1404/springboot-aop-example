/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.testing.aopsimple.service;

import org.springframework.stereotype.Service;

/**
 * UserService Class.
 * <p>
 * </p>
 *
 * @author
 */

@Service
public class UserService {

    public String getUserById(int id) {
        if (id == 0) throw new IllegalArgumentException("Invalid ID");
        return "User#" + id;
    }

    public void createUser(String name) {
        System.out.println("Creating user: " + name);
    }

    public void deleteUser(int id) {
        System.out.println("Deleting user with ID: " + id);
    }
}