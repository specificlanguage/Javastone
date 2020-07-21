package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Future;
import org.specificlanguage.javastone.entity.Player;

public class Damage extends Targetable {

    private Entity target;
    private int damage;

    public Damage(Entity target, Entity caster, int damage){
        if(caster instanceof Future || target == null || caster == null || damage <= 0){
            throw new IllegalArgumentException();
        }
        this.target = target;
        this.caster = caster;
        this.damage = damage;
    }


    @Override
    public boolean execute() {
        if(target instanceof Future) {
            //reassign target to be done
        }

        // DamageEvent?
        target.damage(damage);
        return true;
    }

    public Entity getCaster(){
        return caster;
    }

}
