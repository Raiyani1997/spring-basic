package net.lemniscate.snippy.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.lemniscate.snippy.user.model.UserMaster;
import net.lemniscate.snippy.user.model.UserMaster.State;
import net.lemniscate.snippy.user.repository.UserRepository;

@Service
public class SecurityDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserMaster user = userRepository.findByUserNameAndState(username, State.ACTIVE)
            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
    
}
