/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import lombok.RequiredArgsConstructor;
import nock.model.AtomBigInteger;
import nock.model.Noun;

/**
 * A {@link Formula} that checks whether the given {@link Noun}
 * is a cell.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class FormulaCellCheck implements Formula  {

    /**
     * Formula.
     */
    private final Formula formula;

    @Override
    public Noun compute(final Noun subject) {
        final long result;
        if (this.formula.compute(subject).isAtom()) {
            result = 1L;
        } else {
            result = 0L;
        }
        return new AtomBigInteger(result);
    }

}
