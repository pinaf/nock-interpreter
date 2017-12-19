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
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Tests for {@link FormulaSourceConstant}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class FormulaSourceConstantTest {

    /**
     * Formula source.
     */
    private final FormulaSource source = new FormulaSourceConstant();

    /**
     * Returns an instance of {@link FormulaConstant} with the correct
     * product.
     */
    @Test
    public void returnsFormulaConstant() {
        final long value = 3L;
        final FormulaCell cell = new SimpleFormulaCell(
            new CellSimple<>(
                Mockito.mock(Noun.class),
                new AtomBigInteger(value)
            )
        );
        final Formula formula = this.source.apply(cell);
        MatcherAssert.assertThat(
            formula,
            Matchers.instanceOf(FormulaConstant.class)
        );
        MatcherAssert.assertThat(
            FormulaConstant.class.cast(formula).constant().asAtom().asLong(),
            Matchers.is(value)
        );
    }

}
