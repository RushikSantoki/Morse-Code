package com.aswdc_morsecode.util;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;

public class StringUtils {
    public static SpannableString buildBackgroundColorSpan(SpannableString spannableString,
                                                           String text, String searchString, int color) {

        int indexOf = text.toUpperCase().indexOf(searchString.toUpperCase());

        try {
            spannableString.setSpan(new BackgroundColorSpan(color), indexOf,
                    (indexOf + searchString.length()), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } catch (Exception e) {

        }


        return spannableString;
    }
}
