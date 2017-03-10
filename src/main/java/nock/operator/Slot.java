/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.operator;

import nock.model.Atom;
import nock.model.Noun;

/**
 * Slot operator for tree addressing.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public interface Slot {

    /**
     * Slot 1 = Root.
     */
    long ROOT = 1L;

    /**
     * Slot 2 = Left node.
     */
    long LEFT = 2L;

    /**
     * Slot 3 = Right node.
     */
    long RIGHT = 3L;

    /**
     * Applies the slot operator.
     * @param atom Atom
     * @param noun Noun
     * @return Resulting noun
     */
    Noun apply(Atom atom, Noun noun);

}
