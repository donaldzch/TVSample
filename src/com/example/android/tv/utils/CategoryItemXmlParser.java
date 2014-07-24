package com.example.android.tv.utils;

import com.example.android.tv.model.CategoryItem;
import com.example.android.tv.model.GameItem;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryItemXmlParser extends XmlParser<CategoryItem> {
    private String mRootTag;
    private static final String TAG_ID = "id";
    private static final String TAG_VALUE = "value";
    private static final String TAG_CATEGORY = "category";
    private static final String TAG_MAIN_CATEGORIES = "MainCategories";
    private static final String TAG_SUB_CATEGORY = "SubCategory";

    public CategoryItemXmlParser(String rootTag) {
        mRootTag = rootTag;
    }

    @Override
    public CategoryItem readObject(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, mRootTag);
        CategoryItem categoryItem = new CategoryItem();
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals(TAG_ID)) {
                categoryItem.setId(readLong(parser, name));
            } else if (name.equals(TAG_VALUE)) {
                categoryItem.setName(readSimpleTag(parser, name));
            } else if (name.equals(TAG_MAIN_CATEGORIES)) {
                categoryItem.setChildrenItems(readCategories(parser, name));
            }
        }
        return categoryItem;
    }

    private CategoryItem readCategoryItem(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        CategoryItem categoryItem = new CategoryItem();
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals(TAG_ID)) {
                categoryItem.setId(readLong(parser, name));
            } else if (name.equals(TAG_VALUE)) {
                categoryItem.setName(readSimpleTag(parser, name));
            } else if (name.equals(TAG_SUB_CATEGORY)) {
                categoryItem.setChildrenItems(readCategories(parser, name));
            }
        }
        return categoryItem;
    }

    private List<CategoryItem> readCategories(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        List<CategoryItem> categoryItems = new ArrayList<CategoryItem>();
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals(TAG_CATEGORY)) {
                categoryItems.add(readCategoryItem(parser, name));
            }
        }
        return categoryItems;
    }
 }
