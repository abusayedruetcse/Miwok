package com.ecxample.android.miwok;

public class Word {
    private String english;
    private String bangla;
    public Word(String s1,String s2)
    {
        bangla=s1;
        english=s2;
    }
    public String getDefaultTranslation()
    {
        return english;
    }
    public String getBanglaTranslation()
    {
        return  bangla;

    }

}
