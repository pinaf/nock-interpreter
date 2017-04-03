/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.engine;

import nock.model.Noun;
import nock.model.formula.FormulaSourceTreeAddressing;
import nock.model.formula.Formulas;
import nock.model.formula.FormulasMap;
import nock.model.formula.SubjectFormulaCell;

/**
 * Nock {@link Engine}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class NockEngine implements Engine {

    /**
     * Formulas.
     */
    private final Formulas formulas;

    /**
     * Ctor.
     */
    public NockEngine() {
        this(
            new FormulasMap(
                new FormulasMap.OpCodeFormulaSourcePair(
                    0L, new FormulaSourceTreeAddressing()
                )
            )
        );
    }

    /**
     * Ctor.
     * @param formulas Formulas
     */
    public NockEngine(final Formulas formulas) {
        this.formulas = formulas;
    }

    @Override
    public Noun compute(final Noun noun) {
        if (noun.isAtom()) {
            throw new IllegalArgumentException("nock(atom) is an error!");
        }
        final SubjectFormulaCell cell = new SubjectFormulaCell(noun.asCell());
        return this.formulas.fromCell(cell.formula()).compute(cell.subject());
    }

}
