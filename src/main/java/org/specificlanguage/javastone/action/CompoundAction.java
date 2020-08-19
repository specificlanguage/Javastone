package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;

import java.util.Arrays;
import java.util.List;

public class CompoundAction implements GameAction{

    ActionInfo info;

    public static GameAction create(Entity target, Entity caster, GameAction... actions){
        CompoundAction parentAction = new CompoundAction();
        for(GameAction check : actions){
            if(check.getCaster() != caster){
                throw new IllegalArgumentException("Casters are not the same");
            }
        }

        List<GameAction> childActions = Arrays.asList(actions);
        parentAction.info.addArgument(ActionArg.TARGET, target);
        parentAction.info.addArgument(ActionArg.CASTER, caster);
        parentAction.info.addArgument(ActionArg.NESTED_ACTIONS, childActions);
        return parentAction;
    }
    
    CompoundAction(){
        info = ActionInfo.build(getClass());
    }

    @Override
    public boolean cast() {
        return false;
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
