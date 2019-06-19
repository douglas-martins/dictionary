package br.univali.kob.model;

import java.util.function.Function;

/**
 * Hash base class.
 */
public class Hash implements Function<Object, Integer> {

    @Override
    public Integer apply(Object o) {
        return Math.abs(o.hashCode() % 10);
    }
}
