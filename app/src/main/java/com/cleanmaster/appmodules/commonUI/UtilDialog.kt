package com.ncrcinema.movietime.marcus.commonview

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import com.cleanmaster.R


class UtilDialog {
    companion object {

        private var mDialog: Dialog? = null


        fun showProgressDialog(mContext: Context) {
            try {
                if (mDialog != null) {
                    if (mDialog!!.isShowing) {
                        mDialog!!.dismiss()
                    }
                }
                mDialog = Dialog(mContext)
                mDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
                val window = mDialog!!.getWindow()
                mDialog!!.setContentView(R.layout.loader)
                window!!.setGravity(Gravity.CENTER)
                mDialog!!.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
                mDialog!!.setCancelable(false)
                mDialog!!.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        fun hideProgress() {
            try {
                if (mDialog != null && mDialog!!.isShowing) {
                    mDialog!!.dismiss()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun isValidEmail(target: CharSequence): Boolean {
            return if (TextUtils.isEmpty(target)) {
                false
            } else {
                android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
            }
        }

    }
}