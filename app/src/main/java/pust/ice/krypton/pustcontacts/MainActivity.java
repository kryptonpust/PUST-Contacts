package pust.ice.krypton.pustcontacts;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;

import java.util.List;

import pust.ice.krypton.pustcontacts.adapters.Constants;
import pust.ice.krypton.pustcontacts.adapters.Constants.ORIGIN;
import pust.ice.krypton.pustcontacts.api.Workers.SyncTask;
import pust.ice.krypton.pustcontacts.database.tables.Faculties;

public class MainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {

    private Menu menu;
    private long start = 0;
    private boolean lock = true;
    private SwipeRefreshLayout swipeRefreshLayout;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemMaxLines(10);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        this.menu = navigationView.getMenu();
        new ViewModelProvider(this).get(MainViewModel.class).getFaculties().observe(this, new Observer<List<Faculties>>() {
            public void onChanged(List<Faculties> list) {
                MainActivity.this.menu.clear();
                MainActivity.this.menu.add("Home").setIcon(R.drawable.ic_offices_24dp).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Navigation.findNavController(MainActivity.this, R.id.my_nav_host_fragment).popBackStack(R.id.startFragment, false);
                        return false;
                    }
                });
                MainActivity.this.menu.add("Notice").setIcon(R.drawable.ic_baseline_book_24).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Bundle bundle =new Bundle();
                        bundle.putString(Constants.ORIGIN_KEY,ORIGIN.NOTICES.name());
                        Navigation.findNavController(MainActivity.this,R.id.my_nav_host_fragment).navigate(R.id.action_global_mainFragment,bundle);
                        return false;
                    }
                });
                SubMenu addSubMenu = MainActivity.this.menu.addSubMenu("Faculty");
                for (final Faculties faculties : list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Faculty of ");
                    sb.append(faculties.getFaculty_name());
                    addSubMenu.add(sb.toString()).setIcon(R.drawable.ic_faculy_24dp).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            Bundle bundle = new Bundle();
                            bundle.putInt(Constants.FACULTY_id, faculties.getFaculty_id());
                            bundle.putString(Constants.ORIGIN_KEY, ORIGIN.AC_DEPARTMENT.name());
                            Navigation.findNavController(MainActivity.this, R.id.my_nav_host_fragment).navigate(R.id.action_global_mainFragment, bundle);
                            return false;
                        }
                    });
                }
            }
        });
        swipeRefreshLayout = findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (Constants.isNetworkAvailable(getApplicationContext())) {
                    if (lock) {
                        lock = false;
                        new Downloader().execute();
                    } else {
                        Toast.makeText(getApplicationContext(), "Already a sync running", Toast.LENGTH_SHORT).show();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "No network available!!", Toast.LENGTH_SHORT).show();
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });
    }

    protected void onStart() {
        super.onStart();
//        String str = "fetchtask";
//        WorkManager.getInstance().enqueueUniquePeriodicWork(str, ExistingPeriodicWorkPolicy.REPLACE, (PeriodicWorkRequest) ((Builder) new Builder(BackgroundWorker.class, 20, TimeUnit.MINUTES).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())).build());
    }

    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        getMenuInflater().inflate(R.menu.activity_menu, menu2);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.search) {
            Navigation.findNavController(this, R.id.my_nav_host_fragment).navigate(R.id.search_fragment);
            return true;
        }
        if (itemId == R.id.info) {
            Navigation.findNavController(this, R.id.my_nav_host_fragment).navigate(R.id.action_global_about);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        ((DrawerLayout) findViewById(R.id.drawer_layout)).closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        if (i != 4 || Navigation.findNavController(this, R.id.my_nav_host_fragment).getCurrentDestination().getId() != R.id.startFragment) {
            return super.onKeyDown(i, keyEvent);
        }
        if (currentTimeMillis - this.start < 1000) {
            finish();
        } else {
            this.start = currentTimeMillis;
            Toast.makeText(this, "Tap twice to exit..", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private class Downloader extends AsyncTask<Void, Object, Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            SyncTask syncTask = new SyncTask(getApplicationContext());
            syncTask.setListener(new SyncTask.Onprogresslistener() {
                @Override
                public void onProgress(int progress, String message) {
                    if (progress == 10) {
                        publishProgress("Success");
                    }
                }

                @Override
                public void onError(String err) {
                    publishProgress(err);
                }
            });
            syncTask.startSync();
            return null;
        }

        @Override
        protected void onProgressUpdate(Object... values) {
            Toast.makeText(getApplicationContext(), (String) values[0], Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            lock = true;
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}
