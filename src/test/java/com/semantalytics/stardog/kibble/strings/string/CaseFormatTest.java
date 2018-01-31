package com.semantalytics.stardog.kibble.strings.string;

import com.semantalytics.stardog.kibble.AbstractStardogTest;
import org.junit.*;
import org.openrdf.query.BindingSet;
import org.openrdf.query.TupleQueryResult;

import static org.junit.Assert.*;

public class CaseFormatTest extends AbstractStardogTest {
 
    @Test
    public void testLowerCamelToUpperUnderscoreByExample() {
       
        final String aQuery = StringVocabulary.sparqlPrefix("string") +
                    "select ?caseFormat where { bind(string:caseFormat(\"caseFormat\", \"CASE_FORMAT\", \"stardogUnion\") as ?caseFormat) }";

            try(final TupleQueryResult aResult = connection.select(aQuery).execute()) {

                assertTrue("Should have a result", aResult.hasNext());

                final String aValue = aResult.next().getValue("caseFormat").stringValue();

                assertEquals("STARDOG_UNION", aValue);
                assertFalse("Should have no more results", aResult.hasNext());
            }
    }

    @Test
    public void testLowerCamelToLowerUnderscoreByExample() {
     
        final String aQuery = StringVocabulary.sparqlPrefix("string") +
                    "select ?caseFormat where { bind(string:caseFormat(\"caseFormat\", \"case_format\", \"stardogUnion\") as ?caseFormat) }";

            try(final TupleQueryResult aResult = connection.select(aQuery).execute()) {

                assertTrue("Should have a result", aResult.hasNext());

                final String aValue = aResult.next().getValue("caseFormat").stringValue();

                assertEquals("stardog_union", aValue);
                assertFalse("Should have no more results", aResult.hasNext());
            }
    }

    @Test
    public void testLowerCamelToLowerHyphenByExample() {
       
        final String aQuery = StringVocabulary.sparqlPrefix("string") +
                    "select ?caseFormat where { bind(string:caseFormat(\"caseFormat\", \"case-format\", \"stardogUnion\") as ?caseFormat) }";

            try(final TupleQueryResult aResult = connection.select(aQuery).execute()) {
           
                assertTrue("Should have a result", aResult.hasNext());

                final String aValue = aResult.next().getValue("caseFormat").stringValue();

                assertEquals("stardog-union", aValue);
                assertFalse("Should have no more results", aResult.hasNext());
            }
    }

    @Test
    public void testLowerCamelToUpperCamelByExample() {
    
        final String aQuery = StringVocabulary.sparqlPrefix("string") +
                    "select ?caseFormat where { bind(string:caseFormat(\"caseFormat\", \"CaseFormat\", \"stardogUnion\") as ?caseFormat) }";

            try(final TupleQueryResult aResult = connection.select(aQuery).execute()) {
      
                assertTrue("Should have a result", aResult.hasNext());

                final String aValue = aResult.next().getValue("caseFormat").stringValue();

                assertEquals("StardogUnion", aValue);
                assertFalse("Should have no more results", aResult.hasNext());
            }
    }

    @Test
    public void testTooManyArgs() {
      
        final String aQuery = StringVocabulary.sparqlPrefix("string") +
                    "select ?caseFormat where { bind(string:caseFormat(\"one\", \"two\", \"three\", \"four\") as ?caseFormat) }";

            try(final TupleQueryResult aResult = connection.select(aQuery).execute()) {

                assertTrue("Should have a result", aResult.hasNext());

                final BindingSet aBindingSet = aResult.next();

                assertTrue("Should have no bindings", aBindingSet.getBindingNames().isEmpty());
                assertFalse("Should have no more results", aResult.hasNext());
            }
    }

    @Test
    public void testWrongType() {
    
        final String aQuery = StringVocabulary.sparqlPrefix("string") +
                    "select ?caseFormat where { bind(string:caseFormat(7, 8, 9) as ?caseFormat) }";

            try(final TupleQueryResult aResult = connection.select(aQuery).execute()) {

                assertTrue("Should have a result", aResult.hasNext());

                final BindingSet aBindingSet = aResult.next();

                assertTrue("Should have no bindings", aBindingSet.getBindingNames().isEmpty());
                assertFalse("Should have no more results", aResult.hasNext());
            }
    }
}
