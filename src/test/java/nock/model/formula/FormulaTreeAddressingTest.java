/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import nock.model.AtomBigInteger;
import nock.model.CellSimple;
import nock.model.Noun;
import nock.operator.Slot;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for {@link FormulaTreeAddressing}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class FormulaTreeAddressingTest {

    /**
     * Junit expected exception.
     */
    @Rule
    public final ExpectedException error = ExpectedException.none();

    /**
     * Fails for address 0.
     */
    @Test
    public void failsForZeroAtom() {
        this.error.expect(IllegalArgumentException.class);
        this.error.expectMessage("Slot operator not defined for the atom 0.");
        // @checkstyle MagicNumberCheck (1 line)
        new FormulaTreeAddressing(0L).compute(new AtomBigInteger());
    }

    /**
     * Fails for address 2 on atom.
     */
    @Test
    public void failsForSlotTwoOnAtom() {
        this.error.expect(IllegalArgumentException.class);
        this.error.expectMessage("/2 not defined for atoms.");
        new FormulaTreeAddressing(Slot.LEFT).compute(new AtomBigInteger());
    }

    /**
     * Fails for address 3 on atom.
     */
    @Test
    public void failsForSlotThreeOnAtom() {
        this.error.expect(IllegalArgumentException.class);
        this.error.expectMessage("/3 not defined for atoms.");
        new FormulaTreeAddressing(Slot.RIGHT).compute(new AtomBigInteger());
    }

    /**
     * Addresses sample tree.
     */
    @Test
    public void addressesSampleTree() {
        final Noun tree = new CellSimple<>(
            new CellSimple<>(
                new AtomBigInteger(4L),
                new AtomBigInteger(5L)
            ),
            new CellSimple<>(
                new AtomBigInteger(6L),
                new CellSimple<>(
                    new AtomBigInteger(14L),
                    new AtomBigInteger(15L)
                )
            )
        );
        MatcherAssert.assertThat(
            new FormulaTreeAddressing(Slot.ROOT).compute(tree).toString(),
            Matchers.is("[[4 5] [6 [14 15]]]")
        );
        MatcherAssert.assertThat(
            new FormulaTreeAddressing(Slot.LEFT).compute(tree).toString(),
            Matchers.is("[4 5]")
        );
        MatcherAssert.assertThat(
            new FormulaTreeAddressing(Slot.RIGHT).compute(tree).toString(),
            Matchers.is("[6 [14 15]]")
        );
        MatcherAssert.assertThat(
            // @checkstyle MagicNumberCheck (1 line)
            new FormulaTreeAddressing(4L).compute(tree).toString(),
            Matchers.is("4")
        );
        MatcherAssert.assertThat(
            // @checkstyle MagicNumberCheck (1 line)
            new FormulaTreeAddressing(7L).compute(tree).toString(),
            Matchers.is("[14 15]")
        );
    }

}
