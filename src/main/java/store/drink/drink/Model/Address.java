package store.drink.drink.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Slf4j

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Street name must be set")
    @NotEmpty(message = "This field cannot be empty")
    private String street;

    @NotNull(message = "Street number must be set")
    @NotEmpty(message = "This field cannot be empty")
    private String number;

    @NotNull(message = "Postal code must be set")
    @NotEmpty(message = "This field cannot be empty")
    @Size(min = '5', max='5',message = "Please enter 5 digit postal code")
    private String postalCode;

}
