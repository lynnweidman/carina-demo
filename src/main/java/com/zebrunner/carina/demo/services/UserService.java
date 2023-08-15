package com.zebrunner.carina.demo.services;

import com.zebrunner.carina.demo.gui.pages.common.User;
import com.zebrunner.carina.utils.R;

public class UserService {
    public User getUser() {
        return new User(R.TESTDATA.get("email"), R.TESTDATA.get("pass"));
    }

    public User getUserWithInvalidEmail() {return new User(R.TESTDATA.get("invalid_email"), R.TESTDATA.get("pass")); }

    public User getUserWithInvalidPassword() {
        return new User(R.TESTDATA.get("email"), R.TESTDATA.get("invalid_pass"));
    }
}
