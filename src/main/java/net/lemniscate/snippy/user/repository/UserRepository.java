package net.lemniscate.snippy.user.repository;

import net.lemniscate.snippy.user.model.UserMaster;
import net.lemniscate.snippy.user.model.UserMaster.State;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserMaster, Integer> {

    public UserMaster findByUserName(String userName);

    public Optional<UserMaster> findByUserNameAndState(String userName, State state);
}
