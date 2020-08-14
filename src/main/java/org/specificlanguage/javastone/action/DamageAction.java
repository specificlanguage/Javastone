package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.card.CardBuilder;
import org.specificlanguage.javastone.card.CardType;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Filter;

public class DamageAction implements GameAction {

    ActionInfo info;

    public static GameAction create(Entity target, int damage, CardType cardType){
        // NO FILTERS!
        return create(target, damage, target.getPlayerControlled(), Filter.NONE, cardType);
    }

    public static GameAction create(Entity target, int damage, Entity caster, CardType cardType){
        return create(target, damage, caster, Filter.NONE, cardType);
    }

    public static GameAction create(Entity target, int damage, Filter filter, CardType cardType){
        return create(target, damage, target.getPlayerControlled(), filter, cardType);
    }

    public static GameAction create(Entity target, int damage, Entity caster, Filter filter,
                                    CardType cardType){
        DamageAction action = new DamageAction();
        action.info.addArgument(ActionArg.TARGET, target);
        action.info.addArgument(ActionArg.DAMAGE, damage);
        action.info.addArgument(ActionArg.CASTER, caster);
        action.info.addArgument(ActionArg.FILTER, filter);
        action.info.addArgument(ActionArg.CARD_TYPE, cardType);
        return action;
    }

    DamageAction(){
        this.info = ActionInfo.build(this.getClass());
    }

    @Override
    public boolean cast() {
        int damage = (int) info.get(ActionArg.DAMAGE);
        getTarget().damage(damage);
        return true;
    }

    @Override
    public Entity getCaster() {
        return info.getCaster();
    }

    @Override
    public Entity getTarget() {
        return info.getTarget();
    }
}
