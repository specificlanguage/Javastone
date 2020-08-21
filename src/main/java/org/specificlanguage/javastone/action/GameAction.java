package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;

public interface GameAction {

    boolean cast();
    Entity getCaster();
    Entity getTarget();
    ActionInfo getInfo();

    static boolean equals(GameAction a, GameAction b){
        return checkCriteria(a, b, ActionArg.values());
    }

    static boolean checkCriteria(GameAction a, GameAction b, ActionArg... args){
        ActionInfo a_info = a.getInfo();
        ActionInfo b_info = b.getInfo();
        if(a_info == null || b_info == null){
            throw new IllegalStateException();
        }

        for(ActionArg arg : args){
            if(b_info.get(arg) != a_info.get(arg)){
                return false;
            }
        }
        return true;
    }

}
