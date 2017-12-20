/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model;

/**
 * A {@link Cell} of 2 {@link Atom}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class CellConstants extends CellWrap<Atom, Atom> {

    /**
     * Ctor.
     * @param left Left atom.
     * @param right Right atom.
     */
    public CellConstants(final long left, final long right) {
        super(
            new CellSimple<>(
                new AtomBigInteger(left),
                new AtomBigInteger(right)
            )
        );
    }

}
