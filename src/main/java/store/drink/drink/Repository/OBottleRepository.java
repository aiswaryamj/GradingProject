package store.drink.drink.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.drink.drink.Model.Bottle;

public interface OBottleRepository extends JpaRepository<Bottle, String> {
}
