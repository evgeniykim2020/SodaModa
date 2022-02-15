package ru.sodamoda.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import ru.sodamoda.R
import ru.sodamoda.databinding.ActivityOnBoardingBinding
import ru.sodamoda.databinding.OnboardingItemBinding

class ViewPagerAdapter(private var images: List<Int>) : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        val binding = OnboardingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Pager2ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.binding.ivImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int = images.size

    inner class Pager2ViewHolder(val binding: OnboardingItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.ivImage.setOnClickListener { v: View ->
                val position = adapterPosition
            }
        }

    }
}