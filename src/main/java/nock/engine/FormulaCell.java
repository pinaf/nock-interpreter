/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.engine;

import nock.model.Noun;

/**
 * A Formula cell.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @param <T> Formula's body's noun type
 * @since 1.0.0
 */
public interface FormulaCell<T extends Noun> {

    /**
     * This formula's opcode.
     * @return Opcode
     */
    long opcode();

    /**
     * This formula's body.
     * @return Body
     */
    T body();

}
