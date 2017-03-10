/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.operator;

import java.math.BigInteger;
import nock.model.Atom;
import nock.model.Noun;

/**
 * Simple implementation of {@link Slot}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class SlotSimple implements Slot {

    @Override
    public Noun apply(final Atom atom, final Noun noun) {
        final BigInteger value = atom.value();
        if (BigInteger.ZERO.compareTo(value) == 0) {
            throw new IllegalArgumentException(
                "Slot operator not defined for the atom 0."
            );
        }
        return this.apply(value, noun);
    }

    /**
     * Applies the slot operator.
     * @param value Atom's value
     * @param noun Input noun
     * @return Resulting noun
     */
    private Noun apply(final BigInteger value, final Noun noun) {
        final Noun result;
        if (BigInteger.ONE.compareTo(value) == 0) {
            result = noun;
        } else if (BigInteger.valueOf(Slot.LEFT).compareTo(value) == 0) {
            result = SlotSimple.left(noun);
        } else if (BigInteger.valueOf(Slot.RIGHT).compareTo(value) == 0) {
            result = SlotSimple.right(noun);
        } else {
            if (value.testBit(0)) {
                result = this.apply(
                    BigInteger.valueOf(Slot.RIGHT),
                    this.apply(
                        value.subtract(BigInteger.ONE).shiftRight(1),
                        noun
                    )
                );
            } else {
                result = this.apply(
                    BigInteger.valueOf(Slot.LEFT),
                    this.apply(value.shiftRight(1), noun)
                );
            }
        }
        return result;
    }

    /**
     * Retrieves the Left Node.
     * @param noun Input cell
     * @return Left Node
     */
    private static Noun left(final Noun noun) {
        if (noun.isAtom()) {
            throw new IllegalArgumentException("/2 not defined for atoms.");
        }
        return noun.asCell().left();
    }

    /**
     * Retrieves the Right Node.
     * @param noun Input cell
     * @return Right Node
     */
    private static Noun right(final Noun noun) {
        if (noun.isAtom()) {
            throw new IllegalArgumentException("/3 not defined for atoms.");
        }
        return noun.asCell().right();
    }

}
