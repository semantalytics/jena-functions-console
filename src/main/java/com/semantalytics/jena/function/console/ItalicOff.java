package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.function.FunctionBase;
import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.ansi;

public class ItalicOff extends FunctionBase {

    public ItalicOff() {
        super(0, ConsoleVocabulary.italicOff.stringValue());
    }

    public ItalicOff(final ItalicOff italicOff) {
        super(italicOff);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
        return literal(ansi().a(Ansi.Attribute.ITALIC_OFF).toString());
    }
}
