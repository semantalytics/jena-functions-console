package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.function.FunctionBase;
import org.fusesource.jansi.Ansi;

import java.util.stream.Stream;

import static org.fusesource.jansi.Ansi.Color;
import static org.fusesource.jansi.Ansi.ansi;

public class ForegroundCyan extends FunctionBase {

    public ForegroundCyan() {
        super(Range.all(), ConsoleVocabulary.foregroundCyan.stringValue());
    }

    public ForegroundCyan(final ForegroundCyan foreground) {
        super(foreground);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
        final Ansi ansi = ansi();
        ansi.bg(Color.CYAN);

        Stream.of(values).forEach(v -> ansi.a(v.stringValue()));

        if(values.length != 0) {
            ansi.bg(Color.DEFAULT);
        }
        return literal(ansi.toString());
    }

    @Override
    public ForegroundCyan copy() {
        return new ForegroundCyan(this);
    }

    @Override
    public void accept(final ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String toString() {
        return ConsoleVocabulary.backgroundCyan.name();
    }
}
