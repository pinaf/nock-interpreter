/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model.formula;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * A map-backed implementation of {@link Formulas}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class FormulasMap implements Formulas {

    /**
     * Map of formula sources, by opcode.
     */
    private final Map<Long, FormulaSource> formulas;

    /**
     * Ctor.
     * @param formulas Opcode -> Formula source mappings
     */
    public FormulasMap(final FormulasMap.OpCodeFormulaSourcePair... formulas) {
        this(
            Arrays.stream(formulas).collect(
                Collectors.toMap(
                    FormulasMap.OpCodeFormulaSourcePair::opcode,
                    FormulasMap.OpCodeFormulaSourcePair::source
                )
            )
        );
    }

    /**
     * Ctor.
     * @param formulas Opcode -> Formula source mappings
     */
    public FormulasMap(final Map<Long, FormulaSource> formulas) {
        this.formulas = new HashMap<>(formulas);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public Formula fromCell(
        final FormulaCell cell) {
        return Optional
            .ofNullable(this.formulas.get(cell.opcode()))
            .map(source -> source.apply(cell))
            .orElseThrow(
                () -> new IllegalStateException(
                    String.format("Unknown opcode: %d", cell.opcode())
                )
            );
    }

    /**
     * Pair of (Opcode, FormulaSource).
     */
    @SuppressWarnings("PMD.AvoidFieldNameMatchingMethodName")
    public static final class OpCodeFormulaSourcePair {

        /**
         * Opcode.
         */
        private final long opcode;

        /**
         * Formula source.
         */
        private final FormulaSource source;

        /**
         * Ctor.
         * @param opcode Opcode
         * @param source Formula source
         */
        public OpCodeFormulaSourcePair(final long opcode,
            final FormulaSource source) {
            this.opcode = opcode;
            this.source = source;
        }

        /**
         * Opcode.
         * @return Opcode
         */
        public long opcode() {
            return this.opcode;
        }

        /**
         * Formula source.
         * @return Formula source
         */
        public FormulaSource source() {
            return this.source;
        }

    }

}
