/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import nock.model.Noun;

/**
 * Eval.
 * *[a 2 b c] -> *[*[a b] *[a c]]
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class FormulaEval implements Formula {

    /**
     * Left (subject) formula.
     */
    private final Formula left;

    /**
     * Right (formula) formula.
     */
    private final Function<Noun, Formula> right;

    @Override
    public Noun compute(final Noun subject) {
        return this.right.apply(subject).compute(this.left.compute(subject));
    }

}

