/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.engine;

import nock.model.Noun;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

/**
 * Tests for {@link NockEngine}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class NockEngineTest {

    /**
     * Junit expected exception.
     */
    @Rule
    public final ExpectedException error = ExpectedException.none();

    /**
     * Fails when computing on an atom.
     */
    @Test
    public void computeFailsOnAtom() {
        this.error.expect(IllegalArgumentException.class);
        this.error.expectMessage("nock(atom) is an error!");
        final Noun atom = Mockito.mock(Noun.class);
        Mockito.when(atom.isAtom()).thenReturn(true);
        new NockEngine().compute(atom);
    }

    /**
     * Succeeds when computing on a cell.
     */
    @Test
    public void computeSucceedsOnCell() {
        final Noun cell = Mockito.mock(Noun.class);
        Mockito.when(cell.isAtom()).thenReturn(false);
        MatcherAssert.assertThat(
            new NockEngine().compute(cell),
            Matchers.notNullValue()
        );
    }

}
