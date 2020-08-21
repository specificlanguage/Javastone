package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;

public class EndOfTurnAction implements GameAction{

    ActionInfo info;

    public static GameAction create(Entity player){
        EndOfTurnAction action = new EndOfTurnAction();
        action.info = ActionInfo.build(action.getClass());
        action.info.addArgument(ActionArg.CASTER, player);
        action.info.addArgument(ActionArg.TARGET, player);
        return action;
    }

    @Override
    public boolean cast() {
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
