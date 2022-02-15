package ru.sodamoda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.jama.carouselview.enums.IndicatorAnimationType
import com.jama.carouselview.enums.OffsetType
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.image_carousel_item.view.*
import ru.sodamoda.onboarding.OnBoardingActivity

class MainActivity : AppCompatActivity() {

    private val images = arrayListOf(R.drawable.image_1, R.drawable.image_2, R.drawable.image_3)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carouselStart()

        start_shopping_btn.setOnClickListener {
            startActivity(Intent(this, OnBoardingActivity::class.java))
        }
    }

    private fun carouselStart(){
        val fadeInAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.fadein)
        carousel_view.apply {
            size = images.size
            resource = R.layout.image_carousel_item
            autoPlay = true
            carouselOffset = OffsetType.CENTER
            indicatorAnimationType = IndicatorAnimationType.DROP
            setCarouselViewListener { view, position ->
                val imageView = view.findViewById<ImageView>(R.id.image_view_carousel)
                imageView.setImageDrawable(resources.getDrawable(images[position], theme))
            }
            show()
        }
    }
}