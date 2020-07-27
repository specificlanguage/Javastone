package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.event.GameEvent;

public class ArmorAction implements Action {

    private class ArmorEvent implements GameEvent{

        ArmorAction action;
        ArmorEvent(ArmorAction action){ this.action = action; }

        @Override
        public Action getAction() {
            return null;
        }
    }

    Player player;
    int armor;

    public ArmorAction(int armor){
        this.armor = armor;
    }

    public ArmorAction(Player player, int armor){
        this.player = player;
        this.armor = armor;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public boolean execute() {
        player.getGame().processEvent(createEvent());
        player.setArmor(player.getArmor() + armor);
        return true;
    }

    @Override
    public GameEvent createEvent() {
        return new ArmorEvent(this);
    }

    @Override
    public Entity getCaster() {
        return player;
    }

}
