package com.semantalytics.jena.function.console;

import org.apache.jena.sparql.function.FunctionBase;
import org.fusesource.jansi.Ansi;

import java.util.stream.Stream;

import static org.fusesource.jansi.Ansi.*;

public class Console extends FunctionBase {

        public Console() {
            super(Range.all(), ConsoleVocabulary.console.stringValue());
        }

        public Console(final Console console) {
            super(console);
        }

        @Override
        protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
            final Ansi ansi = ansi();

            Stream.of(values).forEach(v -> ansi.a(v.stringValue()));

            return literal(ansi.reset().toString());
        }

        @Override
        public Console copy() {
            return new Console(this);
        }

        @Override
        public void accept(final ExpressionVisitor expressionVisitor) {
            expressionVisitor.visit(this);
        }

        @Override
        public String toString() {
            return ConsoleVocabulary.console.name();
        }
}
