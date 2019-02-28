package com.semantalytics.jena.function.console;


import org.apache.jena.sparql.function.FunctionBase;

import static org.fusesource.jansi.Ansi.ansi;

public class Render extends FunctionBase {

    public Render() {
        super(1, ConsoleVocabulary.render.stringValue());
    }

    public Render(final Render render) {
        super(render);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
        final String text = assertStringLiteral(values[0]).stringValue();
        return literal(ansi().render(text).toString());
    }
}
