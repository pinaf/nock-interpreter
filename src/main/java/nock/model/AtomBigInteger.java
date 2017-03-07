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
    private final BigInteger value;

    /**
     * Ctor.
     * @param value Value
     */
    public AtomBigInteger(final long value) {
        this(BigInteger.valueOf(value));
    }

    /**
     * Ctor.
     * @param value Value
     */
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

}

