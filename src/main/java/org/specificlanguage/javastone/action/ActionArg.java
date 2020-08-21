package org.specificlanguage.javastone.action;

public enum ActionArg {

    CLASS,

    TARGETABLE,
    TARGET,
    CASTER,
    FILTER, // requires a filter from Filter to check

    CARD_TYPE,

    DAMAGE,
    HEAL,
    ATTRIBUTES,
    NESTED_ACTIONS,
    ARMOR,
    ATTACK;
}
