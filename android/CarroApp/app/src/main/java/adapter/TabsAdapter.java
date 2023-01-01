package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragment.CarrosFragment;

/**
 * Created by rm40246 on 19/11/2015.
 */
public class TabsAdapter extends FragmentStatePagerAdapter {

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return  new CarrosFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
