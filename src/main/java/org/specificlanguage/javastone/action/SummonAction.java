package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.Board;
import org.specificlanguage.javastone.card.CardClass;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Minion;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.event.GameEvent;

public class SummonAction implements Action {

    private class SummonEvent implements GameEvent{
        public SummonAction action;
        public SummonEvent(SummonAction action){
            this.action = action;
        }

        @Override
        public Action getAction() {
            return action;
        }
    }

    private int maxHealth;
    private int attack;
    private int cost;
    private String name;
    private CardClass playerClass;
    private Minion minion;
    private Entity caster;

    public SummonAction(int maxHealth, int attack, int cost, String name, Entity caster){
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.cost = cost;
        this.name = name;
        this.caster = caster;
    }

    public SummonAction(int maxHealth, int attack, int cost, String name, Player player, Entity caster, CardClass cardClass){
        this(maxHealth, attack, cost, name, caster);
        this.playerClass = cardClass;
    }

    /*
    public Summon(String cardID, Player player, Entity caster){
        //look up the card so we don't have to?
    }

     */

    public SummonAction(Entity caster, Minion minion){
        this.minion = minion;
        this.caster = caster;
    }

    public GameEvent createEvent(){
        return new SummonEvent(this);
    }

    @Override
    public Entity getCaster() {
        return caster;
    }

    @Override
    public boolean execute() {
        Minion minion = null;
        Entity caster = getCaster();
        caster.getGame().processEvent(createEvent());

        if (playerClass == null)
            playerClass = CardClass.NEUTRAL;
        if (this.minion == null)
            minion = new Minion(cost, attack, maxHealth, name, caster.getPlayerControlled(), playerClass);
        else minion = this.minion;

        Board board = caster.getGame().getBoard();
        board.summonMinion(minion);
        return true;
    }
}
