/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.parser;

import nock.model.Noun;

/**
 * Nock parser.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface NockParser {

    /**
     * Parses the input.
     * @return Parsed noun
     */
    Noun parse();

}
