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
     * Self-identifies as an Atom.
     */
    @Test
    public void selfIdentifiesAsAtom() {
        MatcherAssert.assertThat(
            new AtomSuccessor(Mockito.mock(Atom.class)).isAtom(),
            Matchers.is(true)
        );
    }

    @Test
    public void increments() {
        MatcherAssert.assertThat(
            new AtomSuccessor(new AtomBigInteger(0L)).value().longValueExact(),
            Matchers.is(1L)
        );
        MatcherAssert.assertThat(
            new AtomSuccessor(new AtomBigInteger(42L)).value().longValueExact(),
            Matchers.is(43L)
        );
        MatcherAssert.assertThat(
            new AtomSuccessor(
                new AtomSuccessor(new AtomBigInteger(0L))
            ).value().longValueExact(),
            Matchers.is(2L)
        );
    }

}
