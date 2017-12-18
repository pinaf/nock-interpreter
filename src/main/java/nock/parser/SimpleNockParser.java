/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.parser;

import java.util.Optional;
import nock.model.AtomBigInteger;
import nock.model.CellSimple;
import nock.model.Noun;

/**
 * Simple {@link NockParser}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class SimpleNockParser implements NockParser {

    /**
     * Start of cell.
     */
    private static final char START_CELL = '[';

    /**
     * End of cell.
     */
    private static final char END_CELL = ']';

    /**
     * White space.
     */
    private static final char WHITESPACE = ' ';

    /**
     * Input string.
     */
    private final CharSequence input;

    /**
     * Length of input string.
     */
    private final int length;

    /**
     * Head of character reader.
     */
    private int head;

    /**
     * Ctor.
     * @param input Input string.
     */
    public SimpleNockParser(final CharSequence input) {
        this.input = input;
        this.length = this.input.length();
        this.head = 0;
    }

    @Override
    public Noun parse() {
        Optional<Noun> noun = Optional.empty();
        do {
            final char current = this.input.charAt(this.head);
            if (current == SimpleNockParser.WHITESPACE) {
                this.head += 1;
            } else if (current == SimpleNockParser.START_CELL) {
                noun = Optional.of(this.parseCell());
                break;
            } else {
                if (current >= '0' && current <= '9') {
                    noun = Optional.of(this.parseAtom());
                    break;
                } else {
                    throw new IllegalStateException(
                        this.unexpectedCharacter(current)
                    );
                }
            }
        } while (this.head < this.length);
        return noun.orElseThrow(
            () -> new IllegalStateException("No valid noun found.")
        );
    }

    /**
     * Parses a single cell.
     * @return Cell
     */
    @SuppressWarnings("PMD.PrematureDeclaration")
    private Noun parseCell() {
        this.head += 1;
        final Noun cell = new CellSimple<>(this.parse(), this.parse());
        do {
            final char current = this.input.charAt(this.head);
            if (current == SimpleNockParser.WHITESPACE) {
                this.head += 1;
            } else if (current == SimpleNockParser.END_CELL) {
                this.head += 1;
                break;
            } else {
                throw new IllegalStateException(
                    this.unexpectedCharacter(current)
                );
            }
        } while (this.head < this.length);
        return cell;
    }

    /**
     * Parses a single atom.
     * @return Atom
     */
    private Noun parseAtom() {
        final int start = this.head;
        do {
            final char current = this.input.charAt(this.head);
            if (current < '0' || current > '9') {
                break;
            }
            this.head += 1;
        } while (this.head < this.length);
        return new AtomBigInteger(this.input.subSequence(start, this.head));
    }

    /**
     * Returns an unexpected character error message.
     * @param character Character
     * @return Message
     */
    private String unexpectedCharacter(final char character) {
        return String.format(
            "Unexpected character %c at position %d.",
            character, this.head
        );
    }

}
