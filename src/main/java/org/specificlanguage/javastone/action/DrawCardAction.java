package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.HSGame;
import org.specificlanguage.javastone.entity.Entity;

public class DrawCardAction implements GameAction{

    ActionInfo info;

    public static GameAction create(Entity caster){
        return create(caster, 1);
    }

    public static GameAction create(Entity caster, int cards){
        DrawCardAction action = new DrawCardAction();
        action.info.addArgument(ActionArg.CASTER, caster);
        if(cards > 1){
            return CompoundAction.create(caster, action, create(caster, cards - 1));
        }
        return action;
    }

    DrawCardAction(){
        info = ActionInfo.build(getClass());
    }

    @Override
    public boolean cast() {
        HSGame.processAction(this);
        //TODO: Enqueue action
        info.getCaster().getPlayerControlled().drawCard();
        return true;
    }

    @Override
    public Entity getCaster() {
        return info.getCaster();
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
