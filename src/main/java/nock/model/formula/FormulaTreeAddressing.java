/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import nock.model.Atom;
import nock.model.AtomBigInteger;
import nock.model.Noun;
import nock.operator.Slot;
import nock.operator.SlotSimple;

/**
 * Formula for tree addressing.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class FormulaTreeAddressing implements Formula {

    /**
     * Slot operator.
     */
    private final Slot slot;

    /**
     * Address.
     */
    private final Atom address;

    /**
     * Ctor.
     * @param address Tree address
     */
    public FormulaTreeAddressing(final long address) {
        this(new AtomBigInteger(address));
    }

    /**
     * Ctor.
     * @param address Tree address
     */
    public FormulaTreeAddressing(final Atom address) {
        this.address = address;
        this.slot = new SlotSimple();
    }

    @Override
    public Noun compute(final Noun subject) {
        return this.slot.apply(this.address, subject);
    }

}
