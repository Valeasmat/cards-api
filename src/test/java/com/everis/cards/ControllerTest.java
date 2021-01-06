package com.everis.cards;

import com.everis.cards.controller.CardsController;
import com.everis.cards.dto.Card;
import com.everis.cards.dto.CardsResponse;
import com.everis.cards.service.impl.CardsServiceImpl;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
;import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @InjectMocks
    private CardsController controller;

    @Mock
    private CardsServiceImpl cardsService;

    @Test
    public void getCardsTest(){
        Observable<Card> list= Observable.fromIterable(Arrays.asList(
                new Card("1111222233334441",true),
                new Card("1111222233334442",false)
        ));

        Mockito.when(cardsService.getCards(Mockito.anyString())).thenReturn(list);

        TestObserver<CardsResponse> test=controller.getCards("10000000").test();

        test.assertSubscribed()
                .assertNoErrors()
                .assertValueCount(1)
                .assertNever(c->c.getCards().size()!=2)
                .assertNever(c->c.getCards()
                        .stream()
                        .noneMatch(card->card.
                                getCardNumber()
                                .startsWith("111122223333444")));
    }

}
