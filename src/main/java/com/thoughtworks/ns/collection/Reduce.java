package com.thoughtworks.ns.collection;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-8
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
public class Reduce {
    private Reduce() {

    }

    public static <F,T> T reduce(final Iterable<F> iterable, final Func<F, T> func, T origin) {

        for (Iterator iterator = iterable.iterator(); iterator.hasNext(); ) {
            origin = func.apply((F)(iterator.next()), origin);
        }

        return origin;
    }
}
