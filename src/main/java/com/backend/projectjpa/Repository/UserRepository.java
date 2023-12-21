package com.backend.projectjpa.Repository;

import com.backend.projectjpa.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//       @Query("SELECT u FROM User u WHERE u.nid = :nid")
      User findByNid(String nid);
//      List<User>findByLast_nameAndFirst_name(@Param("first_name") String firstname , @Param("last_name")String last_name);
      @Query("SELECT u FROM User u WHERE u.first_name =:first_name and u.last_name =:last_name")
      List<User> findByFirst_nameAndLast_name(@Param("first_name") String firstname , @Param("last_name")String last_name);
      @Query("SELECT u FROM User u WHERE u.user_name =:user_name")
      User findByUsername(@Param("user_name")String username);


}