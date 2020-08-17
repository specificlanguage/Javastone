package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.card.CardType;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Filter;

import java.util.List;
import java.util.Map;

public class HealAction implements GameAction {

    ActionInfo info;

    public static GameAction create(Entity target, int health){
        return create(target, health, target.getPlayerControlled(), Filter.NO_FILTER);
    }

    public static GameAction create(Entity target, int health, Entity caster, List<Filter> filter){
        HealAction action = new HealAction();
        action.info.addArgument(ActionArg.TARGET, target)
                .addArgument(ActionArg.HEAL, health)
                .addArgument(ActionArg.CASTER, caster)
                .addArgument(ActionArg.FILTER, filter);
        return action;
    }

    HealAction(){
        this.info = ActionInfo.build(this.getClass());
    }

    @Override
    public boolean cast() {
        if(!Filter.filterCheck(this)){
            return false;
        }

        int health = (int) info.get(ActionArg.HEAL);

        //TODO: reverse Heal/Damage
        /*
        if(healsDoDamage){
            DamageAction.create(info).cast;
            return true;
         */

        getTarget().heal(health);
        return true;
    }

    @Override
    public Entity getCaster() {
        return null;
    }

    @Override
    public Entity getTarget() {
        return null;
    }

    @Override
    public ActionInfo getInfo() {
        return info;
    }
}
