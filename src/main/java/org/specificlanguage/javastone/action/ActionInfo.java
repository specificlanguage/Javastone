package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;

import java.util.EnumMap;
import java.util.Map;

public class ActionInfo {

    final Map<ActionArg, Object> arguments;

    public static ActionInfo build(Class<? extends GameAction> action){
        return new ActionInfo(action);
    }

    private ActionInfo(Class<? extends GameAction> actionClass){
        arguments = new EnumMap<ActionArg, Object>(ActionArg.class);
    }

    public ActionInfo addArgument(ActionArg arg, Object value){
        arguments.put(arg, value);
        return this; // may be dangerous
    }

    public ActionInfo addArguments(Map<ActionArg, Object> argMap){
        for(ActionArg arg : argMap.keySet()){
            addArgument(arg, argMap.get(arg));
        }
        return this;
    }

    public ActionInfo removeArgument(ActionArg arg){
        arguments.remove(arg);
        return this;
    }

    @SuppressWarnings("unchecked")
    public ActionInfo clone(){
        ActionInfo clone = new ActionInfo((Class<? extends GameAction>) arguments.get(ActionArg.CLASS));
        for(ActionArg arg : arguments.keySet()){
            clone.addArgument(arg, arguments.get(arg));
        }
        return clone;
    }

    public Object get(ActionArg arg){
        return arguments.get(arg);
    }

    public Entity getTarget(){
        return (Entity) arguments.get(ActionArg.TARGET);
    }

    public Entity getCaster(){
        return (Entity) arguments.get(ActionArg.CASTER);
    }

    public int getInt(ActionArg arg){
        return (int) arguments.get(arg);
    }

}
