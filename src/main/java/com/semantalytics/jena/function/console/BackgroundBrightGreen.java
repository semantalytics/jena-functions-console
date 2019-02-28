package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.function.FunctionBase;
import org.fusesource.jansi.Ansi;

import java.util.stream.Stream;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.Color.DEFAULT;
import static org.fusesource.jansi.Ansi.ansi;

public class BackgroundBrightGreen extends FunctionBase {

    public BackgroundBrightGreen() {
        super(Range.all(), ConsoleVocabulary.backgroundBrightGreen.stringValue());
    }

    public BackgroundBrightGreen(final BackgroundBrightGreen console) {
        super(console);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
        final Ansi ansi = ansi();
        ansi.bgBright(GREEN);

        Stream.of(values).forEach(v -> ansi.a(v.stringValue()));

        if(values.length != 0) {
            ansi.bgBright(DEFAULT);
        }
        return literal(ansi.toString());
    }

    @Override
    public BackgroundBrightGreen copy() {
        return new BackgroundBrightGreen(this);
    }

    @Override
    public void accept(final ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String toString() {
        return ConsoleVocabulary.backgroundBrightGreen.name();
    }
}
