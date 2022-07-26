package com.horshun.saveup.ui.on_boarding

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.horshun.saveup.R
import com.horshun.saveup.adapters.ViewPagerAdapter
import com.horshun.saveup.databinding.FragmentOnBoardingBinding
import com.horshun.saveup.ui.on_boarding.OnBoardingFragmentDirections.actionOnBoardingFragmentToWelcomeFragment
import com.horshun.saveup.ui.on_boarding.screen_one.ScreenOneFragment
import com.horshun.saveup.ui.on_boarding.screen_third.ScreenThirdFragment
import com.horshun.saveup.ui.on_boarding.screen_two.ScreenTwoFragment
import com.horshun.saveup.view_models.OnBoardingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding) {

    private val binding: FragmentOnBoardingBinding by viewBinding()
    private val viewModel: OnBoardingViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
    }

    private fun bindViews() {
        with(binding) {
            val viewPagerAdapter = ViewPagerAdapter(
                arrayListOf(ScreenOneFragment(), ScreenTwoFragment(), ScreenThirdFragment()),
                requireActivity().supportFragmentManager,
                lifecycle
            )
            vpOnboarding.adapter = viewPagerAdapter
            dotsIndicator.setViewPager2(vpOnboarding)

            tvNext.setOnClickListener { vpOnboarding.currentItem += 1 }
            btnGetStarted.setOnClickListener {
                viewModel.saveState(true)
                findNavController().navigate(actionOnBoardingFragmentToWelcomeFragment())
            }

            viewPagerCallback()

        }
    }

    private fun viewPagerCallback() {
        binding.vpOnboarding.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                if (position == binding.vpOnboarding.size+1) {
                    binding.btnGetStarted.visibility = View.VISIBLE
                    binding.tvNext.visibility = View.INVISIBLE
                } else {
                    binding.tvNext.visibility = View.VISIBLE
                    binding.btnGetStarted.visibility = View.INVISIBLE
                }
            }
        })

    }

}