package org.specificlanguage.javastone.action;

import org.jetbrains.annotations.NotNull;
import org.specificlanguage.javastone.card.CardBuilder;
import org.specificlanguage.javastone.card.CardType;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Filter;

import java.util.List;

public class DamageAction implements GameAction {

    ActionInfo info;

    public static GameAction create(Entity target, int damage, CardType cardType){
        // NO FILTERS!
        return create(target, damage, target.getPlayerControlled(), Filter.NO_FILTER, cardType);
    }

    public static GameAction create(Entity target, int damage, Entity caster, CardType cardType){
        return create(target, damage, caster, Filter.NO_FILTER, cardType);
    }

    public static GameAction create(Entity target, int damage, List<Filter> filter, CardType cardType){
        return create(target, damage, target.getPlayerControlled(), filter, cardType);
    }

    public static GameAction create(Entity target, int damage, Entity caster, List<Filter> filter,
                                    CardType cardType){
        DamageAction action = new DamageAction();
        action.info.addArgument(ActionArg.TARGET, target);
        action.info.addArgument(ActionArg.DAMAGE, damage);
        action.info.addArgument(ActionArg.CASTER, caster);
        action.info.addArgument(ActionArg.FILTER, filter);
        action.info.addArgument(ActionArg.CARD_TYPE, cardType);
        return action;
    }

    public static GameAction create(ActionInfo info){
        DamageAction action = new DamageAction();
        action.info = info;
        return action;
    }

    DamageAction(){
        this.info = ActionInfo.build(this.getClass());
    }

    @Override
    public boolean cast() {

        int damage = (int) info.get(ActionArg.DAMAGE);
        if (!Filter.filterCheck(this)){
            return false;
        }

        if(info.get(ActionArg.CARD_TYPE) == CardType.valueOf("SPELL"))
            damage += getCaster().getPlayerControlled().getSpellDamage();
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

    @Override
    public ActionInfo getInfo() {
        return info;
    }
}
