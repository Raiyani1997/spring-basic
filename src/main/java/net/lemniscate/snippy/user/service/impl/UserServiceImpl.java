package net.lemniscate.snippy.user.service.impl;

import net.lemniscate.snippy.config.util.JwtUtils;
import net.lemniscate.snippy.exception.GreetingException;
import net.lemniscate.snippy.user.UserConstant;
import net.lemniscate.snippy.user.model.UserMaster;
import net.lemniscate.snippy.user.repository.UserRepository;
import net.lemniscate.snippy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Integer createUser(UserMaster user) {
        UserMaster userRetrieved = userRepository.findByUserName(user.getUserName());
        handleException(userRetrieved, user);
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        user.setState(UserMaster.State.ACTIVE);
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public UserMaster findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    private void handleException(UserMaster userRetrieved, UserMaster user) {
        if (userRetrieved != null && !userRetrieved.getId().equals(user.getId())) {
            throw new GreetingException("User with same username exists", 101);
        }
    }

    @Override
    public Map<String, String> getTokenString(Map<String, String> userData) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(userData.get(UserConstant.USER_NAME), userData.get(UserConstant.PASSWORD)));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        HashMap<String, String> token = new HashMap<>();
        token.put(UserConstant.TOKEN, jwt);
        return token;
    }

    @Override
    public List<UserMaster> findAll() {
        return userRepository.findAll();
    }
}
