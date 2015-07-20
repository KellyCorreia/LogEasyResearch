package com.example.kelly.logeasyresearch;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.support.v4.app.FragmentTransaction;

import java.util.Locale;

public class ActivityLevels extends AppCompatActivity implements LevelsAdapter.OnItemClickListener {


    private Toolbar mToolbar;
    ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mDrawerList;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mOptionsTitles;

    private ClassUser user;

    int ICONS[] = {R.drawable.ic_action, R.drawable.ic_user, R.drawable.ic_scoreboard, R.drawable.ic_logoutbk};
    String NAME = "UserName";
    String EMAIL = "user@email.com";
    int PROFILE = R.drawable.avatar4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        //Getting the object user from the previous screen
        Bundle extras = getIntent().getExtras();
        user = extras.getParcelable("chosenUser");
        int i = extras.getInt("toast");

        NAME = user.getUsername();
        EMAIL = user.getEmail();
        PROFILE = getResources().getIdentifier(user.getAvatar().toLowerCase(Locale.getDefault()),
                "drawable", this.getPackageName());

        if (savedInstanceState == null) {
            mToolbar = (Toolbar) findViewById(R.id.tool_bar);
            setSupportActionBar(mToolbar);
            mToolbar.setTitleTextColor(getResources().getColor(R.color.Branco));
            if (i == 1) {
                Toast.makeText(ActivityLevels.this, "Welcome, " + user.getUsername() + " !", Toast.LENGTH_SHORT).show();
                Toast.makeText(ActivityLevels.this, "Choose a Level to start the challenge!", Toast.LENGTH_SHORT).show();
            }
        }

        //definição do navigatin drawer daqui em diante

        mTitle = mDrawerTitle = "ActivityLogEasy";
        mOptionsTitles = getResources().getStringArray(R.array.options_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (RecyclerView) findViewById(R.id.left_drawer);

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // improve performance by indicating the list if fixed size.
        mDrawerList.setHasFixedSize(true);
        mDrawerList.setLayoutManager(new LinearLayoutManager(this));

        // set up the drawer's list view with items and click listener
        mDrawerList.setAdapter(new LevelsAdapter(mOptionsTitles, ICONS, NAME, EMAIL, PROFILE, this));
        // enable ActionBar app icon to behave as action to toggle nav drawer
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        } catch (NullPointerException ere) {
            Toast.makeText(this, "NO ACTIONBAR!", Toast.LENGTH_SHORT).show();
        }

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_levels, menu);
        return true;
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_logout).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    // quando a opção de pesquisa é selecionada
    // aqui que eu vou implementar a saída do aplicativo
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action buttons
        switch (item.getItemId()) {
            case R.id.action_logout:
                finishApplication();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* The click listener for RecyclerView in the navigation drawer */
    // a posição clicada do drawer é passada para mostrar
    @Override
    public void onClick(View view, int position) {
        selectItem(position);
    }

    // aqui devo selecionar o
    private void selectItem(int position) {
        // update selected item title, then close the drawer
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Bundle args = new Bundle();
        switch (position) {
            case 0:
                FragmentSlidingLevels fragment = new FragmentSlidingLevels();
                args.putParcelable("chosenUser", user);
                fragment.setArguments(args);
                // aqui ele seta o que vai ser substituido dentro do layout
                transaction.replace(R.id.sample_content_fragment, fragment);
                transaction.commit();
                break;
            case 1:
                FragmentUserDetails ufragment = new FragmentUserDetails();
                args.putParcelable("chosenUser", user);
                ufragment.setArguments(args);
                // aqui ele seta o que vai ser substituido dentro do layout
                transaction.replace(R.id.sample_content_fragment, ufragment);
                transaction.commit();
                break;
            case 2:
                FragmentScoreboard fragment1 = new FragmentScoreboard();
                // aqui ele seta o que vai ser substituido dentro do layout
                transaction.replace(R.id.sample_content_fragment, fragment1);
                transaction.commit();
                break;
            case 3:
                finishApplication();
                break;
        }
        if(position == 0)
            setTitle(mDrawerTitle);
        else
            setTitle(mOptionsTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        try {
            getSupportActionBar().setTitle(mTitle);
        } catch (NullPointerException ere) {
            Toast.makeText(this, "NO ACTIONBAR!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public void onBackPressed() {
        finishApplication();
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Intent intent = new Intent(ActivityLevels.this, ActivityLevels.class);
        intent.putExtra("chosenUser", user);
        intent.putExtra("toast", 0);
        startActivity(intent);
        this.finish();
    }
    public void finishApplication() {

        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityLevels.this);
        builder.setTitle("Log Out")
                .setMessage("Proceed with log out?")
                .setCancelable(true)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


}
