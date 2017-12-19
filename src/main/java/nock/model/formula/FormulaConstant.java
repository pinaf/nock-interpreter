/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import nock.model.Noun;

/**
 * Constant formula.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@Accessors(fluent = true)
@RequiredArgsConstructor
public final class FormulaConstant implements Formula {

    /**
     * Constant product.
     */
    @Getter
    private final Noun constant;

    @Override
    public Noun compute(final Noun subject) {
        return this.constant;
    }

}
