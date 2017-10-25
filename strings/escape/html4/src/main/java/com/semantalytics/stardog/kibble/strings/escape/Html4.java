package com.semantalytics.stardog.kibble.strings.escape;

import com.complexible.stardog.plan.filter.ExpressionEvaluationException;
import com.complexible.stardog.plan.filter.ExpressionVisitor;
import com.complexible.stardog.plan.filter.functions.AbstractFunction;
import com.complexible.stardog.plan.filter.functions.string.StringFunction;
import org.apache.commons.text.StringEscapeUtils;
import org.openrdf.model.Value;

import static com.complexible.common.rdf.model.Values.literal;

public final class Html4 extends AbstractFunction implements StringFunction {

    protected Html4() {
        super(1, EscapeVocabulary.csv.stringValue());
    }

    private Html4(final Html4 html4) {
        super(html4);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {

        final String string = assertStringLiteral(values[0]).stringValue();

        return literal(StringEscapeUtils.escapeHtml4(string));
    }

    @Override
    public Html4 copy() {
        return new Html4(this);
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
