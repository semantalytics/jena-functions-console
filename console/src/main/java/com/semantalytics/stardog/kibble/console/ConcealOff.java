package com.semantalytics.stardog.kibble.console;

import com.complexible.stardog.plan.filter.ExpressionEvaluationException;
import com.complexible.stardog.plan.filter.ExpressionVisitor;
import com.complexible.stardog.plan.filter.functions.AbstractFunction;
import com.complexible.stardog.plan.filter.functions.UserDefinedFunction;
import com.google.common.collect.Range;
import org.fusesource.jansi.Ansi;
import org.openrdf.model.Value;

import static com.complexible.common.rdf.model.Values.literal;
import static org.fusesource.jansi.Ansi.ansi;

public class ConcealOff extends AbstractFunction implements UserDefinedFunction {

    public ConcealOff() {
        super(0, "http://semantalytics.com/2017/11/ns/stardog/kibble/console/concealOff");
    }

    public ConcealOff(final ConcealOff conceal) {
        super(conceal);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
        return literal(ansi().a(Ansi.Attribute.CONCEAL_OFF).toString());
    }

    @Override
    public ConcealOff copy() {
        return new ConcealOff(this);
    }

    @Override
    public void accept(final ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String toString() {
        return "concealOff";
    }
}
