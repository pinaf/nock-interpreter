/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import nock.model.Atom;
import nock.model.Cell;
import nock.model.CellSimple;
import nock.model.Noun;

/**
 * Wrap for {@link Formula}. For inheritance.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @param <T> Formula's noun type
 * @since 1.0.0
 * @checkstyle AbstractClassNameCheck (2 lines)
 */
@SuppressWarnings("PMD.AbstractNaming")
public abstract class FormulaWrap<T extends Noun> implements Formula<T> {

    /**
     * Wrapped cell.
     */
    private final Cell<Atom, T> cell;

    /**
     * Ctor.
     * @param atom Atom (left)
     * @param noun Noun (right)
     */
    protected FormulaWrap(final Atom atom, final T noun) {
        this.cell = new CellSimple<>(atom, noun);
    }

    @Override
    public final Atom left() {
        return this.cell.left();
    }

    @Override
    public final T right() {
        return this.cell.right();
    }

}
