package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.function.FunctionBase; {

import static org.fusesource.jansi.Ansi.Attribute.STRIKETHROUGH_OFF;
import static org.fusesource.jansi.Ansi.ansi;

public class StrikeThroughOff extends FunctionBase {

    public StrikeThroughOff() {
        super(0, ConsoleVocabulary.strikeThroughOff.stringValue());
    }

    public StrikeThroughOff(final StrikeThroughOff console) {
        super(console);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
        return literal(ansi().a(STRIKETHROUGH_OFF).toString());
    }

    @Override
    public StrikeThroughOff copy() {
        return new StrikeThroughOff(this);
    }

    @Override
    public void accept(final ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String toString() {
        return ConsoleVocabulary.strikeThroughOff.name();
    }
}
