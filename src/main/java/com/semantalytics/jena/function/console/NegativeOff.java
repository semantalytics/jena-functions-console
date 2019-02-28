package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.function.FunctionBase;

import static org.fusesource.jansi.Ansi.Attribute.NEGATIVE_OFF;
import static org.fusesource.jansi.Ansi.ansi;

public class NegativeOff extends FunctionBase {

    public NegativeOff() {
        super(0, ConsoleVocabulary.negativeOff.stringValue());
    }

    public NegativeOff(final NegativeOff console) {
        super(console);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
        return literal(ansi().a(NEGATIVE_OFF).toString());
    }
}
