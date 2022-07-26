package com.horshun.saveup.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import com.horshun.saveup.R
import com.horshun.saveup.databinding.FragmentWelcomeBinding
import com.horshun.saveup.ui.MainActivity
import com.horshun.saveup.view_models.OnBoardingViewModel
import com.shashank.sony.fancytoastlib.FancyToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private val binding: FragmentWelcomeBinding by viewBinding()
    private val viewModel: OnBoardingViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
    }

    private fun bindViews() {
        with(binding) {
            btnLetsGo.setOnClickListener {
                if (tieNameWelcome.text.toString().isNotEmpty()) {
                    viewModel.saveUserName(tieNameWelcome.text.toString())
                    requireActivity().startActivity(
                        Intent(
                            requireContext(),
                            MainActivity::class.java
                        )
                    )
                    requireActivity().finish()
                } else {
                    FancyToast.makeText(
                        requireContext(),
                        "Input Your Name First",
                        FancyToast.LENGTH_SHORT,
                        FancyToast.DEFAULT,
                        false
                    )
                }
            }
        }
    }

}