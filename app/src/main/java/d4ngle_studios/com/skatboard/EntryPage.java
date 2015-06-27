package d4ngle_studios.com.skatboard;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * This is the Entry Page
 */
public class EntryPage extends ActionBarActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * catch unexpected error
         */
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());

        setContentView(R.layout.activity_entry_page);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entry_page, menu);
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
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
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
        private List<Button> playerButtons;
        private List<ToggleButton> numberJacksButtons;
        private List<ToggleButton> valueSuitsButtons;
        private List<CheckBox> additionalInfoCheckboxes;

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

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_entry_page, container, false);

            Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "font/icomoon.ttf");

            Button buttonPlayer1 = (Button) rootView.findViewById(R.id.imageButtonPlayer1);
            Button buttonPlayer2 = (Button) rootView.findViewById(R.id.imageButtonPlayer2);
            Button buttonPlayer3 = (Button) rootView.findViewById(R.id.imageButtonPlayer3);
            Button buttonPlayer4 = (Button) rootView.findViewById(R.id.imageButtonPlayer4);

            ToggleButton buttonNumberJacks1 = (ToggleButton) rootView.findViewById(R.id.numberJacks1);
            ToggleButton buttonNumberJacks2 = (ToggleButton) rootView.findViewById(R.id.numberJacks2);
            ToggleButton buttonNumberJacks3 = (ToggleButton) rootView.findViewById(R.id.numberJacks3);
            ToggleButton buttonNumberJacks4 = (ToggleButton) rootView.findViewById(R.id.numberJacks4);

            ToggleButton buttonValueSuitsDiamonds = (ToggleButton) rootView.findViewById(R.id.valueSuitsDiamonds);
            ToggleButton buttonValueSuitsHearts = (ToggleButton) rootView.findViewById(R.id.valueSuitsHearts);
            ToggleButton buttonValueSuitsSpades = (ToggleButton) rootView.findViewById(R.id.valueSuitsSpades);
            ToggleButton buttonValueSuitsClubs = (ToggleButton) rootView.findViewById(R.id.valueSuitsClubs);

            ImageButton buttonValueSuitsGrand = (ImageButton) rootView.findViewById(R.id.valueGrand);

            CheckBox checkBoxHand = (CheckBox) rootView.findViewById(R.id.checkBoxHand);
            CheckBox checkBoxOuvert = (CheckBox) rootView.findViewById(R.id.checkBoxOuvert);
            CheckBox checkBoxSchneider = (CheckBox) rootView.findViewById(R.id.checkBoxSchneider);
            CheckBox checkBoxSchneiderAngesagt = (CheckBox) rootView.findViewById(R.id.checkBoxSchneiderAngesagt);
            CheckBox checkBoxSchwarz = (CheckBox) rootView.findViewById(R.id.checkBoxSchwarz);
            CheckBox checkBoxSchwarzAngesagt = (CheckBox) rootView.findViewById(R.id.checkBoxSchwarzAngesagt);

            final EditText result = (EditText) rootView.findViewById(R.id.editTextPoints);
            Button buttonCompute = (Button) rootView.findViewById(R.id.buttonCompute);

            final TextView toggleAdditionalInfoMore = (TextView) rootView.findViewById(R.id.additional_info_more);
            final TextView toggleAdditionalInfoLess = (TextView) rootView.findViewById(R.id.additional_info_less);
            final ScrollView additionalGameInfo = (ScrollView) rootView.findViewById(R.id.additionalGameInfoView);
            additionalGameInfo.setVisibility(View.GONE);

            playerButtons = Arrays.asList(buttonPlayer1, buttonPlayer2, buttonPlayer3, buttonPlayer4);
            numberJacksButtons = Arrays.asList(buttonNumberJacks1, buttonNumberJacks2, buttonNumberJacks3, buttonNumberJacks4);
            valueSuitsButtons = Arrays.asList(buttonValueSuitsDiamonds, buttonValueSuitsHearts, buttonValueSuitsSpades, buttonValueSuitsClubs);
            additionalInfoCheckboxes = Arrays.asList(checkBoxHand, checkBoxOuvert, checkBoxSchneider, checkBoxSchneiderAngesagt, checkBoxSchwarz, checkBoxSchwarzAngesagt);

            for (Button b : playerButtons) {
                b.setTypeface(font);
                addPlayerOnClickListeners(b);
            }

            for (ToggleButton b : numberJacksButtons) {
                b.setTypeface(font);
                addToggleButtonOnClickListener(b, numberJacksButtons);
            }

            for (ToggleButton b : valueSuitsButtons) {
                b.setTypeface(font);
                addToggleButtonOnClickListener(b, valueSuitsButtons);
            }

            toggleAdditionalInfoMore.setTypeface(font);
            toggleAdditionalInfoMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    additionalGameInfo.setVisibility(View.VISIBLE);
                    toggleAdditionalInfoMore.setVisibility(View.GONE);
                }
            });

            toggleAdditionalInfoLess.setTypeface(font);
            toggleAdditionalInfoLess.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    additionalGameInfo.setVisibility(View.GONE);
                    toggleAdditionalInfoMore.setVisibility(View.VISIBLE);
                }
            });

            buttonCompute.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    ToggleButton player = getCheckedButton(numberJacksButtons); //TODO

                    int jacksValue = getMathValue(getCheckedButton(numberJacksButtons));
                    int gameColorValue = getMathValue(getCheckedButton(valueSuitsButtons));

                    if (jacksValue == 0 || gameColorValue == 0) {
                        Toast.makeText(rootView.getContext(), "ich kann so nicht arbeiten, Idiot!", Toast.LENGTH_SHORT).show();
                    } else {
                        int modifier = 1 + getAdditionalGameInfo();
                        result.setText("" + (jacksValue + modifier) * gameColorValue);
                    }
                }
            });

            return rootView;
        }

        private int getAdditionalGameInfo() {
            int result = 0;
            for (CheckBox box : additionalInfoCheckboxes) {
                if (box.isChecked()) {
                    result++;
                }
            }
            return result;
        }

        private int getMathValue(ToggleButton button) {
            if (null == button) {
                return 0;
            }
            switch (button.getId()) {
                case R.id.numberJacks1:
                    return 1;
                case R.id.numberJacks2:
                    return 2;
                case R.id.numberJacks3:
                    return 3;
                case R.id.numberJacks4:
                    return 4;
                case R.id.valueSuitsDiamonds:
                    return 9;
                case R.id.valueSuitsHearts:
                    return 10;
                case R.id.valueSuitsSpades:
                    return 11;
                case R.id.valueSuitsClubs:
                    return 12;
                case R.id.valueGrand:
                    return 24;
            }
            return 0;
        }

        private void addPlayerOnClickListeners(Button button) {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View clickedButton) {
                        changePlayerIcons((Button) clickedButton, playerButtons, getActivity().getString(R.string.icon_player_won));
                    }
                });
        }

        private static boolean isVisiblePlayer(LinearLayout playersLayout, View view) {
        return true;
    }

        private static void changePlayerIcons(Button clickedButton, List<Button> allButtons, String winString) {

        if (clickedButton.getText().equals(winString)) {
            clickedButton.setText(R.string.icon_player_lost);
            for (Button button : allButtons) {
                if (isVisiblePlayer((LinearLayout) ((View) clickedButton.getParent()).findViewById(R.id.playersLayout), button)) {
                    if (!button.equals(clickedButton)) {
                        button.setText(R.string.icon_player_won);
                    }
                }
            }
        } else {
            clickedButton.setText(R.string.icon_player_won);
            for (Button button : allButtons) {
                if (isVisiblePlayer((LinearLayout) ((View) clickedButton.getParent()).findViewById(R.id.playersLayout), button)) {
                    if (!button.equals(clickedButton)) {
                        button.setText(R.string.icon_player_lost);
                    }
                }
            }
        }
    }

        private void addToggleButtonOnClickListener(ToggleButton button, final List<ToggleButton> buttonList) {
                button.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                             for (ToggleButton b : buttonList) {
                                 if ((b.getId() != (v.getId())) && (b.getTag().equals(v.getTag()))) {
                                     b.setChecked(false);
                                 }
                             }
                         }
                     }
                );
        }

        private ToggleButton getCheckedButton(List<ToggleButton> buttonList) {
            for (ToggleButton b : buttonList) {
                if (b.isChecked()) {
                    return b;
                }
            }
            return null;
        }
    }
}
