package com.holy.ws.dataAccess.abstracts.user;

import com.holy.ws.entities.concretes.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface UserCrudRepository extends CrudRepository<User, Long> {




}
