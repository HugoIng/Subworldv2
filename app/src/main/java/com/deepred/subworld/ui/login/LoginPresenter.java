package com.deepred.subworld.ui.login;

import com.deepred.subworld.data.DataManager;
import com.deepred.subworld.ui.base.BasePresenter;
import com.deepred.subworld.ui.login.LoginMvpView;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by Hugo on 7/30/2016.
 */
public class LoginPresenter extends BasePresenter<LoginMvpView> {

    private final DataManager mDataManager;
    private Subscription mSubscription;

    @Inject
    public LoginPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(LoginMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
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
