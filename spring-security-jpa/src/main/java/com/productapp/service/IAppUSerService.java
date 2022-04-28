package com.productapp.service;

import com.productapp.model.AppUser;

public interface IAppUSerService {

    void addUSer(AppUser appUser);

    void updateUser(AppUser appUser);

    void deleteUSer(int userId);
}
