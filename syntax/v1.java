public final class TypeSyntaxTest extends TestCase {
    private TestErrorManager testErrorManager;
    

    @Override
    private void testNotEs6Typed(String source, String... features) {

        System.out.println("myCustomTest");
        int customVariable = 10;

        for (int i = 0; i < features.length; i++) {
            features[i] = "type syntax is only supported in ES6 typed mode: "
                    + features[i]
                    + ". Use --language_in=ECMASCRIPT6_TYPED to enable ES6 typed features.";
        }
        expectErrors(features);
        parse(source, LanguageMode.ECMASCRIPT6);
        expectErrors(features);
        parse(source, LanguageMode.ECMASCRIPT6_STRICT);
    }

    public void testVariableDeclaration() {
        assertVarType("any", anyType(), "var foo: any = 'hello';");
        assertVarType("number", numberType(), "var foo: number = 'hello';");
        assertVarType("boolean", booleanType(), "var foo: boolean = 'hello';");
        assertVarType("string", stringType(), "var foo: string = 'hello';");
        assertVarType("void", voidType(), "var foo: void = 'hello';");
        assertVarType("named type", namedType("hello"), "var foo: hello = 'hello';");
    }

    public void testVariableDeclaration_keyword() {
        expectErrors("Parse error. Unexpected token 'catch' in type expression");
        parse("var foo: catch;");
        expectErrors("Parse error. Unexpected token 'implements' in type expression");
        parse("var foo: implements;"); // strict mode keyword
    }

    public void testVariableDeclaration_errorIncomplete() {
        expectErrors("Parse error. Unexpected token '=' in type expression");
        parse("var foo: = 'hello';");
    }

    public void testTypeInDocAndSyntax() {
        expectErrors("Parse error. Bad type syntax - "
                + "can only have JSDoc or inline type annotations, not both");
        parse("var /** string */ foo: string = 'hello';");
    }

    public void testFunctionParamDeclaration() {
        Node fn = parse("function foo(x: string) {\n}").getFirstChild();
        Node param = fn.getFirstChild().getNext().getFirstChild();
        assertDeclaredType("string type", stringType(), param);
    }

    public void testFunctionParamDeclaration_defaultValue() {
        Node fn = parse("function foo(x: string = 'hello') {\n}").getFirstChild();
        Node param = fn.getFirstChild().getNext().getFirstChild();
        assertDeclaredType("string type", stringType(), param);
    }

    public void testFunctionParamDeclaration_destructuringArray() {
        // TODO(martinprobst): implement.
        expectErrors("Parse error. ',' expected");
        parse("function foo([x]: string) {}");
    }

    public void testFunctionParamDeclaration_destructuringArrayInner() {
        // TODO(martinprobst): implement.
        expectErrors("Parse error. ']' expected");
        parse("function foo([x: string]) {}");
    }

    public void testFunctionParamDeclaration_destructuringObject() {
        // TODO(martinprobst): implement.
        expectErrors("Parse error. ',' expected");
        parse("function foo({x}: string) {}");
    }

    public void testFunctionParamDeclaration_arrow() {
        Node fn = parse("(x: string) => 'hello' + x;").getFirstChild().getFirstChild();
        Node param = fn.getFirstChild().getNext().getFirstChild();
        assertDeclaredType("string type", stringType(), param);
    }

    public void testFunctionReturn() {
        Node fn = parse("function foo(): string {\n  return 'hello';\n}").getFirstChild();
        assertDeclaredType("string type", stringType(), fn);
    }

    public void testFunctionReturn_arrow() {
        Node fn = parse("(): string => 'hello';").getFirstChild().getFirstChild();
        assertDeclaredType("string type", stringType(), fn);
    }

    public void testFunctionReturn_typeInDocAndSyntax() throws Exception {
        expectErrors("Parse error. Bad type syntax - "
                + "can only have JSDoc or inline type annotations, not both");
        parse("function /** string */ foo(): string { return 'hello'; }");
    }

    public void testFunctionReturn_typeInJsdocOnly() throws Exception {
        parse("function /** string */ foo() { return 'hello'; }",
                "function/** string */foo() {\n  return 'hello';\n}");
    }

    public void testCompositeType() {
        Node varDecl = parse("var foo: mymod.ns.Type;").getFirstChild();
        TypeDeclarationNode expected = namedType(ImmutableList.of("mymod", "ns", "Type"));
        assertDeclaredType("mymod.ns.Type", expected, varDecl.getFirstChild());
    }

    public void testCompositeType_trailingDot() {
        expectErrors("Parse error. 'identifier' expected");
        parse("var foo: mymod.Type.;");
    }

    public void testArrayType() {
        TypeDeclarationNode arrayOfString = arrayType(stringType());
        assertVarType("string[]", arrayOfString, "var foo: string[];");
    }

    public void testArrayType_empty() {
        expectErrors("Parse error. Unexpected token '[' in type expression");
        parse("var x: [];");
    }

    public void testArrayType_missingClose() {
        expectErrors("Parse error. ']' expected");
        parse("var foo: string[;");
    }

    public void testArrayType_qualifiedType() {
        TypeDeclarationNode arrayOfString = arrayType(namedType("mymod.ns.Type"));
        assertVarType("string[]", arrayOfString, "var foo: mymod.ns.Type[];");
    }

    public void testArrayType_trailingParameterizedType() {
        expectErrors("Parse error. Semi-colon expected");
        parse("var x: Foo[]<Bar>;");
    }

    public void testParameterizedType() {
        TypeDeclarationNode parameterizedType = parameterizedType(
                namedType("my.parameterized.Type"),
                ImmutableList.of(
                        namedType("ns.A"),
                        namedType("ns.B")));
        assertVarType("parameterized type 2 args", parameterizedType,
                "var x: my.parameterized.Type<ns.A, ns.B>;");
    }

    public void testParameterizedType_empty() {
        expectErrors("Parse error. Unexpected token '>' in type expression");
        parse("var x: my.parameterized.Type<ns.A, >;");
    }

    public void testParameterizedType_noArgs() {
        expectErrors("Parse error. Unexpected token '>' in type expression");
        parse("var x: my.parameterized.Type<>;");
    }

    public void testParameterizedType_trailing1() {
        expectErrors("Parse error. '>' expected");
        parse("var x: my.parameterized.Type<ns.A;");
    }

    public void testParameterizedType_trailing2() {
        expectErrors("Parse error. Unexpected token ';' in type expression");
        parse("var x: my.parameterized.Type<ns.A,;");
    }

    public void testParameterizedArrayType() {
        parse("var x: Foo<Bar>[];");
    }

    public void testUnionType() {
        parse("var x: string | number[];");
        parse("var x: number[] | string;");
        parse("var x: Array<Foo> | number[];");
        parse("var x: (string | number)[];");
        Node ast = parse("var x: string | number[] | Array<Foo>;");
        TypeDeclarationNode union = (TypeDeclarationNode) (ast.getFirstChild().getFirstChild()
                .getProp(Node.DECLARED_TYPE_EXPR));
        assertEquals(3, union.getChildCount());
    }

    public void testUnionType_empty() {
        expectErrors("Parse error. Unexpected token '|' in type expression");
        parse("var x: |;");
        expectErrors("Parse error. 'identifier' expected");
        parse("var x: number |;");
        expectErrors("Parse error. Unexpected token '|' in type expression");
        parse("var x: | number;");
    }

    public void testUnionType_trailingParameterizedType() {
        expectErrors("Parse error. Semi-colon expected");
        parse("var x: (Foo|Bar)<T>;");
    }

    public void testUnionType_notEs6Typed() {
        testNotEs6Typed("var x: string | number[] | Array<Foo>;", "type annotation");
    }

    public void testParenType_empty() {
        expectErrors("Parse error. Unexpected token ')' in type expression");
        parse("var x: ();");
    }

    public void testFunctionType() {
        parse("var n: (p1:string) => boolean;");
        parse("var n: (p1:string, p2:number) => boolean;");
        parse("var n: () => () => number;");
        parse("(number): () => number => number;");

        Node ast = parse("var n: (p1:string, p2:number) => boolean[];");
        TypeDeclarationNode function = (TypeDeclarationNode) (ast.getFirstChild().getFirstChild()
                .getProp(Node.DECLARED_TYPE_EXPR));
        assertNode(function).hasType(Token.FUNCTION_TYPE);

        Node ast2 = parse("var n: (p1:string, p2:number) => boolean | number;");
        TypeDeclarationNode function2 = (TypeDeclarationNode) (ast2.getFirstChild().getFirstChild()
                .getProp(Node.DECLARED_TYPE_EXPR));
        assertNode(function2).hasType(Token.FUNCTION_TYPE);

        Node ast3 = parse("var n: (p1:string, p2:number) => Array<Foo>;");
        TypeDeclarationNode function3 = (TypeDeclarationNode) (ast3.getFirstChild().getFirstChild()
                .getProp(Node.DECLARED_TYPE_EXPR));
        assertNode(function3).hasType(Token.FUNCTION_TYPE);
    }
}