package com.holy.ws.dataAccess.abstracts;

import com.holy.ws.entities.concret.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Integer, User> {

}
