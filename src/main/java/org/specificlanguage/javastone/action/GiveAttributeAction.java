package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.attributes.Attribute;

import java.util.List;

public class GiveAttributeAction implements GameAction {

    ActionInfo info;

    public static GameAction create(Entity target, Entity caster, List<Attribute> attributeToGive){
        GiveAttributeAction action = new GiveAttributeAction();
        action.info.addArgument(ActionArg.TARGET, target);
        action.info.addArgument(ActionArg.CASTER, caster);
        action.info.addArgument(ActionArg.ATTRIBUTES, attributeToGive);
        return action;
    }

    GiveAttributeAction(){
        info = ActionInfo.build(getClass());
    }

    @Override
    public boolean cast() {
        Entity target = (Entity) info.get(ActionArg.TARGET);
        List attributeList = (List) info.get(ActionArg.ATTRIBUTES); // fingers crossed
        target.addAttributes(attributeList);
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
