package com.semantalytics.stardog.kibble.string.escape;

import com.complexible.stardog.plan.filter.ExpressionEvaluationException;
import com.complexible.stardog.plan.filter.ExpressionVisitor;
import com.complexible.stardog.plan.filter.functions.AbstractFunction;
import com.complexible.stardog.plan.filter.functions.string.StringFunction;
import com.semantalytics.stardog.kibble.strings.escape.EscapeVocabulary;
import org.apache.commons.text.StringEscapeUtils;
import org.openrdf.model.Value;

import static com.complexible.common.rdf.model.Values.literal;

public final class Csv extends AbstractFunction implements StringFunction {

    protected Csv() {
        super(1, EscapeVocabulary.csv.stringValue());
    }

    private Csv(final Csv csv) {
        super(csv);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {

        final String string = assertStringLiteral(values[0]).stringValue();

        return literal(StringEscapeUtils.escapeCsv(string));
    }

    @Override
    public Csv copy() {
        return new Csv(this);
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
