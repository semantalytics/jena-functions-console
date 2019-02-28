package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.function.FunctionBase;
import org.fusesource.jansi.Ansi;

import java.util.stream.Stream;

import static org.fusesource.jansi.Ansi.Attribute.*;
import static org.fusesource.jansi.Ansi.ansi;

public class StrikeThrough extends FunctionBase {

    public StrikeThrough() {
        super(Range.all(), ConsoleVocabulary.strikeThrough.stringValue());
    }

    public StrikeThrough(final StrikeThrough console) {
        super(console);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
        final Ansi ansi = ansi();
        ansi.a(STRIKETHROUGH_ON);

        Stream.of(values).forEach(v -> ansi.a(v.stringValue()));

        if(values.length != 0) {
            ansi.a(STRIKETHROUGH_OFF);
        }
        return literal(ansi.toString());
    }
}
