/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import nock.model.Atom;
import nock.model.AtomBigInteger;
import nock.model.Cell;
import nock.model.CellSimple;
import nock.model.Noun;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Tests for {@link SimpleFormulaCell}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class SimpleFormulaCellTest {

    /**
     * Call to .toString() matches cell.
     */
    @Test
    public void toStringMatchesCell() {
        final Cell<Atom, Noun> cell = new CellSimple<>(
            new AtomBigInteger(),
            new AtomBigInteger()
        );
        MatcherAssert.assertThat(
            new SimpleFormulaCell(cell).toString(),
            Matchers.is(
                String.format("SimpleFormulaCell(cell=%s)", cell.toString())
            )
        );
    }

    /**
     * Reads opcode from the cell.
     */
    @Test
    public void readsOpcode() {
        final long opcode = 3L;
        MatcherAssert.assertThat(
            new SimpleFormulaCell(
                new CellSimple<>(
                    new AtomBigInteger(opcode),
                    Mockito.mock(Noun.class)
                )
            ).opcode(),
            Matchers.is(opcode)
        );
    }

    /**
     * Reads body from the cell.
     */
    @Test
    public void readsBody() {
        final Noun noun = Mockito.mock(Noun.class);
        MatcherAssert.assertThat(
            new SimpleFormulaCell(
                new CellSimple<>(Mockito.mock(Atom.class), noun)
            ).body(),
            Matchers.is(noun)
        );
    }

}
