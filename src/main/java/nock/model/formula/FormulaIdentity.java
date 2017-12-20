/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import nock.model.Noun;

/**
 * Identity {@link Formula}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class FormulaIdentity implements Formula {

    @Override
    public Noun compute(final Noun subject) {
        return subject;
    }

}
