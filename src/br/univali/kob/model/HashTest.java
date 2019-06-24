package br.univali.kob.model;

import java.util.function.Function;

/**
 * Base HashTest class.
 */
public class HashTest implements Function<Object, Integer> {
    @Override
    public Integer apply(Object o) { return Math.abs(o.hashCode() % 20); }
}
