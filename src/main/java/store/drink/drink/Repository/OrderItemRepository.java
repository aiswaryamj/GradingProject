package store.drink.drink.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import store.drink.drink.Model.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

    @Query(value = "SELECT sum(price) FROM Orderitem",
            nativeQuery=true
    )
    String getTotalPrice();
}
