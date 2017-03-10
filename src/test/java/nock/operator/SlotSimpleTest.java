/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.operator;

import nock.model.AtomBigInteger;
import nock.model.CellSimple;
import nock.model.Noun;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for {@link SlotSimple}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class SlotSimpleTest {

    /**
     * Junit expected exception.
     */
    @Rule
    public final ExpectedException error = ExpectedException.none();

    /**
     * Slot operator.
     */
    private final Slot slot = new SlotSimple();

    /**
     * Fails for 0 atom.
     */
    @Test
    public void failsForZeroAtom() {
        this.error.expect(IllegalArgumentException.class);
        this.error.expectMessage("Slot operator not defined for the atom 0.");
        // @checkstyle MagicNumberCheck (1 line)
        this.slot.apply(new AtomBigInteger(0L), new AtomBigInteger());
    }

    /**
     * Fails for slot 2 on atom.
     */
    @Test
    public void failsForSlotTwoOnAtom() {
        this.error.expect(IllegalArgumentException.class);
        this.error.expectMessage("/2 not defined for atoms.");
        this.slot.apply(new AtomBigInteger(Slot.LEFT), new AtomBigInteger());
    }

    /**
     * Fails for slot 3 on atom.
     */
    @Test
    public void failsForSlotThreeOnAtom() {
        this.error.expect(IllegalArgumentException.class);
        this.error.expectMessage("/3 not defined for atoms.");
        this.slot.apply(new AtomBigInteger(Slot.RIGHT), new AtomBigInteger());
    }

    /**
     * Addresses sample tree.
     */
    @Test
    public void addressesSampleTree() {
        final Noun tree = new CellSimple(
            new CellSimple(
                new AtomBigInteger(4L),
                new AtomBigInteger(5L)
            ),
            new CellSimple(
                new AtomBigInteger(6L),
                new CellSimple(
                    new AtomBigInteger(14L),
                    new AtomBigInteger(15L)
                )
            )
        );
        MatcherAssert.assertThat(
            this.slot.apply(new AtomBigInteger(Slot.ROOT), tree).toString(),
            Matchers.is("[[4 5] [6 [14 15]]]")
        );
        MatcherAssert.assertThat(
            this.slot.apply(new AtomBigInteger(Slot.LEFT), tree).toString(),
            Matchers.is("[4 5]")
        );
        MatcherAssert.assertThat(
            this.slot.apply(new AtomBigInteger(Slot.RIGHT), tree).toString(),
            Matchers.is("[6 [14 15]]")
        );
        MatcherAssert.assertThat(
            // @checkstyle MagicNumberCheck (1 line)
            this.slot.apply(new AtomBigInteger(4L), tree).toString(),
            Matchers.is("4")
        );
        MatcherAssert.assertThat(
            // @checkstyle MagicNumberCheck (1 line)
            this.slot.apply(new AtomBigInteger(7L), tree).toString(),
            Matchers.is("[14 15]")
        );
    }

}
