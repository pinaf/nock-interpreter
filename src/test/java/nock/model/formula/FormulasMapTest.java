/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import nock.model.AtomBigInteger;
import nock.model.CellSimple;
import nock.model.Noun;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

/**
 * Tests for {@link FormulasMap}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class FormulasMapTest {

    /**
     * Junit expected exception.
     */
    @Rule
    public final ExpectedException error = ExpectedException.none();

    /**
     * Binds the correct formula source (and thus, produces the correct formula)
     * based on the formula cell's opcode.
     */
    @Test
    public void bindsOpcodeToFormula() {
        final Formula first = Mockito.mock(Formula.class);
        final Formula second = Mockito.mock(Formula.class);
        final Formulas formulas = new FormulasMap(
            new FormulasMap.OpCodeFormulaSourcePair(0L, this.source(first)),
            new FormulasMap.OpCodeFormulaSourcePair(1L, this.source(second))
        );
        MatcherAssert.assertThat(
            formulas.fromCell(
                new SimpleFormulaCell(
                    new CellSimple<>(
                        new AtomBigInteger(0L),
                        Mockito.mock(Noun.class)
                    )
                )
            ),
            Matchers.is(first)
        );
        MatcherAssert.assertThat(
            formulas.fromCell(
                new SimpleFormulaCell(
                    new CellSimple<>(
                        new AtomBigInteger(1L),
                        Mockito.mock(Noun.class)
                    )
                )
            ),
            Matchers.is(second)
        );
    }

    /**
     * Fails on an unknown opcode.
     */
    @Test
    public void failsOnUnknownOpcode() {
        this.error.expect(IllegalStateException.class);
        this.error.expectMessage("Unknown opcode: 0");
        new FormulasMap().fromCell(
            new SimpleFormulaCell(
                new CellSimple<>(
                    new AtomBigInteger(0L),
                    Mockito.mock(Noun.class)
                )
            )
        );
    }

    /**
     * Builds a formula source that returns the given formula.
     * @param formula Formula to return
     * @return Formula Source
     */
    private FormulaSource source(final Formula formula) {
        final FormulaSource source = Mockito.mock(FormulaSource.class);
        Mockito
            .when(source.apply(org.mockito.Matchers.any(FormulaCell.class)))
            .thenReturn(formula);
        return source;
    }

}
