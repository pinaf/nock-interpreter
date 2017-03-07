/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model;

/**
 * Simple implementation of {@link Cell}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
@SuppressWarnings("PMD.AvoidFieldNameMatchingMethodName")
public final class CellSimple implements Cell {

    /**
     * This Cell's left noun.
     */
    private final Noun left;

    /**
     * This Cell's right noun.
     */
    private final Noun right;

    /**
     * Ctor.
     * @param left Left noun
     * @param right Right noun
     */
    public CellSimple(final Noun left, final Noun right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Noun left() {
        return this.left;
    }

    @Override
    public Noun right() {
        return this.right;
    }

}
