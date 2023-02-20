package sia.tacocloud;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
public class TacoOrder {

    @NotBlank(message = "Требуется указать название доставки")
    private String deliveryName;

    @NotBlank(message = "Улица обязательна")
    private String deliveryStreet;

    @NotBlank(message = "Требуется город")
    private String deliveryCity;

    @NotBlank(message = "Требуется название области")
    private String deliveryState;

    @NotBlank(message = "Требуется указать почтовый индекс")
    private String deliveryZip;

    @CreditCardNumber(message = "Не действительный номер кредитной карты")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([2-9]\\d)$", message = "Должно быть отформатировано ММ/ГГ")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Недопустимый CVV")
    private String ccCVV;
    private List<Taco> tacos = new ArrayList<>();

    /**
     * метод добавления taco в заказ
     * @param taco
     */
    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
