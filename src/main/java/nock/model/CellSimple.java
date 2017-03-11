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
 * @param <T> Left noun type
 * @param <U> Right noun type
 * @since 1.0.0
 * @checkstyle RegexpSinglelineCheck (4 lines)
 */
@SuppressWarnings("PMD.AvoidFieldNameMatchingMethodName")
public final class CellSimple<T extends Noun, U extends Noun>
    implements Cell<T, U> {

    /**
     * This Cell's left noun.
     */
    private final T left;

    /**
     * This Cell's right noun.
     */
    private final U right;

    /**
     * Ctor.
     * @param left Left noun
     * @param right Right noun
     */
    public CellSimple(final T left, final U right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public T left() {
        return this.left;
    }

    @Override
    public U right() {
        return this.right;
    }

    @Override
    public String toString() {
        return this.asString();
    }

}
