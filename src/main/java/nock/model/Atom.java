/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model;

import java.math.BigInteger;

/**
 * Atom.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public interface Atom extends Noun {

    @Override
    default boolean isAtom() {
        return true;
    }

    @Override
    default Atom asAtom() {
        return this;
    }

    @Override
    default Cell asCell() {
        throw new IllegalStateException("An Atom is not a Cell!");
    }

    /**
     * Retrieves this atom's value as a {@link BigInteger}.
     * @return Value as a {@link BigInteger}
     */
    BigInteger value();

    /**
     * Retrieves this atom's value as a long, if possible.
     * @return Value as long
     */
    default long asLong() {
        return this.value().longValueExact();
    }

    /**
     * Returns a new Atom whose value is 1 more than the value of this
     * Atom.
     * @return The Atom a + 1
     */
    default Atom increment() {
        return new AtomSuccessor(this);
    }

}
