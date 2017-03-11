/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for {@link CellSimple}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class CellSimpleTest {

    /**
     * Junit expected exception.
     */
    @Rule
    public final ExpectedException error = ExpectedException.none();

    /**
     * Self-identifies as a {@link Cell}.
     */
    @Test
    public void selfIdentifiesAsCell() {
        MatcherAssert.assertThat(
            new CellSimple<>(new AtomBigInteger(), new AtomBigInteger())
                .isAtom(),
            Matchers.is(false)
        );
    }

    /**
     * Fails a cast to {@link Atom}.
     */
    @Test
    public void failsCastToAtom() {
        this.error.expect(IllegalStateException.class);
        this.error.expectMessage("A Cell is not an Atom!");
        new CellSimple<>(new AtomBigInteger(), new AtomBigInteger()).asAtom();
    }

    /**
     * Forms trees.
     * @checkstyle MagicNumberCheck (40 lines)
     */
    @Test
    public void formsTrees() {
        final Cell<?, ?> tree = new CellSimple<>(
            new CellSimple<>(
                new AtomBigInteger(4L),
                new AtomBigInteger(5L)
            ),
            new CellSimple<>(
                new AtomBigInteger(6L),
                new CellSimple<>(
                    new AtomBigInteger(14L),
                    new AtomBigInteger(15L)
                )
            )
        );
        MatcherAssert.assertThat(
            tree.leftCell().leftAtom().asLong(),
            Matchers.is(4L)
        );
        MatcherAssert.assertThat(
            tree.leftCell().rightAtom().asLong(),
            Matchers.is(5L)
        );
        MatcherAssert.assertThat(
            tree.rightCell().leftAtom().asLong(),
            Matchers.is(6L)
        );
        MatcherAssert.assertThat(
            tree.rightCell().rightCell().leftAtom().asLong(),
            Matchers.is(14L)
        );
        MatcherAssert.assertThat(
            tree.rightCell().rightCell().rightAtom().asLong(),
            Matchers.is(15L)
        );
    }

    /**
     * Prints canonically.
     */
    @Test
    public void printsCanonically() {
        final Cell<?, ?> tree = new CellSimple<>(
            new CellSimple<>(
                new AtomBigInteger(4L),
                new AtomBigInteger(5L)
            ),
            new CellSimple<>(
                new AtomBigInteger(6L),
                new CellSimple<>(
                    new AtomBigInteger(14L),
                    new AtomBigInteger(15L)
                )
            )
        );
        MatcherAssert.assertThat(
            tree.toString(),
            Matchers.is("[[4 5] [6 [14 15]]]")
        );
    }

}
