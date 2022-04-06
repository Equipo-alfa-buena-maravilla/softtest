package com.softtek.softtest;

import java.util.List;

public interface UserRepository {

    /**
     * @returns A list containing all users.
     * */
    List<? extends User> findAll();
    /**
    * @returns A random user from the current datasource.
    * */
    User getRandomUser();
}
