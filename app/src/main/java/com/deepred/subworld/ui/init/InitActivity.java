package com.deepred.subworld.ui.init;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.crashlytics.android.Crashlytics;

import javax.inject.Inject;

import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;
import com.deepred.subworld.R;
import com.deepred.subworld.data.SyncService;
import com.deepred.subworld.ui.base.BaseActivity;
import com.deepred.subworld.util.DialogFactory;

public class InitActivity extends BaseActivity implements InitMvpView{

    private static final String EXTRA_TRIGGER_SYNC_FLAG =
            "uk.co.ribot.androidboilerplate.ui.main.InitActivity.EXTRA_TRIGGER_SYNC_FLAG";

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
        /*if(mInitPresenter.hasCredentials()) {
            setContentView(R.layout.activity_init);
            mInitPresenter.attempLogin();
        } else {
            launchLoginScreen();
        }*/
        setContentView(R.layout.activity_init);

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
        /*Intent outI = new Intent(this, LoginActivity.class);
        if (extraFromNotification != null) {
            outI.putExtras(extraFromNotification);
        }
        outI.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(outI);

        extraFromNotification = null;
        finish();*/
    }

    @Override
    public void showError() {
        DialogFactory.createGenericErrorDialog(this, getString(R.string.error_loading))
                .show();
    }

}
