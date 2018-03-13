package br.usjt.cdv_si3an_mca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import br.usjt.cdv_si3an_mca.util.StatusTracker;
import br.usjt.cdv_si3an_mca.util.Utils;

public class Activity_B extends AppCompatActivity {

    private String mActivityName;
    private TextView mStatusView;
    private TextView mStatusAllView;
    private StatusTracker mStatusTracker = StatusTracker.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mActivityName = getString(R.string.activity_b);
        mStatusView = (TextView)findViewById(R.id.status_view_b);
        mStatusAllView = (TextView)findViewById(R.id.status_view_all_b);
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_create));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_start));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_restart));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_resume));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_pause));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_stop));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_destroy));
        //mStatusTracker.clear();
    }

    public void startDialog(View v) {
        Intent intent = new Intent(Activity_B.this, br.usjt.cdv_si3an_mca.DialogActivity.class);
        startActivity(intent);
    }

    public void startActivityA(View view) {
        Intent intent = new Intent(Activity_B.this, br.usjt.cdv_si3an_mca.Activity_A.class);
        startActivity(intent);
    }

    public void startActivityC(View view) {
        Intent intent = new Intent(Activity_B.this, Activity_C.class);
        startActivity(intent);



    public void finishActivityB(View view) {Activity_B.this.finish();
    }


    }
}



