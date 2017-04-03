/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import java.util.function.Function;

/**
 * A Formula source. Produces a {@link Formula} from a {@link FormulaCell}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public interface FormulaSource extends Function<FormulaCell, Formula> {
}
