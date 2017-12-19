/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import lombok.RequiredArgsConstructor;
import nock.model.Noun;

/**
 * Constant formula.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class FormulaConstant implements Formula {

    /**
     * Constant product.
     */
    private final Noun constant;

    @Override
    public Noun compute(final Noun subject) {
        return this.constant;
    }

}
