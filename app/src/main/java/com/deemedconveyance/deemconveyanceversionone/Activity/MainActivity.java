package com.deemedconveyance.deemconveyanceversionone.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.deemedconveyance.deemconveyanceversionone.Adapter.ViewPagerAdapter;
import com.deemedconveyance.deemconveyanceversionone.Fragment.DeemConveyance;
import com.deemedconveyance.deemconveyanceversionone.Fragment.Home;
import com.deemedconveyance.deemconveyanceversionone.Fragment.Resources;
import com.deemedconveyance.deemconveyanceversionone.R;
import com.deemedconveyance.deemconveyanceversionone.SharedPreferenceManager.SessionManager;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;
import static com.deemedconveyance.deemconveyanceversionone.Constant.Constants.path;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private TextView header_username,header_email;
    private ImageView header_userimg;

    // Session Manager Class
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Session Manager
        session = new SessionManager(getApplicationContext());
        session.checkLogin();



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.nav_view);
        //setupDrawerContent(nvDrawer);
        nvDrawer.setNavigationItemSelectedListener(this);
        updateHeader();
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpage_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new Home(),"Home");
        adapter.addFragment(new DeemConveyance(),"Deem Conveyance");
        adapter.addFragment(new Resources(),"Resources");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //ActionBar actionBar = getSupportActionBar();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //actionBar.setElevation(0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int id = menuItem.getItemId();
        if(id == R.id.edit_profile)
        {
            // do something
        }
        if(id == R.id.request_proposal_form)
        {
            Intent intent = new Intent(this,RequestForProposalForm.class);
            startActivity(intent);
        }
        if(id == R.id.request_registeration_form)
        {
            Intent intent = new Intent(this,WebinarRegistrationForm.class);
            startActivity(intent);
        }
        if(id == R.id.request_contact_form)
        {
            Intent intent = new Intent(this,ContactUsForm.class);
            startActivity(intent);
        }
        if(id == R.id.about)
        {
            Intent intent = new Intent(this,AboutUs.class);
            startActivity(intent);
        }
        return false;
    }

    public void updateHeader()
    {
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.nav_view);
        View headerView = nvDrawer.getHeaderView(0);


        header_username = headerView.findViewById(R.id.header_username);
        header_email = headerView.findViewById(R.id.header_email);
        header_userimg = headerView.findViewById(R.id.header_userimg);

         HashMap<String, String> user = session.getUserDetails();
        final String email = user.get(SessionManager.EMAIL);
        final String fullname =user.get(SessionManager.FULLNAME);
        final String img =path+user.get(SessionManager.PPROFILEIMG);

        System.out.println("image path :  "+img);

            header_username.setText(fullname);
            header_email.setText(email);
            Picasso.get().load(img).into(header_userimg);


    }
}
