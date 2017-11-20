package com.ytt.service;

import com.ytt.model.RUser;

public interface UserService {

    RUser selectUserById(Integer id);

    void updateUesr();

}
