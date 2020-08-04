package org.specificlanguage.javastone.card;

import org.specificlanguage.javastone.entity.Minion;

public class MinionCard extends Card {

    Minion minion;

    @Override
    boolean playCard() {
        return false;
    }

    @Override
    boolean isPlayable() {
        if(playerControlled.getUsableMana() < this.mana){
            return false;
        } else if (playerControlled.getGame().getBoard().getNumOpenSlots(playerControlled) <= 0) {
            return false;
        }
        return true;
    }
}
