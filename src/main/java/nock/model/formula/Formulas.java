/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import nock.model.Cell;
import nock.model.Noun;

/**
 * Formulas.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public interface Formulas {

    /**
     * Retrieves the formula associated with the given formula cell.
     * @param cell Formula cell
     * @return Formula, if any
     */
    Formula fromCell(FormulaCell cell);

    /**
     * Retrieves the formula associated with the given cell.
     * @param cell Formula cell
     * @return Formula, if any
     */
    default Formula fromCell(final Cell<? extends Noun, ? extends Noun> cell) {
        return this.fromCell(new SimpleFormulaCell(cell));
    }

}
