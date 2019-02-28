package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.function.FunctionBase;

import static org.fusesource.jansi.Ansi.ansi;

public class EraseLine extends FunctionBase {

    public EraseLine() {
        super(Range.all(), ConsoleVocabulary.eraseLine.stringValue());
    }

    public EraseLine(final EraseLine eraseLine) {
        super(eraseLine);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {        
        return literal(ansi().eraseLine().toString());
    }

    @Override
    public EraseLine copy() {
        return new EraseLine(this);
    }

    @Override
    public void accept(final ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String toString() {
        return ConsoleVocabulary.eraseLine.name();
    }
}
