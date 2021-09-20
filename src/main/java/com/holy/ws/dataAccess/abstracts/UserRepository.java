package com.holy.ws.dataAccess.abstracts;

import com.holy.ws.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getByName(@NotNull(message = "Field may not be null") String name);

    User getByNameAndLastName(@NotNull(message = "Field may not be null") String name, @NotNull(message = "Field may not be null") String lastName);

    User getByUsername(@NotNull(message = "Field may not be null") String userName);


}
