package com.ecxample.android.miwok;

public class Word {
    private String english;
    private String bangla;
    private int imageId=NO_IMAGE_PROVIDED;
    //private boolean isPhrases;
    private static final int NO_IMAGE_PROVIDED = -1;
    public Word(String s1,String s2,int id)
    {
        bangla=s1;
        english=s2;
        imageId=id;
       // isPhrases=false;
    }
    public Word(String s1,String s2)
    {
        bangla=s1;
        english=s2;
       // isPhrases=true;
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
    public boolean hasImage()
    {
        return imageId!=NO_IMAGE_PROVIDED;
    }

}
