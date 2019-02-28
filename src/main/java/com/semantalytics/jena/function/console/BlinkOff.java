package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase0;

import static org.apache.jena.sparql.expr.NodeValue.*;
import static org.fusesource.jansi.Ansi.Attribute.*;
import static org.fusesource.jansi.Ansi.ansi;

public class BlinkOff extends FunctionBase0 {

    public static final String name = ConsoleVocabulary.blinkOff.stringValue();

    @Override
    public NodeValue exec() {
        return makeString(ansi().a(BLINK_OFF).toString());
    }
}
