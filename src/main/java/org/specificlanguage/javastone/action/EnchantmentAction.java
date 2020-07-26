package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.enchantment.Enchantment;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.event.GameEvent;

public class EnchantmentAction implements Action{

    private class EnchantmentEvent implements GameEvent{

        EnchantmentAction action;

        EnchantmentEvent(EnchantmentAction action){
            this.action = action;
        }

        @Override
        public Action getAction() {
            return action;
        }
    }

    Enchantment enchantment;
    Entity caster;

    EnchantmentAction(Enchantment enchantment, Entity caster){
        this.enchantment = enchantment;
        this.caster = caster;
    }

    @Override
    public boolean execute() {
        caster.getGame().processEvent(createEvent());
        enchantment.execute();
        return true;
    }

    @Override
    public GameEvent createEvent() {
        return new EnchantmentEvent(this);
    }

    @Override
    public Entity getCaster() {
        return caster;
    }
}
