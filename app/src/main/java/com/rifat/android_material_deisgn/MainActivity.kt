package com.rifat.android_material_deisgn

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.rifat.android_material_deisgn.R.anim.bottom_animation
import com.rifat.android_material_deisgn.R.anim.top_animation
import android.util.Pair as UtilPair


class MainActivity : AppCompatActivity() {

    lateinit var topAnim: Animation
    lateinit var bottomAnim: Animation
    lateinit var mainText: TextView
    lateinit var subText: TextView
    lateinit var logoImage: ImageView

    val SPLASH_SCREEN: Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        //Call animations
        topAnim = AnimationUtils.loadAnimation(this, top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, bottom_animation)

        //Hooks
        mainText = findViewById(R.id.bullRentTextID)
        subText = findViewById(R.id.dailyRentID)
        logoImage = findViewById(R.id.imageView)

        logoImage.startAnimation(topAnim)
        mainText.startAnimation(bottomAnim)
        subText.startAnimation(bottomAnim)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LogInActivity::class.java)

            val options = ActivityOptions.makeSceneTransitionAnimation(
                this,
                UtilPair.create(logoImage, "logo_image"),
                UtilPair.create(mainText, "logo_text")
            )

            startActivity(intent, options.toBundle())
        }, SPLASH_SCREEN);

    }
}