public class KeyguardStatusBarView extends RelativeLayout {
    private boolean mKeyguardUserSwitcherShowing;
    private View mSystemIconsSuperContainer;
    private MultiUserSwitch mMultiUserSwitch;
    private ImageView mMultiUserAvatar;
    private BatteryLevelTextView mBatteryLevel;

    public BatteryController mBatteryController;

    private KeyguardUserSwitcher mKeyguardUserSwitcher;
    private int mSystemIconsSwitcherHiddenExpandedMargin;
    private Interpolator mFastOutSlowInInterpolator;
}