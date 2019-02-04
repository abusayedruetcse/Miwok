package com.ecxample.android.miwok;

public class Word {
    private String english;
    private String bangla;
    private int imageId=NO_IMAGE_PROVIDED;
    //private boolean isPhrases;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int audioId;
    public Word(String s1,String s2,int id,int audio)
    {
        bangla=s1;
        english=s2;
        imageId=id;
        audioId=audio;
       // isPhrases=false;
    }
    public Word(String s1,String s2,int audio)
    {
        bangla=s1;
        english=s2;
        audioId=audio;
    }
    /*
    public Word(String s1,String s2)
    {
        bangla=s1;
        english=s2;
       // isPhrases=true;
    }
    */

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
    public int getAudioId()
    {
        return audioId;
    }

}
