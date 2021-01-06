package com.everis.cards.service.impl;

import com.everis.cards.dto.Card;
import com.everis.cards.service.CardsService;
import io.reactivex.Observable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardsServiceImpl implements CardsService {
    @Override
    public Observable<Card> getCards(String documentNumber) {
        String cardPrefix="111122223333444";

        List<Card> cards=new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            cards.add(new Card(cardPrefix+i,true));
        }
        for (int i = 4; i < 7; i++) {
            cards.add(new Card(cardPrefix+i,false));
        }
        return Observable.fromIterable(cards);
    }
}
