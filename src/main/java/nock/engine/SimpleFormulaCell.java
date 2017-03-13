/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.engine;

import nock.model.Atom;
import nock.model.Cell;
import nock.model.CellSimple;
import nock.model.Noun;

/**
 * Simple cell-backed implementation of {@link FormulaCell}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class SimpleFormulaCell implements FormulaCell<Noun> {

    /**
     * Cell representing this formula.
     */
    private final Cell<Atom, Noun> cell;

    /**
     * Ctor.
     * @param cell Input cell to build formula from
     */
    public SimpleFormulaCell(final Cell<?, ? extends Noun> cell) {
        this.cell = new CellSimple<>(cell.leftAtom(), cell.right());
    }

    @Override
    public long opcode() {
        return this.cell.left().asLong();
    }

    @Override
    public Noun body() {
        return this.cell.right();
    }

}
