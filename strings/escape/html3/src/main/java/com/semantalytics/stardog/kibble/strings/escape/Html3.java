package com.semantalytics.stardog.kibble.string.escape;

import com.complexible.stardog.plan.filter.ExpressionEvaluationException;
import com.complexible.stardog.plan.filter.ExpressionVisitor;
import com.complexible.stardog.plan.filter.functions.AbstractFunction;
import com.complexible.stardog.plan.filter.functions.string.StringFunction;
import com.semantalytics.stardog.kibble.strings.escape.EscapeVocabulary;
import org.apache.commons.text.StringEscapeUtils;
import org.openrdf.model.Value;

import static com.complexible.common.rdf.model.Values.literal;

public final class Html3 extends AbstractFunction implements StringFunction {

    protected Html3() {
        super(1, EscapeVocabulary.csv.stringValue());
    }

    private Html3(final Html3 html3) {
        super(html3);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {

        final String string = assertStringLiteral(values[0]).stringValue();

        return literal(StringEscapeUtils.escapeHtml3(string));
    }

    @Override
    public Html3 copy() {
        return new Html3(this);
    }

    @Override
    public void accept(final ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String toString() {
        return EscapeVocabulary.csv.name();
    }
}
