/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.parser;

import java.util.stream.Stream;
import nock.model.Cell;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for {@link SimpleNockParser}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class SimpleNockParserTest {

    /**
     * Expected exception rule.
     */
    @Rule
    public final ExpectedException error = ExpectedException.none();

    /**
     * Fails on no valid noun.
     */
    @Test
    public void failsOnNoValidNoun() {
        this.error.expect(IllegalStateException.class);
        this.error.expectMessage("No valid noun found.");
        new SimpleNockParser(" ").parse();
    }

    /**
     * Fails on unexpected character.
     */
    @Test
    public void failsOnUnexpectedCharacter() {
        this.error.expect(IllegalStateException.class);
        this.error.expectMessage("Unexpected character w at position 4.");
        new SimpleNockParser("[ 2 w ]").parse();
    }

    /**
     * Fails on unexpected character after a cell's right noun.
     */
    @Test
    public void failsOnUnexpectedCharacterAfterCellRight() {
        this.error.expect(IllegalStateException.class);
        this.error.expectMessage("Unexpected character x at position 6.");
        new SimpleNockParser("[ 2 2 x ]").parse();
    }

    /**
     * Parses simple atoms.
     */
    @Test
    public void parsesSimpleAtoms() {
        // @checkstyle MagicNumberCheck (1 lines)
        Stream.of(0L, 1L, 106L, 1234567L).forEach(
            value -> MatcherAssert.assertThat(
                new SimpleNockParser(String.valueOf(value)).parse()
                    .asAtom().asLong(),
                Matchers.is(value)
            )
        );
    }

    /**
     * Parses simple cells of atoms atoms.
     */
    @Test
    public void parsesSimpleCellsOfAtoms() {
        // @checkstyle MagicNumberCheck (1 lines)
        Stream.of(0L, 1L, 106L, 1234567L).forEach(
            value -> {
                final long right = value + 10L;
                final Cell<?, ?> cell = new SimpleNockParser(
                    String.format("[%s %s]", value, right)
                ).parse().asCell();
                MatcherAssert.assertThat(
                    cell.leftAtom().asLong(),
                    Matchers.is(value)
                );
                MatcherAssert.assertThat(
                    cell.rightAtom().asLong(),
                    Matchers.is(right)
                );
            }
        );
    }

    /**
     * Parses a simple tree.
     */
    @Test
    public void parsesSimpleTree() {
        final String input = "[[4 5] [6 [14 15]]]";
        MatcherAssert.assertThat(
            new SimpleNockParser(input).parse().toString(),
            Matchers.is(input)
        );
    }

    /**
     * Parses a simple tree.
     */
    @Test
    public void parsesSimpleTreeIgnoringWhitespace() {
        final String input = "  [[ 4   5] [ 7   [14   15  ]]]  ";
        MatcherAssert.assertThat(
            new SimpleNockParser(input).parse().toString(),
            Matchers.is("[[4 5] [7 [14 15]]]")
        );
    }

}
