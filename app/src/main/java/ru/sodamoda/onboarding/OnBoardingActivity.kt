package ru.sodamoda.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_on_boarding.*
import kotlinx.android.synthetic.main.activity_on_boarding.view.*
import ru.sodamoda.R
import java.lang.Math.abs

class OnBoardingActivity : AppCompatActivity() {

    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        postToList()

        view_pager_2.adapter = ViewPagerAdapter(imagesList)
        view_pager_2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val zoomOut = AnimationUtils.loadAnimation(this, R.anim.zoomout)
        view_pager_2.startAnimation(zoomOut)

        indicator3.setViewPager(view_pager_2)


        val nextItemVisiblePx = 0
        val currentItemHorizontalMarginPx = 0
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page, position ->
            page.translationX = pageTranslationX * position
            page.scaleY = 1 + (1f * abs(position))
        }
        view_pager_2.setPageTransformer(pageTransformer)
    }

    private fun addToList(image1: Int, image2: Int, image3: Int) {
        imagesList.add(image1)
        imagesList.add(image2)
        imagesList.add(image3)
    }

    private fun postToList(){
        addToList(R.drawable.image_3, R.drawable.image_2, R.drawable.image_1)
    }
}