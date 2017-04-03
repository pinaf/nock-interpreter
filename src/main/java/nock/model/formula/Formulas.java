/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

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

}
