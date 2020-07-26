package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.enchantment.Enchantment;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Minion;
import org.specificlanguage.javastone.event.GameEvent;
import org.specificlanguage.javastone.event.TargetableEvent;

public class EnchantmentTargetAction extends EnchantmentAction implements Targetable {

    Minion target;

    EnchantmentTargetAction(Enchantment enchantment, Entity caster, Minion target) {
        super(enchantment, caster);
        this.target = target;
    }

    @Override
    public Entity getTarget() {
        return target;
    }

    @Override
    public boolean execute() {
        target.getGame().processEvent(createEvent());
        super.execute();
        return true;
    }

    @Override
    public GameEvent createEvent() {
        return createTargetableEvent();
    }

    @Override
    public Entity getCaster() {
        return caster;
    }

    @Override
    public TargetableEvent createTargetableEvent(){
        return new TargetableEvent(this);
    }
}
