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

    /**
     * Attempts to cast this Noun into an {@link Atom}.
     * @return Atom, if possible
     */
    Atom asAtom();

    /**
     * Attempts to cast this Noun into an {@link Cell}.
     * @return Cell, if possible
     */
    Cell asCell();

    /**
     * Returns a string representation for this Noun.
     * @return String representation
     */
    String asString();

}
