/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.engine;

import nock.model.Noun;
import nock.model.formula.Formula;

/**
 * Formulas.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public interface Formulas {

    /**
     * Converts the given cell to a formula.
     * @param cell Formula cell
     * @param <T> Formula's body's noun type
     * @return Formula
     */
    <T extends Noun> Formula<T> fromCell(FormulaCell<T> cell);

}
