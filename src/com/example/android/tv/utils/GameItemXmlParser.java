package com.example.android.tv.utils;

import android.util.Xml;

import com.example.android.tv.model.GameItem;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GameItemXmlParser extends XmlParser<GameItem> {
     private static final String TAG_GAME = "game";
    private static final String TAG_ID = "id";
    private static final String TAG_TYPE = "type";
    private static final String TAG_CATEGORY = "category";
    private static final String TAG_RANK = "rank";
    private static final String TAG_TITLE = "title";
    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_PRICE = "price";
    private static final String TAG_VENDORS = "vendors";
    private static final String TAG_VENDOR = "vendor";
    private static final String TAG_ICON = "icon";
    private static final String TAG_IMAGE = "image";
    private static final String TAG_SCREENSHOTS = "screenshots";
    private static final String TAG_VIDEOS = "videos";
    private static final String TAG_VIDEO = "video";

    @Override
    public GameItem readObject(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, TAG_GAME);
        GameItem gameItem = new GameItem();
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals(TAG_ID)) {
                gameItem.setGameId(readLong(parser, name));
            } else if (name.equals(TAG_TYPE)) {
                gameItem.setType(readLong(parser, name));
            } else if (name.equals(TAG_CATEGORY)) {

            } else if (name.equals(TAG_RANK)) {
                gameItem.setRank(Integer.parseInt(readSimpleTag(parser, name)));
            } else if (name.equals(TAG_TITLE)) {
                gameItem.setTitle(readSimpleTag(parser, name));
            } else if (name.equals(TAG_DESCRIPTION)) {
                gameItem.setDescription(readSimpleTag(parser, name));
            } else if (name.equals(TAG_PRICE)) {
                gameItem.setPrice(Long.parseLong(readSimpleTag(parser, name)));
            } else if (name.equals(TAG_ICON)) {
                gameItem.setIcon(readSimpleTag(parser, name));
            } else if (name.equals(TAG_IMAGE)) {
                gameItem.setImage(readSimpleTag(parser, name));
            } else if (name.equals(TAG_VENDORS)) {
                gameItem.setVendors(readVendors(parser));
            } else if (name.equals(TAG_SCREENSHOTS)) {
                gameItem.setScreenShots(readScreenShots(parser));
            } else if (name.equals(TAG_VIDEOS)) {

            }
              else {
                skip(parser);
            }
        }
        return gameItem;
    }

    private String[] readScreenShots(XmlPullParser parser) throws IOException, XmlPullParserException {
        List<String> screenshots = new ArrayList<String>();

        parser.require(XmlPullParser.START_TAG, ns, TAG_SCREENSHOTS);

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals(TAG_IMAGE)) {
                screenshots.add(readSimpleTag(parser, name));
            } else {
                skip(parser);
            }
        }
        return (String[])screenshots.toArray();
    }

    private String[] readVendors(XmlPullParser parser) throws IOException, XmlPullParserException {
        List<String> vendors = new ArrayList<String>();

        parser.require(XmlPullParser.START_TAG, ns, TAG_VENDORS);

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals(TAG_VENDOR)) {
                vendors.add(readSimpleTag(parser, name));
            } else {
                skip(parser);
            }
        }
        return (String[])vendors.toArray();
    }


}
