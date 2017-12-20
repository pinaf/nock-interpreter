/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import lombok.RequiredArgsConstructor;

/**
 * {@link FormulaSource} for {@link FormulaIncrement}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class FormulaSourceIncrement implements FormulaSource {

    /**
     * Formulas.
     */
    private final Formulas formulas;

    @Override
    public Formula apply(final FormulaCell cell) {
        final Formula formula = this.formulas.fromCell(cell.body().asCell());
        return new FormulaIncrement(formula);
    }

}
