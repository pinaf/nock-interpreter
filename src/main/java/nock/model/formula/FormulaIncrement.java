/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import lombok.RequiredArgsConstructor;
import nock.model.Noun;

/**
 * Increments an atom.
 * *[a 4 b] -> +*[a b]
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class FormulaIncrement implements Formula {

    /**
     * Formula.
     */
    private final Formula formula;

    @Override
    public Noun compute(final Noun subject) {
        return this.formula.compute(subject).asAtom().increment();
    }

}

