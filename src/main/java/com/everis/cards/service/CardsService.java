package com.everis.cards.service;

import com.everis.cards.dto.Card;
import io.reactivex.Observable;


public interface CardsService {
    Observable<Card> getCards(String documentNumber);
}
