package com.semantalytics.stardog.plan.filter.functions.strings;

import com.complexible.common.rdf.model.Values;
import com.complexible.stardog.plan.filter.ExpressionEvaluationException;
import com.complexible.stardog.plan.filter.ExpressionVisitor;
import com.complexible.stardog.plan.filter.functions.AbstractFunction;
import com.complexible.stardog.plan.filter.functions.string.StringFunction;
import org.apache.commons.lang3.StringUtils;
import org.openrdf.model.Value;

public final class CompareIgnoreCase extends AbstractFunction implements StringFunction {

    protected CompareIgnoreCase() {
        super(2, StringsVocab.ontology().compareIgnoreCase.toString());
    }

    private CompareIgnoreCase(final CompareIgnoreCase compareIgnoreCase) {
        super(compareIgnoreCase);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {

        final String string1 = assertStringLiteral(values[0]).stringValue();
        final String string2= assertIntegerLiteral(values[1]).stringValue();

        return Values.literal(StringUtils.compareIgnoreCase(string1, string2));
    }

    @Override
    public CompareIgnoreCase copy() {
        return new CompareIgnoreCase(this);
    }

    @Override
    public void accept(final ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String toString() {
        return "Abbreviate a String using ellipses";
    }
}