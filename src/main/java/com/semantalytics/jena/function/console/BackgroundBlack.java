package com.semantalytics.jena.function.console;

import org.apache.jena.atlas.lib.Lib;
import org.apache.jena.query.QueryBuildException;
import org.apache.jena.sparql.ARQInternalErrorException;
import org.apache.jena.sparql.expr.Expr;
import org.apache.jena.sparql.expr.ExprList;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase;
import org.fusesource.jansi.Ansi;

import java.util.List;

import static org.apache.jena.sparql.expr.NodeValue.*;
import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class BackgroundBlack extends FunctionBase {

    public static final String name = ConsoleVocabulary.backgroundBlack.stringValue();

    @Override
    public NodeValue exec(final List<NodeValue> args) {

        if ( args == null )
            // The contract on the function interface is that this should not happen.
            throw new ARQInternalErrorException(Lib.className(this) + ": Null args list") ;

        if(args.stream().allMatch(NodeValue::isString))
            throw new QueryBuildException("Function '" + Lib.className(this) + "' all arguments must be strings") ;

        final Ansi ansi = ansi();

        if(args.size() == 0) {
            ansi.bg(BLACK);
        } else {
            args.stream().map(NodeValue::getString).forEach(v -> ansi.a(v));
            ansi.bg(DEFAULT);
        }

        return makeString(ansi.toString());
    }

    @Override
    public void checkBuild(String uri, ExprList args) {
        if(!args.getList().stream().filter(Expr::isConstant).map(Expr::getConstant).allMatch(NodeValue::isString))
            throw new QueryBuildException("Function '" + Lib.className(this) + "' constant arguments must be strings") ;
    }
}
