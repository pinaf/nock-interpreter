/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.engine;

import nock.model.Noun;

/**
 * Nock {@link Engine}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class NockEngine implements Engine {

    @Override
    public Noun compute(final Noun noun) {
        if (noun.isAtom()) {
            throw new IllegalArgumentException("nock(atom) is an error!");
        }
        return noun;
    }

}
