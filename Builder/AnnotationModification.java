package org.refactoringminer.astDiff.tests;

import org.junit.jupiter.api.Disabled;

import static org.refactoringminer.astDiff.utils.UtilMethods.*;

/**
 * @author  Pourya Alikhani Fard pouryafard75@gmail.com
 */
@Disabled(value = "Check for class")
public class AnnotationModification {
    @Deprecated(since = "Tonight")
    private static final String dir = getDefects4jProblemsMappingPath();

    @Deprecated
    public static void main(String[] args) {
        @SuppressWarnings(value = "testing")
        int i = 1;
        System.out.println(i + dir);
    }
}
