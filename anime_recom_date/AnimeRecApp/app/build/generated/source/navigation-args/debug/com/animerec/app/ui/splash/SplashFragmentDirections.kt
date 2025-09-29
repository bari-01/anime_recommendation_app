package com.animerec.app.ui.splash

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.animerec.app.R

public class SplashFragmentDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionSplashFragmentToLoginFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_splashFragment_to_loginFragment)

    @CheckResult
    public fun actionSplashFragmentToHomeFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_splashFragment_to_homeFragment)

    @CheckResult
    public fun actionSplashFragmentToProfileSetupFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_splashFragment_to_profileSetupFragment)
  }
}
