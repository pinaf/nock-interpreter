/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model;

import lombok.RequiredArgsConstructor;

/**
 * A wrapped {@link Cell}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @param <T> Left noun type
 * @param <U> Right noun type
 * @since 1.0
 * @checkstyle LineLength (5 lines)
 * @checkstyle AbstractClassNameCheck (4 lines)
 */
@RequiredArgsConstructor
@SuppressWarnings("PMD.AbstractNaming")
public abstract class CellWrap<T extends Noun, U extends Noun> implements Cell<T, U> {

    /**
     * Wrapped cell.
     */
    private final Cell<T, U> cell;

    @Override
    public final T left() {
        return this.cell.left();
    }

    @Override
    public final U right() {
        return this.cell.right();
    }

}
