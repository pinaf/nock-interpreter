/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import java.math.BigInteger;
import nock.model.AtomBigInteger;
import nock.model.CellSimple;
import nock.model.Noun;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Tests for {@link FormulaSourceTreeAddressing}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class FormulaSourceTreeAddressingTest {

    /**
     * Formula source.
     */
    private final FormulaSource source = new FormulaSourceTreeAddressing();

    /**
     * Returns an instance of {@link FormulaTreeAddressing} with the correct
     * address.
     */
    @Test
    public void returnsFormulaTreeAddressing() {
        final long address = 4L;
        final FormulaCell cell = new SimpleFormulaCell(
            new CellSimple<>(
                Mockito.mock(Noun.class),
                new AtomBigInteger(address)
            )
        );
        final Formula formula = this.source.apply(cell);
        MatcherAssert.assertThat(
            formula,
            Matchers.instanceOf(FormulaTreeAddressing.class)
        );
        MatcherAssert.assertThat(
            FormulaTreeAddressing.class.cast(formula).address().value(),
            Matchers.is(BigInteger.valueOf(address))
        );
    }

}
