package com.robotemplates.cityguide;


        import android.app.Activity;
        import android.app.ActionBar;
        import android.app.FragmentTransaction;

        import android.app.Fragment;
        import android.app.FragmentManager;
        import android.content.Context;
        import android.content.Intent;
        import android.support.design.widget.TabLayout;
        import android.support.v13.app.FragmentPagerAdapter;
        import android.support.v4.view.ViewPager;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;

        import android.widget.TextView;

        import com.robotemplates.cityguide.database.DatabaseCallListener;
        import com.robotemplates.cityguide.database.DatabaseCallManager;
        import com.robotemplates.cityguide.database.DatabaseCallTask;
        import com.robotemplates.cityguide.database.data.Data;
        import com.robotemplates.cityguide.database.model.PoiModel;
        import com.robotemplates.cityguide.database.query.PoiReadQuery;
        import com.robotemplates.cityguide.database.query.Query;
        import com.robotemplates.cityguide.fragment.PoiDetailFragment;
        import com.robotemplates.cityguide.utility.Logcat;
        import com.robotemplates.cityguide.view.StatefulLayout;
        import com.robotemplates.cityguide.ListActivity;


public class Ratings extends Activity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;




   private static PoiDetailFragment poidf = new PoiDetailFragment();
    private static PoiModel mPoi = poidf.mPoi;
    private long mPoiId = poidf.mPoiId;
    private DatabaseCallManager mDatabaseCallManager = poidf.mDatabaseCallManager;
    private StatefulLayout mStatefulLayout = poidf.mStatefulLayout;
    Intent i = new Intent(Ratings.this, ListActivity.class);
    private static ListActivity l = new ListActivity();

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    public static Intent newIntent(Context context)
    {
        return new Intent(context, Ratings.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void startListActivity(){
        startActivity(i);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ratings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_ratings, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            if(getArguments().getInt(ARG_SECTION_NUMBER) == 1)
                textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            else if(getArguments().getInt(ARG_SECTION_NUMBER) == 2){
                String n = poidf.pname;
                textView.setText(n);
            }
            else{

            }

            return rootView;
        }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION A";
                case 1:
                    return "SECTION B";
                case 2:
                    return "SECTION C";
            }
            return null;
        }


    }
}
