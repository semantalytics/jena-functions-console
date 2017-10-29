package com.semantalytics.stardog.kibble.strings.comparison;

import com.complexible.stardog.plan.filter.ExpressionEvaluationException;
import com.complexible.stardog.plan.filter.ExpressionVisitor;
import com.complexible.stardog.plan.filter.functions.AbstractFunction;
import com.complexible.stardog.plan.filter.functions.Function;
import com.complexible.stardog.plan.filter.functions.string.StringFunction;
import com.google.common.collect.Range;
import org.openrdf.model.Value;

import static com.complexible.common.rdf.model.Values.literal;

public final class JaroWinklerSimilarity extends AbstractFunction implements StringFunction {

    private info.debatty.java.stringsimilarity.JaroWinkler jaroWinkler;
    private char similarityOrDistance = 's';

    protected JaroWinklerSimilarity() {
        super(Range.closed(2, 3), StringComparisonVocabulary.jaroWinklerSimilarity.stringValue());
    }

    private JaroWinklerSimilarity(final JaroWinklerSimilarity jaroWinklerSimilarity) {
        super(jaroWinklerSimilarity);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {

        final String firstString = assertStringLiteral(values[0]).stringValue();
        final String secondString = assertStringLiteral(values[1]).stringValue();

        if(values.length == 3) {
            final double threshold = assertNumericLiteral(values[3]).doubleValue();
            jaroWinkler = new info.debatty.java.stringsimilarity.JaroWinkler(threshold);
        } else {
            jaroWinkler = new info.debatty.java.stringsimilarity.JaroWinkler();
        }

        return literal(jaroWinkler.similarity(firstString, secondString));
    }

    public Function copy() {
        return new JaroWinklerSimilarity(this);
    }

    public void accept(final ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String toString() {
        return StringComparisonVocabulary.jaroWinklerSimilarity.name();
    }
}
