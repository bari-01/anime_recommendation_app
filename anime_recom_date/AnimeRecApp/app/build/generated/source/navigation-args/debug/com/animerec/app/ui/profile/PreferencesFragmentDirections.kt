package com.animerec.app.ui.profile

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.animerec.app.R

public class PreferencesFragmentDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionPreferencesFragmentToHomeFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_preferencesFragment_to_homeFragment)
  }
}
