/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model;

/**
 * Noun.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public interface Noun {

    /**
     * Is this noun an atom or a cell?
     * @return True iff atom
     */
    boolean isAtom();

}
