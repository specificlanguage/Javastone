package org.specificlanguage.javastone.event;

import org.specificlanguage.javastone.card.Card;

public interface PlayCardEvent extends GameEvent{

    Card getCard();

}
