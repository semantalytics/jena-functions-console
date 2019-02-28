package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase0;

import static org.apache.jena.sparql.expr.NodeValue.*;
import static org.fusesource.jansi.Ansi.Attribute.*;
import static org.fusesource.jansi.Ansi.ansi;

public class UnderlineOff extends FunctionBase0 {

    public static final String name = ConsoleVocabulary.underlineOff.stringValue();

    @Override
    public NodeValue exec() {
        return makeString(ansi().a(UNDERLINE_OFF).toString());
    }
}
