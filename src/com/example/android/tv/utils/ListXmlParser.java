package com.example.android.tv.utils;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListXmlParser extends XmlParser<List<Long>> {
    private String mListTag;
    private String mItemTag;

    public ListXmlParser() {
        mItemTag = "game";
        mListTag = "games";
    }

    public ListXmlParser(String listTag, String itemTag) {
        mListTag = listTag;
        mItemTag = itemTag;
    }

    @Override
    List<Long> readObject(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, mListTag);
        List<Long> games = new ArrayList<Long>();
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals(mItemTag)) {
                games.add(readLong(parser, name));
            }
        }

        return games;
    }
}
