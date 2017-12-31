package com.semantalytics.stardog.kibble.console;

import com.complexible.common.rdf.model.StardogValueFactory;
import org.openrdf.model.IRI;

public enum ConsoleVocabulary {

    backgroundBlack,
    backgroundBlue,
    backgroundBrightBlack,
    backgroundBrightBlue,
    backgroundBrightCyan,
    backgroundBrightGreen,
    backgroundBrightMagenta,
    backgroundBrightRed,
    backgroundBrightWhite,
    backgroundBrightYellow,
    backgroundCyan,
    backgroundDefault,
    backgroundGreen,
    backgroundMagenta,
    backgroundRed,
    backgroundWhite,
    backgroundYellow,
    blinkFast,
    blinkOff,
    blinkSlow,
    bold,
    boldOff,
    conceal,
    concealOff,
    console,
    foregroundBlack,
    foregroundBlue,
    foregroundCyan,
    foregroundDefault,
    foregroundGreen,
    foregroundMagenta,
    foregroundRed,
    foregroundWhite,
    foregroundYellow,
    intensityBold,
    intensityBoldOff,
    intensityBoldOn,
    intensityFaint,
    italic,
    italicOff,
    negative,
    negativeOff,
    reset,
    strikeThrough,
    strikeThroughOff,
    underline,
    underlineDouble,
    underlineOff;

    public static final String NAMESPACE = "http://semantalytics.com/2017/09/ns/stardog/kibble/console/";
    public final IRI iri;

    ConsoleVocabulary() {
        iri = StardogValueFactory.instance().createIRI(NAMESPACE, name());
    }

    public String stringValue() {
        return iri.stringValue();
    }
}
