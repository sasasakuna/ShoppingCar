package com.thoughtworks.ns.collection;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-8
 * Time: 下午11:08
 * To change this template use File | Settings | File Templates.
 */
public interface Func<F, T> {
    T apply(F currentElement, T origin);
}
