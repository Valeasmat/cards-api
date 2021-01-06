package com.everis.cards.controller;


import com.everis.cards.dto.Card;
import com.everis.cards.dto.CardsResponse;
import com.everis.cards.service.CardsService;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CardsController {

    @Autowired
    private CardsService cardsService;
    @ApiOperation(value = "Get request to retrieve client's cards",
            response = CardsResponse.class,
            produces = "application/stream+json")
    @ApiResponse(code = 200,message = "Successful operation",response = CardsResponse.class)
    @GetMapping(value = "/core/cards",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Single<CardsResponse> getCards(@RequestParam("documentNumber") String documentNumber){
        Observable<Card> cards = cardsService.getCards(documentNumber);
        CardsResponse response=new CardsResponse(new ArrayList<>());
        cards.doOnNext(c -> response.getCards().add(c)).subscribe();
        return Single.just(response);
    }
}
