package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.function.FunctionBase;
import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.ansi;

public class ConcealOff extends FunctionBase {

    public ConcealOff() {
        super(0, ConsoleVocabulary.concealOff.stringValue());
    }

    public ConcealOff(final ConcealOff conceal) {
        super(conceal);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
        return literal(ansi().a(Ansi.Attribute.CONCEAL_OFF).toString());
    }

    @Override
    public ConcealOff copy() {
        return new ConcealOff(this);
    }

    @Override
    public void accept(final ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String toString() {
        return ConsoleVocabulary.concealOff.name();
    }
}
