package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.function.FunctionBase;
import org.fusesource.jansi.Ansi;

import java.util.stream.Stream;
import static org.fusesource.jansi.Ansi.Attribute.*;
import static org.fusesource.jansi.Ansi.ansi;

public class BlinkFast extends FunctionBase {

    public BlinkFast() {
        super(Range.all(), ConsoleVocabulary.blinkFast.stringValue());
    }

    public BlinkFast(final BlinkFast console) {
        super(console);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
        final Ansi ansi = ansi();
        ansi.a(BLINK_FAST);

        Stream.of(values).forEach(v -> ansi.a(v.stringValue()));

        if(values.length != 0) {
            ansi.a(BLINK_OFF);
        }
        return literal(ansi.toString());
    }

    @Override
    public BlinkFast copy() {
        return new BlinkFast(this);
    }

    @Override
    public void accept(final ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String toString() {
        return ConsoleVocabulary.blinkFast.name();
    }
}
