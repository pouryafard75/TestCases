package org.refactoringminer.astDiff.tests;

import org.junit.jupiter.api.Disabled;

import static org.refactoringminer.astDiff.utils.UtilMethods.*;

/**
 * @author  Pourya Alikhani Fard pouryafard75@gmail.com
 */
@Disabled(value = "Check for class modification")
public class AnnotationModification {
    @SuppressWarnings(value = "testing")
    @Deprecated(since = "Tonight but not tomorrow")
    private static final String dir = getDefects4jProblemsMappingPath();

    @Deprecated(since = "Tonight but not tomorrow")
    public static void main(String[] args) {
        @SuppressWarnings(value = "testing for fun")
        @Deprecated(since = "Tonight but not tomorrow")
        int i = 1;
        System.out.println(i + dir);
    }
}
