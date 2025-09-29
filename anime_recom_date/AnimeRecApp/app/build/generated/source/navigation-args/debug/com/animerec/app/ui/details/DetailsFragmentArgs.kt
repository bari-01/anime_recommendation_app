package com.animerec.app.ui.details

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.String
import kotlin.jvm.JvmStatic

public data class DetailsFragmentArgs(
  public val contentId: Int,
  public val contentType: String,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("contentId", this.contentId)
    result.putString("contentType", this.contentType)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("contentId", this.contentId)
    result.set("contentType", this.contentType)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): DetailsFragmentArgs {
      bundle.setClassLoader(DetailsFragmentArgs::class.java.classLoader)
      val __contentId : Int
      if (bundle.containsKey("contentId")) {
        __contentId = bundle.getInt("contentId")
      } else {
        throw IllegalArgumentException("Required argument \"contentId\" is missing and does not have an android:defaultValue")
      }
      val __contentType : String?
      if (bundle.containsKey("contentType")) {
        __contentType = bundle.getString("contentType")
        if (__contentType == null) {
          throw IllegalArgumentException("Argument \"contentType\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"contentType\" is missing and does not have an android:defaultValue")
      }
      return DetailsFragmentArgs(__contentId, __contentType)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DetailsFragmentArgs {
      val __contentId : Int?
      if (savedStateHandle.contains("contentId")) {
        __contentId = savedStateHandle["contentId"]
        if (__contentId == null) {
          throw IllegalArgumentException("Argument \"contentId\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"contentId\" is missing and does not have an android:defaultValue")
      }
      val __contentType : String?
      if (savedStateHandle.contains("contentType")) {
        __contentType = savedStateHandle["contentType"]
        if (__contentType == null) {
          throw IllegalArgumentException("Argument \"contentType\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"contentType\" is missing and does not have an android:defaultValue")
      }
      return DetailsFragmentArgs(__contentId, __contentType)
    }
  }
}
