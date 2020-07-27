package org.specificlanguage.javastone.card;

import org.specificlanguage.javastone.action.Action;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.event.GameEvent;

public class SpellCard extends Card {

    private class SpellEvent implements GameEvent{

        SpellCard card;

        SpellEvent(SpellCard card){
            this.card = card;
        }

        @Override
        public Action getAction() {
            return card.getAction();
        }
    }

    Action action;
    //TODO initialize the action in order for it to work
    //TODO initialize caster (see above)

    public Action getAction(){
        return action;
    }

    @Override
    public boolean playCard(Entity caster) {

        action.execute();
        return true;
    }

    @Override
    public boolean isPlayable() {
        return false;
    }
}
