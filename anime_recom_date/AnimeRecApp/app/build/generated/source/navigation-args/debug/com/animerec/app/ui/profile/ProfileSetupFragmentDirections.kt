package com.animerec.app.ui.profile

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.animerec.app.R

public class ProfileSetupFragmentDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionProfileSetupFragmentToPreferencesFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_profileSetupFragment_to_preferencesFragment)
  }
}
