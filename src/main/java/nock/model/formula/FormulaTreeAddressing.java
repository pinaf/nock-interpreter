/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import java.math.BigInteger;
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
public final class FormulaTreeAddressing extends FormulaWrap<Atom> {

    /**
     * Slot operator.
     */
    private final Slot slot;

    /**
     * Ctor.
     * @param address Tree address
     */
    public FormulaTreeAddressing(final long address) {
        this(BigInteger.valueOf(address));
    }

    /**
     * Ctor.
     * @param address Tree address
     */
    public FormulaTreeAddressing(final BigInteger address) {
        super(new AtomBigInteger(BigInteger.ZERO), new AtomBigInteger(address));
        this.slot = new SlotSimple();
    }

    @Override
    public Noun compute(final Noun subject) {
        return this.slot.apply(this.right(), subject);
    }

}
