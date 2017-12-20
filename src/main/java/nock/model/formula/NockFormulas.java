/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

/**
 * Nock formulas.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class NockFormulas implements Formulas {

    /**
     * Wrapped instance of {@link Formulas}.
     */
    private final Formulas formulas;

    /**
     * Ctor.
     */
    public NockFormulas() {
        this.formulas = NockFormulas.build();
    }

    @Override
    public Formula fromCell(final FormulaCell cell) {
        return this.formulas.fromCell(cell);
    }

    /**
     * Builds the formulas map.
     * @return Formulas
     */
    private static Formulas build() {
        final FormulasMap formulas = new FormulasMap();
        // @checkstyle MagicNumber (6 lines)
        return formulas
            .with(0L, new FormulaSourceTreeAddressing())
            .with(1L, new FormulaSourceConstant())
            .with(2L, new FormulaSourceEval(formulas))
            .with(3L, new FormulaSourceCellCheck(formulas))
            .with(4L, new FormulaSourceIncrement(formulas));
    }

}
