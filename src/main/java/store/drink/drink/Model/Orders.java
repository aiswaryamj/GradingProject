package store.drink.drink.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Slf4j
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(value = 1,message = "Value must be greater than Zero")
    private String price;

//    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY,
//            cascade = CascadeType.MERGE)
//    private List<OrderItem> orderItems;

}