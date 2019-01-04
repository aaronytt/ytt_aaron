package com.ytt.service;

import com.ytt.model.RUser;

public interface UserService {

    RUser getUser(String username, String password);

    void updateUesr();

}
