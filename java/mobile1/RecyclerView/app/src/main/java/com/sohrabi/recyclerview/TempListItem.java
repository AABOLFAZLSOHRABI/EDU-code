package com.sohrabi.recyclerview;

public class TempListItem {
    private String[] name = {

            "آپارتمان ده طبقه 250 متری",
            "207i سقف شیشهای پانور",
            "آپارتمان 80 متری",
            "متور"

    };
    private String[] price = {

            "25.000.000",
            "1.200.000",
            "5.000.000",
            "150.000"

    };
    private int[] avatar = {
            R.drawable.avatar1,
            R.drawable.avatar2,
            R.drawable.avatar3,
            R.drawable.avatar4
    };

    public String[] getName() {
        return name;
    }

    public int[] getAvatar() {
        return avatar;
    }

}