package com.example.android.tv.utils;

import android.util.Xml;

import com.example.android.tv.model.GameItem;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;


public abstract class XmlParser<T> {
    protected static final String ns = null;

    public T parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readObject(parser);
        } finally {
            in.close();
        }
    }

    abstract T readObject(XmlPullParser parser) throws XmlPullParserException, IOException;

    protected Integer readInteger(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        return Integer.parseInt(readSimpleTag(parser, tag));
    }

    protected Long readLong(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        return Long.parseLong(readSimpleTag(parser, tag));
    }

    protected String readSimpleTag(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, tag);
        return title;
    }

    // For the tags title and summary, extracts their text values.
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    protected void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
