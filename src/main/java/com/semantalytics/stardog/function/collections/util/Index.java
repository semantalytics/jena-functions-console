package com.semantalytics.stardog.function.collections.util;

import com.complexible.common.rdf.model.Values;
import com.complexible.stardog.plan.eval.operator.update.AddOperator;
import com.complexible.stardog.plan.filter.ExpressionEvaluationException;
import com.complexible.stardog.plan.filter.ExpressionVisitor;
import com.complexible.stardog.plan.filter.functions.AbstractFunction;
import com.complexible.stardog.plan.filter.functions.Function;
import com.complexible.stardog.plan.filter.functions.UserDefinedFunction;
import com.complexible.stardog.plan.filter.functions.numeric.Add;
import org.openrdf.model.Value;

public final class Index extends AbstractFunction implements UserDefinedFunction {

    private Value index;
    private final Add add = new Add();

    public Index() {
        super(0, "http://semantalytics.com/2016/03/ns/stardog/udf/util/index");
    }

    private Index(Index index) {
        super(index);
        this.index = index.index;
    }

    @Override
    public void initialize() {
        index = Values.literal(0);
    }

    @Override
    protected Value internalEvaluate(final Value... values) throws ExpressionEvaluationException {
        final Value value = index;
        index = add.evaluate(index, Values.literal(1));
        return value;
    }

    @Override
    public Function copy() {
        return new Index(this);
    }

    @Override
    public void accept(final ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String toString() {
        return "Index";
    }
}
