package com.soukhyada.soukhyadanew.Profile

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.soukhyada.R
import com.example.soukhyada.databinding.AccountDeleteBinding
import com.example.soukhyada.databinding.ActivityProfileScreenBinding
import com.example.soukhyada.databinding.LogoutDesignBinding

import com.soukhyada.soukhyadanew.changepassword.ChangePasswordActivity

class ProfileScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileScreenBinding
    private lateinit var accountDeleteDialog: Dialog
    private lateinit var accountLogoutDialog: Dialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.bg_color_light_green)
        }

        binding = ActivityProfileScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.chnagePasswordTxt.setOnClickListener {
            startActivity(Intent(this@ProfileScreenActivity,ChangePasswordActivity::class.java))
        }


        binding.profileUpdatetxt.setOnClickListener {
            startActivity(Intent(this@ProfileScreenActivity,ProfileUpdateActivity::class.java))
        }

        binding.settDelete.setOnClickListener{

            accountDeleteDialog = Dialog(this@ProfileScreenActivity)
            accountDeleteDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            val dialogBinding = AccountDeleteBinding.inflate(layoutInflater)
            accountDeleteDialog.setContentView(dialogBinding.root)

            dialogBinding.deleteAccountTxt.setOnClickListener {
                accountDeleteDialog.dismiss()
            }

            dialogBinding.cancelBtn.setOnClickListener {
                accountDeleteDialog.dismiss()
            }

            dialogBinding.closeBtn.setOnClickListener {
                accountDeleteDialog.dismiss()
            }

            accountDeleteDialog.show()
            accountDeleteDialog.setCancelable(false)
            accountDeleteDialog.setCanceledOnTouchOutside(false)
            accountDeleteDialog.getWindow()?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            accountDeleteDialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            accountDeleteDialog.getWindow()?.getAttributes()?.windowAnimations = R.style.DialogAnimation
            accountDeleteDialog.getWindow()?.setGravity(Gravity.BOTTOM)

        }

        binding.settLogout.setOnClickListener{

            accountLogoutDialog = Dialog(this@ProfileScreenActivity)
            accountLogoutDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            val dialogLogoutBinding = LogoutDesignBinding.inflate(layoutInflater)
            accountLogoutDialog.setContentView(dialogLogoutBinding.root)

            dialogLogoutBinding.deleteAccountTxt.setOnClickListener {
                accountLogoutDialog.dismiss()
            }

            dialogLogoutBinding.cancelBtn.setOnClickListener {
                accountLogoutDialog.dismiss()
            }

            dialogLogoutBinding.closeBtn.setOnClickListener {
                accountLogoutDialog.dismiss()
            }

            accountLogoutDialog.show()
            accountLogoutDialog.setCancelable(false)
            accountLogoutDialog.setCanceledOnTouchOutside(false)
            accountLogoutDialog.getWindow()?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            accountLogoutDialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            accountLogoutDialog.getWindow()?.getAttributes()?.windowAnimations = R.style.DialogAnimation
            accountLogoutDialog.getWindow()?.setGravity(Gravity.BOTTOM)

        }

        binding.settFeedback.setOnClickListener{


            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.setPackage("com.google.android.gm")
            val shareBody = "Hi Team,"
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback")
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            val recipients = arrayOf("recipient@example.com")
            sharingIntent.putExtra(Intent.EXTRA_EMAIL, recipients)
            startActivity(sharingIntent)

        }

        binding.settSupport.setOnClickListener{

            if (ActivityCompat.checkSelfPermission(
                    this@ProfileScreenActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@ProfileScreenActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:7708835336")
                startActivity(callIntent)
            }

        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val callIntent = Intent(Intent.ACTION_CALL)
                    callIntent.data = Uri.parse("tel:7708835336")
                    startActivity(callIntent)
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}