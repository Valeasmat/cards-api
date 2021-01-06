package com.everis.cards.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("Card")
public class Card {
    @ApiModelProperty(example = "1111222233334441",position = 1)
    private String cardNumber;
    @ApiModelProperty(example = "true",position = 2)
    private Boolean active;
}
