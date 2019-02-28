package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.function.FunctionBase;

import static org.fusesource.jansi.Ansi.ansi;

public class Reset extends FunctionBase {

    public Reset() {
        super(0, ConsoleVocabulary.reset.stringValue());
    }

    public Reset(final Reset reset) {
        super(reset);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
        return literal(ansi().reset().toString());
    }
}
