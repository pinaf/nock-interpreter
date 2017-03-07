/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model;

/**
 * Cell.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public interface Cell extends Noun {

    @Override
    default boolean isAtom() {
        return false;
    }

    @Override
    default Atom asAtom() {
        throw new IllegalStateException("A Cell is not an Atom!");
    }

    @Override
    default Cell asCell() {
        return this;
    }

    /**
     * Cell's left side.
     * @return Noun
     */
    Noun left();

    /**
     * This Cell's right {@link Noun}.
     * @return Noun
     */
    Noun right();

    /**
     * This Cell's left {@link Atom}, if it's indeed one.
     * @return Atom
     */
    default Atom leftAtom() {
        return this.left().asAtom();
    }

    /**
     * This Cell's left Cell, if it's indeed one.
     * @return Atom
     */
    default Cell leftCell() {
        return this.left().asCell();
    }

    /**
     * This Cell's right {@link Atom}, if it's indeed one.
     * @return Atom
     */
    default Atom rightAtom() {
        return this.right().asAtom();
    }

    /**
     * This Cell's right Cell, if it's indeed one.
     * @return Cell
     */
    default Cell rightCell() {
        return this.right().asCell();
    }

}
