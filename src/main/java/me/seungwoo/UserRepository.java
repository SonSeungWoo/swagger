package me.seungwoo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-03-05
 * Time: 13:35
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user where username = ?1", nativeQuery = true)
    User findbyUsername(String username);
}
