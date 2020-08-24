package pust.ice.krypton.pustcontacts;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



import io.supercharge.shimmerlayout.ShimmerLayout;
import pust.ice.krypton.pustcontacts.adapters.Constants;
import pust.ice.krypton.pustcontacts.api.Workers.SyncTask;
import pust.ice.krypton.pustcontacts.databinding.ActivityFlashBinding;

public class FlashActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textView;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_flash);
        ShimmerLayout shimmerLayout = findViewById(R.id.shimmerlogo);
        shimmerLayout.startShimmerAnimation();

        TextView tvVersionName = findViewById(R.id.version);
        try {
            tvVersionName.setVisibility(View.VISIBLE);
            tvVersionName.setText("v" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
//        new Handler().postDelayed(new Runnable() {
//            public void run() {
//                FlashActivity.this.startActivity(new Intent(FlashActivity.this, MainActivity.class));
//                FlashActivity.this.supportFinishAfterTransition();
//            }
//        }, 2000);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.message);
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();

        if (Constants.isNetworkAvailable(getApplicationContext())) {
            System.out.println("Network available");
            new Downloader().execute();
        } else {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    FlashActivity.this.startActivity(new Intent(FlashActivity.this, MainActivity.class));
                    FlashActivity.this.supportFinishAfterTransition();
                }
            }, 2500);
        }

    }



    private class Downloader extends AsyncTask<Void, Object, Void> {

        @Override
        protected void onPreExecute() {
            textView.setTextColor(Color.parseColor("#4CAF50"));
            textView.setText("OnlineMode");
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            SyncTask task = new SyncTask(getApplicationContext());
            task.setListener(new SyncTask.Onprogresslistener() {
                @Override
                public void onProgress(int progress, String message) {
                    publishProgress(progress * 10, message);
                }

                @Override
                public void onError(String err) {
                    publishProgress(0, err);
                }
            });
            task.startSync();
            return null;
        }

        @Override
        protected void onProgressUpdate(Object... values) {
            if ((int) values[0] == 0) {
                textView.setTextColor(Color.parseColor("#E91E63"));
            }
            progressBar.setProgress((int) values[0]);
            textView.setText((String) values[1]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    FlashActivity.this.startActivity(new Intent(FlashActivity.this, MainActivity.class));
                    FlashActivity.this.supportFinishAfterTransition();
                }
            }, 2500);
        }
    }

}
