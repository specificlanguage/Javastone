package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Player;

public class BuffHeroAction implements GameAction{

    ActionInfo info;

    public static GameAction create(Entity caster, int armor, int attack){
        if (armor < 0){
            throw new IllegalArgumentException();
        }
        BuffHeroAction action = new BuffHeroAction();
        action.info.addArgument(ActionArg.CASTER, caster);
        action.info.addArgument(ActionArg.TARGET, caster.getPlayerControlled());
        action.info.addArgument(ActionArg.ARMOR, armor);
        action.info.addArgument(ActionArg.ATTACK, attack);
        return action;
    }

    public static GameAction create(Entity caster, int armor){
        return create(caster, armor, 0);
    }

    BuffHeroAction(){
        this.info = ActionInfo.build(getClass());
    }

    @Override
    public boolean cast() {
        Player target = (Player) info.get(ActionArg.TARGET);
        int armor = info.getInt(ActionArg.ARMOR);
        int attack = info.getInt(ActionArg.ATTACK);
        if(armor > 0){
            target.addArmor(armor);
        } else {
            target.addAttack(attack);
        }
        return true;
    }

    @Override
    public Entity getCaster() {
        return null;
    }

    @Override
    public Entity getTarget() {
        return info.getCaster().getPlayerControlled();
    }

    @Override
    public ActionInfo getInfo() {
        return info;
    }
}
