package com.softtek.softtest;

import java.util.List;

public interface UserRepository {
    List<? extends User> findAll();
}
