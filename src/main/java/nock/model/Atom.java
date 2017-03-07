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

    /**
     * Retrieves this atom's value as a {@link BigInteger}.
     * @return Value
     */
    BigInteger value();

    /**
     * Returns a new Atom whose value is 1 more than the value of this
     * Atom.
     * @return The Atom a + 1
     */
    default Atom increment() {
        return new AtomSuccessor(this);
    }

}
