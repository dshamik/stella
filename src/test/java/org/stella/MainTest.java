package org.stella;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class MainTest {


    @ParameterizedTest(name = "{index} Typechecking well-typed program {0}")
    @ValueSource(strings = {
            "tests/core/well-typed/factorial.stella",
            "tests/core/well-typed/squares.stella",
            "tests/core/well-typed/higher-order-1.stella",
            "tests/core/well-typed/increment_twice.stella",
            "tests/core/well-typed/logical-operators.stella",
            "tests/pairs/well-typed/pairs-1.stella",
            "tests/tuples/well-typed/tuples-1.stella",
            "tests/sum-types/well-typed/sum-types-1.stella",
            "tests/sum-types/well-typed/sum-types-2.stella",
            "tests/records/well-typed/records-1.stella",
            "tests/subtyping/well-typed/subtyping-1.stella",
            "tests/subtyping/well-typed/subtyping-3.stella",
            "tests/subtyping/well-typed/subtyping-5.stella",
            "tests/subtyping/well-typed/subtyping-2.stella",
            "tests/subtyping/well-typed/subtyping-6.stella",
            "tests/subtyping/well-typed/subtyping-4.stella",
            "tests/universal-types/well-typed/universal-types-1.stella",
            "tests/universal-types/well-typed/universal-types-2.stella",
            "tests/universal-types/well-typed/universal-types-3.stella",
            "tests/universal-types/well-typed/universal-types-4.stella",
            "tests/universal-types/well-typed/universal-types-5.stella",
            "tests/universal-types/well-typed/universal-types-6.stella"})
    void testWellTyped(String filepath) throws Exception {
        String[] args = new String[0];
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(filepath);
        System.setIn(fips);
        Assertions.assertDoesNotThrow(() -> Main.main(args));
        System.setIn(original);
    }

    @ParameterizedTest(name = "{index} Typechecking ill-typed program {0}")
    @ValueSource(strings = {
            "tests/core/ill-typed/applying-non-function-1.stella",
            "tests/core/ill-typed/applying-non-function-2.stella",
            "tests/core/ill-typed/applying-non-function-3.stella",
            "tests/core/ill-typed/argument-type-mismatch-1.stella",
            "tests/core/ill-typed/argument-type-mismatch-2.stella",
            "tests/core/ill-typed/argument-type-mismatch-3.stella",
            "tests/core/ill-typed/bad-if-1.stella",
            "tests/core/ill-typed/bad-if-2.stella",
            "tests/core/ill-typed/bad-if-3.stella",
            "tests/core/ill-typed/bad-if-4.stella",
            "tests/core/ill-typed/bad-succ-1.stella",
            "tests/core/ill-typed/bad-succ-2.stella",
            "tests/core/ill-typed/bad-succ-3.stella",
            "tests/core/ill-typed/shadowed-variable-1.stella",
            "tests/core/ill-typed/undefined-variable-1.stella",
            "tests/core/ill-typed/undefined-variable-2.stella",
            "tests/core/ill-typed/bad-squares-1.stella",
            "tests/core/ill-typed/bad-squares-2.stella",
            "tests/pairs/ill-typed/bad-pairs-1.stella",
            "tests/tuples/ill-typed/bad-tuples-1.stella",
            "tests/sum-types/ill-typed/bad-sum-types-1.stella",
            "tests/records/ill-typed/bad-records-1.stella",
            "tests/subtyping/ill-typed/bad-subtyping-1.stella",
            "tests/subtyping/ill-typed/bad-subtyping-2.stella",
            "tests/subtyping/ill-typed/bad-subtyping-3.stella",
            "tests/universal-types/ill-typed/bad-universal-types-1.stella",
            "tests/universal-types/ill-typed/bad-universal-types-2.stella",
            "tests/universal-types/ill-typed/bad-universal-types-3.stella",
            "tests/universal-types/ill-typed/bad-universal-types-4.stella",
            "tests/universal-types/ill-typed/bad-universal-types-5.stella",
            "tests/universal-types/ill-typed/bad-universal-types-6.stella"})
    void testIllTyped(String filepath) throws Exception {
        String[] args = new String[0];
        final FileInputStream fips = new FileInputStream(filepath);
        System.setIn(fips);

        // Change Exception class to your specific
        Exception exception = assertThrows(Exception.class, () -> Main.main(args), "Expected the type checker to fail!");
        System.out.println("Type Error: " + exception.getMessage());
    }
}
