/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import lombok.RequiredArgsConstructor;
import nock.model.Cell;
import nock.model.Noun;

/**
 * {@link FormulaSource} for {@link FormulaEval}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class FormulaSourceEval implements FormulaSource {

    /**
     * Formulas.
     */
    private final Formulas formulas;

    @Override
    public Formula apply(final FormulaCell cell) {
        final Cell<? extends Noun, ? extends Noun> body = cell.body().asCell();
        final Formula right = this.formulas.fromCell(body.rightCell());
        return new FormulaEval(
            this.formulas.fromCell(body.leftCell()),
            subject -> this.formulas.fromCell(right.compute(subject).asCell())
        );
    }

}
