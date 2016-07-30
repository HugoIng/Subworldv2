package com.deepred.subworld.ui.init;

import javax.inject.Inject;

import rx.Subscription;
//import com.deepred.subworld.ICommon;
import com.deepred.subworld.data.DataManager;
import com.deepred.subworld.ui.base.BasePresenter;

/**
 * Created by Hugo on 7/25/2016.
 */
public class InitPresenter extends BasePresenter<InitMvpView> {

    private final DataManager mDataManager;
    private Subscription mSubscription;

    @Inject
    public InitPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(InitMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }


    public boolean hasCredentials() {
        boolean ret = false;

        // Restore preferences
        /*String email = mDataManager.getPreferencesHelper().getPreference(ICommon.EMAIL);
        String password = mDataManager.getPreferencesHelper().getPreference(ICommon.PASSWORD);

        // Look for credentials
        if (email != null && password != null) {
            ret = true;
        }*/

        return ret;
    }

    public void attempLogin() {
        /*MyUserManager.getInstance().register4UserNotifications(this);

            // Request login or register with the background service
            Intent mServiceIntent = new Intent(this, GameService.class);
            mServiceIntent.setData(Uri.parse(ICommon.LOGIN_REGISTER));

            mServiceIntent.putExtra(ICommon.EMAIL, email);
            mServiceIntent.putExtra(ICommon.PASSWORD, password);
            mServiceIntent.putExtra(ICommon.SCREEN_CONTEXT, getLocalClassName());
            mServiceIntent.putExtra(ICommon.RESULT_RECEIVER, new ResultReceiver(null) {
                @Override
                protected void onReceiveResult(int resultCode, Bundle resultData) {
                    super.onReceiveResult(resultCode, resultData);
                    if (resultCode == RESULT_OK) {
                        Log.d(TAG, "Login OK!");

                        if (app.getLocationService() == null) {
                            LocationService.setBBDDConnected();
                        } else {
                            app.getLocationService().onBBDDConnected();
                        }
                    } else {
                        Log.d(TAG, "Login failed!");
                        launchLogin();
                    }
                }
            });
            startService(mServiceIntent); // Starts the IntentService*/
    }

}
