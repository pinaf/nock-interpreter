/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import java.util.stream.LongStream;
import nock.model.AtomBigInteger;
import nock.model.CellConstants;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for {@link FormulaIncrement}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class FormulaIncrementTest {

    /**
     * Junit exception rule.
     */
    @Rule
    public final ExpectedException error = ExpectedException.none();

    /**
     * Increments atoms.
     */
    @Test
    public void incrementsAtoms() {
        final Formula formula = new FormulaIncrement(
            new FormulaTreeAddressing(1L)
        );
        // @checkstyle MagicNumber (1 line)
        LongStream.of(0L, 1L, 5L, 54L, 2305012L)
            .mapToObj(AtomBigInteger::new)
            .forEach(
                atom -> MatcherAssert.assertThat(
                    formula.compute(atom).asAtom().asLong(),
                    Matchers.is(atom.asLong() + 1L)
                )
            );
    }

    /**
     * Fails to increment a cell.
     */
    @Test
    public void failsOnCell() {
        this.error.expect(IllegalStateException.class);
        this.error.expectMessage("A Cell is not an Atom!");
        new FormulaIncrement(new FormulaTreeAddressing(1L))
            .compute(new CellConstants(1L, 2L));
    }

}
