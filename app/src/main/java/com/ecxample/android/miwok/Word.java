package com.ecxample.android.miwok;

public class Word {
    private String english;
    private String bangla;
    private int imageId;
    public Word(String s1,String s2,int id)
    {
        bangla=s1;
        english=s2;
        imageId=id;
    }
    public String getDefaultTranslation()
    {
        return english;
    }
    public String getBanglaTranslation()
    {
        return  bangla;

    }
    public int getImageId()
    {
        return imageId;
    }

}
