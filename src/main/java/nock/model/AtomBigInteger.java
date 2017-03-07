/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model;

import java.math.BigInteger;

/**
 * A {@link BigInteger} backed implementation of {@link Atom}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class AtomBigInteger implements Atom {

    /**
     * Value.
     */
    private final BigInteger number;

    /**
     * Ctor.
     * @param number Value
     */
    public AtomBigInteger(final long number) {
        this(BigInteger.valueOf(number));
    }

    /**
     * Ctor.
     * @param number Value
     */
    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public AtomBigInteger(final BigInteger number) {
        if (number.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Atoms are natural numbers");
        }
        this.number = number;
    }

    @Override
    public BigInteger value() {
        return this.number;
    }

}

