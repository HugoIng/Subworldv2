package com.deepred.subworld.ui.init;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.crashlytics.android.Crashlytics;

import javax.inject.Inject;

import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;
import com.deepred.subworld.R;
import com.deepred.subworld.data.SyncService;
import com.deepred.subworld.ui.base.BaseActivity;
import com.deepred.subworld.ui.login.LoginActivity;
import com.deepred.subworld.util.DialogFactory;

public class InitActivity extends BaseActivity implements InitMvpView{
    private static final String TAG = "SW UI InitActivity ";

    private static final String EXTRA_TRIGGER_SYNC_FLAG =
            "com.deepred.subworld.ui.main.InitActivity.EXTRA_TRIGGER_SYNC_FLAG";

    @Inject InitPresenter mInitPresenter;


    /**
     * Return an Intent to start this Activity.
     * triggerDataSyncOnCreate allows disabling the background sync service onCreate. Should
     * only be set to false during testing.
     */
    public static Intent getStartIntent(Context context, boolean triggerDataSyncOnCreate) {
        Intent intent = new Intent(context, InitActivity.class);
        intent.putExtra(EXTRA_TRIGGER_SYNC_FLAG, triggerDataSyncOnCreate);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        ButterKnife.bind(this);
        Fabric.with(this, new Crashlytics());

        mInitPresenter.attachView(this);

        setContentView(R.layout.activity_init);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        if(mInitPresenter.hasCredentials()) {
            mInitPresenter.attempLogin();
        } else {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    launchLoginScreen();
                }
            }, 2500);
        }

        if (getIntent().getBooleanExtra(EXTRA_TRIGGER_SYNC_FLAG, true)) {
            startService(SyncService.getStartIntent(this));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mInitPresenter.detachView();
    }

    @Override
    public void launchLoginScreen() {
        Intent outI = LoginActivity.getStartIntent(this);
        outI.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(outI);
        finish();
    }

    @Override
    public void showError() {
        DialogFactory.createGenericErrorDialog(this, getString(R.string.error_loading))
                .show();
    }

}
