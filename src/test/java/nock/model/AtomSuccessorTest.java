/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Tests for {@link AtomSuccessor}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class AtomSuccessorTest {

    /**
     * Self-identifies as an {@link Atom}.
     */
    @Test
    public void selfIdentifiesAsAtom() {
        MatcherAssert.assertThat(
            new AtomSuccessor(Mockito.mock(Atom.class)).isAtom(),
            Matchers.is(true)
        );
    }

    /**
     * Increments correctly.
     * @checkstyle MagicNumberCheck (20 lines)
     */
    @Test
    public void increments() {
        MatcherAssert.assertThat(
            new AtomSuccessor(new AtomBigInteger(0L)).asLong(),
            Matchers.is(1L)
        );
        MatcherAssert.assertThat(
            new AtomSuccessor(new AtomBigInteger(42L)).asLong(),
            Matchers.is(43L)
        );
        MatcherAssert.assertThat(
            new AtomSuccessor(
                new AtomSuccessor(new AtomBigInteger(0L))
            ).asLong(),
            Matchers.is(2L)
        );
    }

}
