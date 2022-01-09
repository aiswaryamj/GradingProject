package store.drink.drink.Repository;

import org.springframework.data.repository.CrudRepository;
import store.drink.drink.Model.Orders;

public interface OrderRepository extends CrudRepository<Orders, Long> {
}
