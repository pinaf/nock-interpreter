/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

/**
 * {@link FormulaSource} for {@link FormulaTreeAddressing}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class FormulaSourceTreeAddressing implements FormulaSource {

    @Override
    public Formula apply(final FormulaCell cell) {
        return new FormulaTreeAddressing(cell.body().asAtom());
    }

}
