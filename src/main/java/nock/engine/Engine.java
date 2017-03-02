/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.engine;

import nock.model.Noun;

/**
 * Interpreter engine.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public interface Engine {

    /**
     * Computes nock(noun).
     * @param noun Input noun
     * @return Resulting noun
     */
    Noun compute(Noun noun);

}
