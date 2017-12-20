/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link CellWrap}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class CellWrapTest {

    /**
     * Self-identifies as a {@link Cell}.
     */
    @Test
    public void returnsLeftAndRightNouns() {
        final Cell<Atom, Atom> wrapped = new CellConstants(0L, 1L);
        final Cell<Atom, Atom> cell = new CellWrapTest.Simple<>(wrapped);
        MatcherAssert.assertThat(
            cell.left().asAtom().asLong(),
            Matchers.is(wrapped.left().asAtom().asLong())
        );
        MatcherAssert.assertThat(
            cell.right().asAtom().asLong(),
            Matchers.is(wrapped.right().asAtom().asLong())
        );
    }

    /**
     * Simple wrapped cell for testing.
     * @param <T> Left noun type
     * @param <U> Right noun type
     * @checkstyle LineLength (2 lines)
     */
    private static final class Simple<T extends Noun, U extends Noun> extends CellWrap<T, U> {

        /**
         * Ctor.
         * @param cell Wrapped cell
         */
        private Simple(final Cell<T, U> cell) {
            super(cell);
        }

    }

}
