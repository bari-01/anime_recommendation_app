package com.animerec.app.ui.profile

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.animerec.app.R

public class ProfileFragmentDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionProfileFragmentToProfileSetupFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_profileFragment_to_profileSetupFragment)

    @CheckResult
    public fun actionProfileFragmentToPreferencesFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_profileFragment_to_preferencesFragment)

    @CheckResult
    public fun actionProfileFragmentToLoginFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_profileFragment_to_loginFragment)
  }
}
