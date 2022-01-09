package store.drink.drink.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Slf4j
public class Crate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Name must be set")
    @NotEmpty(message = "This field cannot be empty")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "Name can have only letters and digits")
    private String name;

    @Pattern(regexp = "(http(s?):).*\\\\*.(?:jpg|gif|png)",message = "Must be a valid URL to a picture")
    private String cratePic;

    @Min(value = 1, message = "Value must be greater than Zero")
    private int noOfBottles;

    @Min(value = 1,message = "Value must be greater than Zero")
    private int price;

    @Min(value = 0,message = "Value must be greater than or equal to Zero")
    private int inStock;

}
