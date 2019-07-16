package com.zoidy.galaxyprojfingmod;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.getIntField;
import static de.robv.android.xposed.XposedHelpers.getObjectField;
import static de.robv.android.xposed.XposedHelpers.callMethod;
import static de.robv.android.xposed.XposedHelpers.findMethodBestMatch;
import android.graphics.Color;
import android.widget.TextView;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class XposedUndoFingerprint implements IXposedHookLoadPackage {
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.android.systemui"))
            return;

        findAndHookMethod("com.android.keyguard.KeyguardUpdateMonitor", lpparam.classLoader, "isUnlockingWithFingerprintAllowed", new XC_MethodHook() {
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    //replace the modded call with stock behavior. Stock is given in https://forum.xda-developers.com/showpost.php?p=77035733&postcount=341 (non romcontrol version)
                     
                     Object mStrongAuthTracker;                    
                     boolean mStrongAuthTracker_isUnlockingWithFingerprintAllowed;
                     mStrongAuthTracker=getObjectField(param.thisObject,"mStrongAuthTracker");
                     mStrongAuthTracker_isUnlockingWithFingerprintAllowed=(boolean)callMethod(mStrongAuthTracker,"isUnlockingWithFingerprintAllowed");
                     
                     //check result of mStrongAuthTracker,"isUnlockingWithFingerprintAllowed that is called within original function
                     //XposedBridge.log(lpparam.packageName + ", [AfterHookedMethod]: mStrongAuthTracker_isUnlockingWithFingerprintAllowed = " + mStrongAuthTracker_isUnlockingWithFingerprintAllowed);
                     
                     //check result of the original function call we're hooking (isUnlockingWithFingerprintAllowed)
                     //XposedBridge.log(lpparam.packageName + ", [AfterHookedMethod]: isUnlockingWithFingerprintAllowed result " + param.getResult().toString());
                     
					param.setResult(mStrongAuthTracker_isUnlockingWithFingerprintAllowed);
				}
			});
    }
}

