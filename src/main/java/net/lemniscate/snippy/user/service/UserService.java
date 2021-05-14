package net.lemniscate.snippy.user.service;

import net.lemniscate.snippy.user.model.UserMaster;

import java.util.List;
import java.util.Map;

public interface UserService {

    public Integer createUser(UserMaster user);

    public UserMaster findUserByUserName(String userName);

    public Map<String, String> getTokenString(Map<String, String> userData);

    public List<UserMaster> findAll();
}
