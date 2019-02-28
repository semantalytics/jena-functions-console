package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.function.FunctionBase;
import org.fusesource.jansi.Ansi;

import java.util.stream.Stream;

import static org.fusesource.jansi.Ansi.ansi;

public class Underline extends FunctionBase {

    public Underline() {
        super(Range.all(), ConsoleVocabulary.underline.stringValue());
    }

    public Underline(final Underline console) {
        super(console);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
        final Ansi ansi = ansi();
        ansi.a(Ansi.Attribute.UNDERLINE);

        Stream.of(values).forEach(v -> ansi.a(v.stringValue()));

        if(values.length != 0) {
            ansi.a(Ansi.Attribute.UNDERLINE_OFF);
        }
        return literal(ansi.toString());
    }
}
