/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import nock.model.Noun;

/**
 * A Formula cell.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public interface FormulaCell {

    /**
     * This formula's opcode.
     * @return Opcode
     */
    long opcode();

    /**
     * This formula's body.
     * @return Body
     */
    Noun body();

}
