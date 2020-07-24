package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.card.Card;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.event.GameEvent;

public class DrawCardAction implements Action {

    private class DrawCardEvent implements GameEvent{

        DrawCardAction action;

        DrawCardEvent(DrawCardAction action){
            this.action = action;
        }

        @Override
        public Action getAction() {
            return action;
        }
    }

    private class CardDrawnEvent implements GameEvent{
        DrawCardAction action;
        Card card;

        CardDrawnEvent(DrawCardAction action, Card card){
            this.action = action;
            this.card = card;
        }

        @Override
        public Action getAction() {
            return action;
        }
    }

    Player drawer;
    int numCards;

    public DrawCardAction(Player player){
        drawer = player;
        numCards = 1;
    }

    public DrawCardAction(Player player, int numCards){
        this(player);
        this.numCards = numCards;
    }

    @Override
    public boolean execute() {
        if(drawer.getDeck().size() == 0){
            drawer.incFatigue();
            new DamageAction(drawer, drawer, drawer.getFatigue()).execute();
            return true;
        }

        drawer.getGame().processEvent(createEvent());
        for(int i = 0; i < numCards; i++){
            Card card = drawer.drawCard();
            drawer.getGame().processEvent(new CardDrawnEvent(this, card));
        }
        return true;
    }

    @Override
    public GameEvent createEvent() {
        return new DrawCardEvent(this);
    }

    @Override
    public Entity getCaster() {
        return drawer;
    }
}
