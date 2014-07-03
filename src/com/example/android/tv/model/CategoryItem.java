package com.example.android.tv.model;

import java.io.Serializable;
import java.util.List;

public class CategoryItem implements Serializable {
    private Long mId;
    private CharSequence mName;
    private List<CategoryItem> mChildrenItems;

    public CategoryItem(Long id, CharSequence name) {
        mId = id;
        mName = name;
        mChildrenItems = null;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getId() {
        return mId;
    }

    public void setName(CharSequence name) {
        mName = name;
    }

    public CharSequence getName() {
        return mName;
    }

    public void setChildrenItems(List<CategoryItem> childrenItems) {
        mChildrenItems = childrenItems;
    }

    public List<CategoryItem> getChildrenItems() {
        return mChildrenItems;
    }

}
