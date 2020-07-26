package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Future;
import org.specificlanguage.javastone.entity.Minion;

public class ActionBuilder {

    public enum ActionType{
        ARMOR, ATTACK, COMPOUND, DAMAGE, DEATH, DRAW_CARD, HEAL, SUMMON
    }

    Entity caster;
    ActionType actionType;

    // Targetable
    Entity target;

    // General Health int (used for Armor, Damage, Health)
    int val;

    // Summon
    Minion minion;

    public ActionBuilder(Entity caster, ActionType actionType){
        this.caster = caster;
        this.actionType = actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setCaster(Entity caster) {
        this.caster = caster;
    }

    public void setMinion(Minion minion) {
        this.minion = minion;
    }

    public void setTarget(Entity target) {
        this.target = target;
    }

    public Action createAction(){
        assert(actionType != null && caster != null);
        switch(actionType){
            case ARMOR:
                assert(val > 0);
                return new ArmorAction(caster.getPlayerControlled(), val);
            case ATTACK:
                assert(target != null);
                return new AttackAction(caster, target);
            case DAMAGE:
                assert(target != null && val > 0);
                return new DamageAction(caster, target, val);
            case DEATH:
                return new DeathAction(caster);
            case DRAW_CARD:
                return new DrawCardAction(caster.getPlayerControlled(), val);
            case HEAL:
                assert(target != null);
                return new HealAction(caster, target, val);
            case SUMMON:
                assert(minion != null);
                return new SummonAction(caster, minion);

            case COMPOUND:
                return new CompoundAction();
            default:
                return null;
        }
    }

    // TODO: you know what to do


    // I have nowhere else to put this lmao
    public static boolean checkIfFutureTarget(Entity entity){
        if(entity instanceof Future){
            return true;
        }
        return false;
    }

}
