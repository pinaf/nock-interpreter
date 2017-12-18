/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model;

import lombok.RequiredArgsConstructor;

/**
 * Simple implementation of {@link Cell}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @param <T> Left noun type
 * @param <U> Right noun type
 * @since 1.0.0
 * @checkstyle LineLength (4 lines)
 */
@RequiredArgsConstructor
@SuppressWarnings("PMD.AvoidFieldNameMatchingMethodName")
public final class CellSimple<T extends Noun, U extends Noun> implements Cell<T, U> {

    /**
     * This Cell's left noun.
     */
    private final T left;

    /**
     * This Cell's right noun.
     */
    private final U right;

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
