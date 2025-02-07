package com.aaalace.kpomini1.common.enums;

public enum Command {
    POST_ANIMAL("1"),
    GET_ALL_ANIMALS("2"),
    GET_TOTAL_FOOD("3"),
    GET_ANIMALS_BY_CONTACT_FILTER("4"),
    EXIT_ZOO("5");

    public final String id;

    Command(String id) {
        this.id = id;
    }
}
