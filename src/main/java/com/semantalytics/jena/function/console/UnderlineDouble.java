package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase;
import org.fusesource.jansi.Ansi;

import java.util.stream.Stream;

import static org.fusesource.jansi.Ansi.ansi;

public class UnderlineDouble extends FunctionBase {

    public static final String name = ConsoleVocabulary.underlineDouble.stringValue());

    @Override
    public NodeValue exec(final NodeValue... args) {
        final Ansi ansi = ansi();
        ansi.a(Ansi.Attribute.UNDERLINE_DOUBLE);

        Stream.of(args).map(NodeValue::getString).forEach(ansi.a();

        if(values.length != 0) {
            ansi.a(Ansi.Attribute.UNDERLINE_OFF);
        }
        return literal(ansi.toString());
    }
}
