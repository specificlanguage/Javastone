package org.specificlanguage.javastone.entity;

import org.specificlanguage.javastone.action.ActionArg;
import org.specificlanguage.javastone.action.GameAction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Filter {

    MINIONS, ENEMY_MINIONS, FRIENDLY_MINIONS, HERO, NONE, SET_TARGET, ENEMY, FRIENDLY, UNDAMAGED;

    public static boolean filterCheck(Entity target, Entity caster, Filter filter){
        switch(filter){
            case NONE:
                return true;
            case HERO:
                if(target instanceof Player)
                    return true;
            case MINIONS:
                if(target instanceof Minion)
                    return true;
            case ENEMY:
                if(target.getPlayerControlled() == caster.getPlayerControlled().getOpponent())
                    return true;
            case FRIENDLY:
                if(target.getPlayerControlled() == caster.getPlayerControlled())
                    return true;
            case SET_TARGET:
                return true;
            case ENEMY_MINIONS:
                if(target.getPlayerControlled() == caster.getPlayerControlled().getOpponent() && target instanceof Minion)
                    return true;
            case FRIENDLY_MINIONS:
                if(target.getPlayerControlled() == caster.getPlayerControlled() && target instanceof Minion)
                    return true;
            case UNDAMAGED:
                if(target.health == target.maxHealth)
                    return true;
            default:
                return false;
        }
    }

    //TODO: GameAction needs to get info
    public static boolean filterCheck(GameAction action){
        List<Filter> filters = (List<Filter>) action.getInfo().get(ActionArg.FILTER);
        Entity target = (Entity) action.getInfo().get(ActionArg.TARGET);
        Entity caster = (Entity) action.getInfo().get(ActionArg.CASTER);
        for(Filter filter : filters){
            if(!filterCheck(target, caster, filter)){
                return false;
            }
        }
        return true;
    }

    public final static List<Filter> NO_FILTER = new ArrayList<>(Collections.singleton(NONE));
}
