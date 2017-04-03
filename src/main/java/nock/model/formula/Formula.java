/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import nock.model.Noun;

/**
 * A Formula.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public interface Formula {

    /**
     * Computes this formula on the given subject.
     * @param subject Subject
     * @return Resulting Noun
     */
    Noun compute(Noun subject);

}
