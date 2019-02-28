package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.function.FunctionBase;
import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.Color;
import static org.fusesource.jansi.Ansi.ansi;

public class ForegroundDefault extends FunctionBase {

    public ForegroundDefault() {
        super(0, ConsoleVocabulary.foregroundDefault.stringValue());
    }

    public ForegroundDefault(final ForegroundDefault foreground) {
        super(foreground);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
        final Ansi ansi = ansi();
        ansi.fg(Color.DEFAULT);
        return literal(ansi.toString());
    }

    @Override
    public ForegroundDefault copy() {
        return new ForegroundDefault(this);
    }

    @Override
    public void accept(final ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String toString() {
        return ConsoleVocabulary.foregroundDefault.name();
    }
}
