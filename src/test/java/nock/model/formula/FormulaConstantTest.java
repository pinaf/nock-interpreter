/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */

package nock.model.formula;

import nock.model.Atom;
import nock.model.AtomBigInteger;
import nock.model.CellSimple;
import nock.model.Noun;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link FormulaConstant}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class FormulaConstantTest {

    /**
     * Produces a constant atom.
     */
    @Test
    public void producesAtom() {
        final Atom product = new AtomBigInteger(12L);
        MatcherAssert.assertThat(
            // @checkstyle MagicNumber (1 line)
            new FormulaConstant(product).compute(new AtomBigInteger(42L))
                .asAtom().asLong(),
            Matchers.is(product.asLong())
        );
    }

    /**
     * Produces a constant cell.
     */
    @Test
    public void producesCell() {
        final Noun product = new CellSimple<>(
            new AtomBigInteger(),
            new AtomBigInteger()
        );
        MatcherAssert.assertThat(
            // @checkstyle MagicNumber (1 line)
            new FormulaConstant(product).compute(new AtomBigInteger(10L))
                .asCell().asString(),
            Matchers.is(product.asString())
        );
    }

}
