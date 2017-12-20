/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import java.util.stream.LongStream;
import nock.model.AtomBigInteger;
import nock.model.CellSimple;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link FormulaCellCheck}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class FormulaCellCheckTest {

    /**
     * Detects atoms.
     */
    @Test
    public void worksOnAtoms() {
        final Formula formula = new FormulaCellCheck(new FormulaIdentity());
        // @checkstyle MagicNumber (1 line)
        LongStream.of(0L, 1L, 12L, 45L, 8740L)
            .mapToObj(AtomBigInteger::new)
            .forEach(
                atom -> MatcherAssert.assertThat(
                    formula.compute(atom).asAtom().asLong(),
                    Matchers.is(1L)
                )
            );
    }

    /**
     * Detects cells.
     */
    @Test
    public void worksOnCells() {
        final Formula formula = new FormulaCellCheck(new FormulaIdentity());
        // @checkstyle MagicNumber (1 line)
        LongStream.of(0L, 1L, 12L, 45L, 8740L)
            .mapToObj(
                l -> new CellSimple<>(
                    new AtomBigInteger(l), new AtomBigInteger(l + 1L)
                )
            ).forEach(
                cell -> MatcherAssert.assertThat(
                    formula.compute(cell).asAtom().asLong(),
                    Matchers.is(0L)
                )
            );
    }

}
