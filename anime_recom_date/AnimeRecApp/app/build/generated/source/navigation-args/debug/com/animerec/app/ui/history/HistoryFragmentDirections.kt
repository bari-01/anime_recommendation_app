package com.animerec.app.ui.history

import android.os.Bundle
import androidx.`annotation`.CheckResult
import androidx.navigation.NavDirections
import com.animerec.app.R
import kotlin.Int
import kotlin.String

public class HistoryFragmentDirections private constructor() {
  private data class ActionHistoryFragmentToDetailsFragment(
    public val contentId: Int,
    public val contentType: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_historyFragment_to_detailsFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("contentId", this.contentId)
        result.putString("contentType", this.contentType)
        return result
      }
  }

  public companion object {
    @CheckResult
    public fun actionHistoryFragmentToDetailsFragment(contentId: Int, contentType: String): NavDirections = ActionHistoryFragmentToDetailsFragment(contentId, contentType)
  }
}
