package store.drink.drink.Repository;

import org.springframework.data.repository.CrudRepository;
import store.drink.drink.Model.User;

public interface UserRepository  extends CrudRepository<User,Long> {

//    @Query(value = "SELECT u FROM User u WHERE u.username = ?1")
//    User findByUsername(String username);

}
