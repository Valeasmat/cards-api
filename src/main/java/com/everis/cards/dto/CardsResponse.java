package com.everis.cards.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CardsResponse {

    private List<Card> cards;
}
