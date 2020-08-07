package org.specificlanguage.javastone.action.test;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.attributes.Attribute;

import java.util.HashMap;

public interface TargetableAction<T> extends GameAction<T>{

    Entity getTarget();

}
