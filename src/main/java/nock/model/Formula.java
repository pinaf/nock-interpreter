/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model;

/**
 * A Formula.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @param <T> Formula's noun type
 * @since 1.0.0
 */
public interface Formula<T extends Noun> extends Cell<Atom, T> {

    /**
     * Computes this formula on the given subject.
     * @param subject Subject
     * @return Resulting Noun
     */
    Noun compute(Noun subject);

}
