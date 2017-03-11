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
 * @param <T> Left noun type
 * @param <U> Right noun type
 * @since 1.0.0
 */
public interface Cell<T extends Noun, U extends Noun> extends Noun {

    @Override
    default boolean isAtom() {
        return false;
    }

    @Override
    default Atom asAtom() {
        throw new IllegalStateException("A Cell is not an Atom!");
    }

    @Override
    default Cell<T, U> asCell() {
        return this;
    }

    /**
     * Cell's left side.
     * @return Noun
     */
    T left();

    /**
     * This Cell's right {@link Noun}.
     * @return Noun
     */
    U right();

    @Override
    default String asString() {
        return String.format(
            "[%s %s]",
            this.left().asString(),
            this.right().asString()
        );
    }

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
    default Cell<? extends Noun, ? extends Noun> leftCell() {
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
    default Cell<? extends Noun, ? extends Noun> rightCell() {
        return this.right().asCell();
    }

}
