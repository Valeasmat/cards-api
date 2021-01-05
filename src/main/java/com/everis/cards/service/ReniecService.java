package com.everis.cards.service;

import com.everis.cards.dao.Card;
import io.reactivex.Observable;


public interface ReniecService {
    Observable<Card> getCards(String documentNumber);
}
