package com.kingtvarshin.oasis2016new.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.kingtvarshin.oasis2016new.Categorytabs.Tab_art;
import com.kingtvarshin.oasis2016new.Categorytabs.Tab_dance;
import com.kingtvarshin.oasis2016new.Categorytabs.Tab_drama;
import com.kingtvarshin.oasis2016new.Categorytabs.Tab_literature;
import com.kingtvarshin.oasis2016new.Categorytabs.Tab_misc;
import com.kingtvarshin.oasis2016new.Categorytabs.Tab_music;
import com.kingtvarshin.oasis2016new.Categorytabs.Tab_online;
import com.kingtvarshin.oasis2016new.Categorytabs.Tab_oratory;
import com.kingtvarshin.oasis2016new.Categorytabs.Tab_quizzing;
import com.kingtvarshin.oasis2016new.tabs.Tab_19;
import com.kingtvarshin.oasis2016new.tabs.Tab_20;
import com.kingtvarshin.oasis2016new.tabs.Tab_21;
import com.kingtvarshin.oasis2016new.tabs.Tab_22;
import com.kingtvarshin.oasis2016new.tabs.Tab_23;

public class CatogaryTabPagerAdapter extends FragmentStatePagerAdapter {

    public CatogaryTabPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public CharSequence getPageTitle(int position) {

        if (position == 0)
        {
            return "Dance";
        }
        if (position == 1)
        {
            return "Drama";
        }
        if (position == 2)
        {
            return "Music";
        }
        if (position == 3)
        {
            return "Online";
        }
        if (position == 4)
        {
            return "Quizzing";
        }
        if (position == 5)
        {
            return "Misc";
        }
        if (position == 6)
        {
            return "Oratory";
        }
        if (position == 7)
        {
            return "Art";
        }
        if (position == 8)
        {
            return "Literature";
        }

        return null;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new Tab_dance();
            case 1:
                return new Tab_drama();
            case 2:
                return new Tab_music();
            case 3:
                return new Tab_online();
            case 4:
                return new Tab_quizzing();
            case 5:
                return new Tab_misc();
            case 6:
                return new Tab_oratory();
            case 7:
                return new Tab_art();
            case 8:
                return new Tab_literature();
        }
        return null;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 9;
    }

}
