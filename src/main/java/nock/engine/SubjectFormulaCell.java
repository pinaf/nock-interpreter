/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.engine;

import nock.model.Cell;
import nock.model.Noun;

/**
 * Subject-formula cell.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
@SuppressWarnings("PMD.AvoidFieldNameMatchingMethodName")
public final class SubjectFormulaCell {

    /**
     * Subject.
     */
    private final Noun subject;

    /**
     * Formula.
     */
    private final FormulaCell<? extends Noun> formula;

    /**
     * Ctor.
     * @param cell Cell of type [subject formula]
     */
    public SubjectFormulaCell(final Cell<? extends Noun, ? extends Noun> cell) {
        this.subject = cell.left();
        this.formula = new SimpleFormulaCell(cell.rightCell());
    }

    /**
     * This cell's subject.
     * @return Subject
     */
    public Noun subject() {
        return this.subject;
    }

    /**
     * The cell's formula.
     * @return Formula
     */
    public FormulaCell<? extends Noun> formula() {
        return this.formula;
    }

}
