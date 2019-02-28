package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.function.FunctionBase;

import static org.fusesource.jansi.Ansi.ansi;

public class EraseScreen extends FunctionBase {

    public EraseScreen() {
        super(Range.all(), ConsoleVocabulary.eraseScreen.stringValue());
    }

    public EraseScreen(final EraseScreen eraseScreen) {
        super(eraseScreen);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {        
        return literal(ansi().eraseScreen().toString());
    }

    @Override
    public EraseScreen copy() {
        return new EraseScreen(this);
    }

    @Override
    public void accept(final ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String toString() {
        return ConsoleVocabulary.eraseScreen.name();
    }
}
