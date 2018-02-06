package com.semantalytics.stardog.kibble.strings.string;

import com.complexible.common.rdf.model.StardogValueFactory;
import org.openrdf.model.IRI;

public enum StringVocabulary {

    abbreviate,
    abbreviateWithMarker,
    abbreviateMiddle,
    appendIfMissing,
    appendIfMissingIgnoreCase,
    capitalize,
    caseFormat,
    center,
    chomp,
    commonSuffix,
    chop,
    compare,
    compareIgnoreCase,
    commonPrefix,
    containsAny,
    contains,
    containsIgnoreCase,
    containsNone,
    containsWhitespace,
    containsOnly,
    countMatches,
    deleteWhitespace,
    difference,
    defaultIfBlank,
    defaultIfEmpty,
    endsWith,
    endsWithIgnoreCase,
    equalsAny,
    equalsIgnoreCase,
    digits,
    initials,
    indexOf,
    indexOfAnyChar,
    indexOfAnyString,
    indexOfAnyCharBut,
    indexOfAnyStringBut,
    indexOfDifference,
    indexOfIgnoreCase,
    isAlpha,
    isAsciiPrintable,
    isAlphaSpace,
    isAlphanumeric,
    isAnyEmpty,
    isAnyBlank,
    isAlphanumericSpace,
    isAllLowerCase,
    isAllUpperCase,
    isBlank,
    isEmpty,
    isMixedCase,
    isNoneBlank,
    isNotEmpty,
    isNumericSpace,
    isAllBlank,
    isAllEmpty,
    isNotBlank,
    isNumeric,
    isWhitespace,
    join,
    joinWith,
    left,
    length,
    leftPad,
    lastIndexOfAny,
    lastOrdinalIndexOf,
    lastIndexOfIgnoreCase,
    lastIndexOf,
    lowerCaseFully,
    lowerCase,
    ordinalIndexOf,
    overlay,
    padEnd,
    pipe,
    padStart,
    prependIfMissing,
    prependIfMissingIgnoreCase,
    reverseDelimited,
    removeEndIgnoreSpace,
    repeat,
    random,
    remove,
    removeIgnoreCase,
    rotate,
    reverse,
    removeEnd,
    removeAll,
    removePattern,
    removeFirst,
    removeStart,
    replace,
    replaceAll,
    replaceChars,
    replaceEach,
    replaceEachRepeatedly,
    replaceFirst,
    replaceOnce,
    replaceOnceIgnoreCase,
    replaceIgnoreCase,
    replacePattern,
    removeStartIgnoreCase,
    right,
    rightPad,
    split,
    startsWith,
    startsWithAny,
    startsWithIgnoreCase,
    strip,
    stripAll,
    stripAccents,
    stripAll,
    stripEnd,
    stripStart,
    substring,
    substringAfter,
    substringAfterLast,
    substringBefore,
    substringBeforeLast,
    substringBetween,
    substringsBetween,
    swapCase,
    trim,
    truncate,
    toEncodedString,
    toCodePoints,
    uncapitalize,
    unwrap,
    wrap,
    wrapIfMissing,
    mid,
    normalizeSpace,
    upperCaseFully,
    upperCase,
    ;

    public static final String NAMESPACE = "http://semantalytics.com/2017/09/ns/stardog/kibble/strings/string/";
    public final IRI iri;

    StringVocabulary() {
        iri = StardogValueFactory.instance().createIRI(NAMESPACE, name());
    }

    public static String sparqlPrefix(String prefixName) {
        return "PREFIX " + prefixName + ": <" + NAMESPACE + "> ";
    }

    public String stringValue() {
        return iri.stringValue();
    }
}
