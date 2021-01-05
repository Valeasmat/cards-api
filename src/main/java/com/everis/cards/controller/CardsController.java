package com.everis.cards.controller;


import com.everis.cards.dao.Card;
import com.everis.cards.dao.CardsResponse;
import com.everis.cards.service.ReniecService;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CardsController {

    @Autowired
    private ReniecService reniecService;

    @GetMapping("/core/cards")
    public Single<CardsResponse> getCards(@RequestParam("documentNumber") String documentNumber){
        Observable<Card> cards = reniecService.getCards(documentNumber);
        CardsResponse response=new CardsResponse(new ArrayList<>());
        cards.doOnNext(c -> response.getCards().add(c)).subscribe();
        return Single.just(response);
    }
}
