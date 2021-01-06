package com.everis.cards;

import com.everis.cards.dto.Card;
import com.everis.cards.service.impl.CardsServiceImpl;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @InjectMocks
    private CardsServiceImpl cardsService;

    @Test
    public void getCardsTest(){
        TestObserver<Card> testObserver=cardsService.getCards("10000000").test();

        testObserver.assertValueCount(6)
                .assertNoErrors()
                .assertNever(c->!c.getCardNumber().startsWith("111122223333444"))
                .assertSubscribed();
    }
}
