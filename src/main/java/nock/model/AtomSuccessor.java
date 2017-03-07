package nock.model;

import java.math.BigInteger;

/**
 * A decorator for an {@link Atom} a that represents its successor a + 1.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class AtomSuccessor implements Atom {

    /**
     * Wrapped atom.
     */
    private final Atom atom;

    /**
     * Ctor.
     * @param atom Atom to decorate.
     */
    public AtomSuccessor(final Atom atom) {
        this.atom = atom;
    }

    @Override
    public BigInteger value() {
        return this.atom.value().add(BigInteger.ONE);
    }

}
