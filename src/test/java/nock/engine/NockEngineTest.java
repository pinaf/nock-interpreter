/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.engine;

import nock.model.Atom;
import nock.model.CellSimple;
import nock.model.Noun;
import nock.model.formula.Formula;
import nock.model.formula.Formulas;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
     * Formulas.
     */
    @Mock
    private Formulas formulas;

    /**
     * Identity formula.
     */
    @Mock
    private Formula identity;

    /**
     * Initialization.
     */
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Mockito
            .when(this.identity.compute(org.mockito.Matchers.any()))
            .thenAnswer(answer -> answer.getArguments()[0]);
        Mockito
            .when(this.formulas.fromCell(org.mockito.Matchers.any()))
            .thenReturn(this.identity);
    }

    /**
     * Fails when computing on an atom.
     */
    @Test
    public void computeFailsOnAtom() {
        this.error.expect(IllegalArgumentException.class);
        this.error.expectMessage("nock(atom) is an error!");
        final Noun atom = Mockito.mock(Noun.class);
        Mockito.when(atom.isAtom()).thenReturn(true);
        new NockEngine(this.formulas).compute(atom);
    }

    /**
     * Succeeds when computing on a [subject formula] cell.
     */
    @Test
    public void computeSucceedsOnSubjectFormulaCell() {
        final Noun subject = Mockito.mock(Noun.class);
        final Noun cell = new CellSimple<>(
            subject,
            new CellSimple<>(
                Mockito.mock(Atom.class),
                Mockito.mock(Noun.class)
            )
        );
        final Noun result = new NockEngine(this.formulas).compute(cell);
        MatcherAssert.assertThat(result, Matchers.is(subject));
        Mockito.verify(this.formulas).fromCell(org.mockito.Matchers.any());
        Mockito.verify(this.identity).compute(subject);
    }

}
