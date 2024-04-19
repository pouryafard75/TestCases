public record SemanticViolationRecord(
        String parentTypesPair,
        String first,
        String second,
        String url,
        String filename) {
}
