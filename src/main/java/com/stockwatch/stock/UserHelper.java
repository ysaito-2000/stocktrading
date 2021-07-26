package com.stockwatch.stock;

public class UserHelper {
    private int volume;

    public UserHelper(User user, String stock) {
        for (Stock i : user.getOwnedSet()) {
            if (i.getName().equals(stock)) {
                volume = i.getVolume();
            }
        }

    }



}
