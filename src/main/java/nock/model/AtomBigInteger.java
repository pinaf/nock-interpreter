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
@SuppressWarnings("PMD.AvoidFieldNameMatchingMethodName")
public final class AtomBigInteger implements Atom {

    /**
     * Value.
     */
    private final BigInteger value;

    /**
     * Ctor.
     * Creates the Atom a = 0.
     */
    public AtomBigInteger() {
        this(0L);
    }

    /**
     * Ctor.
     * @param value Value
     */
    public AtomBigInteger(final long value) {
        this(BigInteger.valueOf(value));
    }

    /**
     * Ctor.
     * @param value Value in string format.
     */
    public AtomBigInteger(final CharSequence value) {
        this(new BigInteger(value.toString()));
    }

    /**
     * Ctor.
     * @param value Value
     */
    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public AtomBigInteger(final BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Atoms are natural numbers");
        }
        this.value = value;
    }

    @Override
    public BigInteger value() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.asString();
    }

}

