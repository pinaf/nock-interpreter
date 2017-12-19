/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.engine;

import nock.model.Cell;
import nock.model.CellSimple;
import nock.model.Noun;
import nock.model.formula.FormulaSourceConstant;
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
                ),
                new FormulasMap.OpCodeFormulaSourcePair(
                    1L, new FormulaSourceConstant()
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
        final Cell<? extends Noun, ? extends Noun> cell = noun.asCell();
        return this.compute(cell.left(), cell.rightCell());
    }

    @Override
    public Noun compute(final Noun subject, final Noun head,
        final Noun... tail) {
        Noun result = this.compute(new CellSimple<>(subject, head));
        for (final Noun formula : tail) {
            result = this.compute(result, formula);
        }
        return result;
    }

    /**
     * Computes a formula on a subject.
     * @param subject Subject
     * @param formula Formula
     * @return Product
     */
    private Noun compute(final Noun subject, final Noun formula) {
        final SubjectFormulaCell cell =
            new SubjectFormulaCell(subject, formula);
        return this.formulas.fromCell(cell.formula()).compute(cell.subject());
    }

}
