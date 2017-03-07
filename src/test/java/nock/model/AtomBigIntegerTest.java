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
 * Tests for {@link AtomBigInteger}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class AtomBigIntegerTest {

    /**
     * Junit expected exception.
     */
    @Rule
    public final ExpectedException error = ExpectedException.none();

    /**
     * Self-identifies as an {@link Atom}.
     */
    @Test
    public void selfIdentifiesAsAtom() {
        MatcherAssert.assertThat(
            new AtomBigInteger().isAtom(),
            Matchers.is(true)
        );
    }

    /**
     * Fails a cast to {@link Cell}.
     */
    @Test
    public void failsCastToCell() {
        this.error.expect(IllegalStateException.class);
        this.error.expectMessage("An Atom is not a Cell!");
        new AtomBigInteger().asCell();
    }

    /**
     * Rejects negative value.
     */
    @Test
    public void rejectsNegativeValue() {
        this.error.expect(IllegalArgumentException.class);
        this.error.expectMessage("Atoms are natural numbers");
        new AtomBigInteger(-1L);
    }

    /**
     * Increments correctly.
     * @checkstyle MagicNumberCheck (15 lines)
     */
    @Test
    public void increments() {
        MatcherAssert.assertThat(
            new AtomBigInteger(0L).increment().asLong(),
            Matchers.is(1L)
        );
        MatcherAssert.assertThat(
            new AtomBigInteger(42L).increment().asLong(),
            Matchers.is(43L)
        );
    }

    /**
     * Prints a decimal representation.
     * @checkstyle MagicNumberCheck (21 lines)
     */
    @Test
    public void printsDecimalRepresentation() {
        MatcherAssert.assertThat(
            new AtomBigInteger().toString(),
            Matchers.is("0")
        );
        MatcherAssert.assertThat(
            new AtomBigInteger(1L).toString(),
            Matchers.is("1")
        );
        MatcherAssert.assertThat(
            new AtomBigInteger(42L).toString(),
            Matchers.is("42")
        );
        MatcherAssert.assertThat(
            new AtomBigInteger(123456789L).toString(),
            Matchers.is("123456789")
        );
    }

}
