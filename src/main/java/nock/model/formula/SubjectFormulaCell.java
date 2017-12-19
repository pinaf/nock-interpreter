/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

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
    private final FormulaCell formula;

    /**
     * Ctor.
     * @param subject Subject
     * @param formula Formula
     */
    public SubjectFormulaCell(final Noun subject, final Noun formula) {
        this(subject, formula.asCell());
    }

    /**
     * Ctor.
     * @param subject Subject
     * @param formula Formula
     */
    public SubjectFormulaCell(final Noun subject,
        final Cell<? extends Noun, ? extends Noun> formula) {
        this.subject = subject;
        this.formula = new SimpleFormulaCell(formula);
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
    public FormulaCell formula() {
        return this.formula;
    }

}
