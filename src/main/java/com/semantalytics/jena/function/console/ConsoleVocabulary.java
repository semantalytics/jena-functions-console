package com.semantalytics.jena.function.console;

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
    eraseScreen,
    eraseLine,
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
    italic,
    italicOff,
    negative,
    negativeOff,
    render,
    reset,
    strikeThrough,
    strikeThroughOff,
    underline,
    underlineDouble,
    underlineOff;

    public static final String NAMESPACE = "http://semantalytics.com/2017/09/ns/stardog/kibble/console/";

    public static String sparqlPrefix(String prefixName) {
        return "PREFIX " + prefixName + ": <" + NAMESPACE + "> ";
    }

    public String stringValue() {
        return NAMESPACE + name();
    }
}
