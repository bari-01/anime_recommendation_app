package com.animerec.app.ui.auth

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.animerec.app.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionLoginFragmentToProfileSetupFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_loginFragment_to_profileSetupFragment)

    @CheckResult
    public fun actionLoginFragmentToHomeFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_loginFragment_to_homeFragment)
  }
}
