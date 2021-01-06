package com.everis.cards.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Card {

    private String cardNumber;
    private Boolean active;
}
