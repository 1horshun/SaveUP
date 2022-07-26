package com.horshun.saveup.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.horshun.core.domain.utils.UserState
import com.horshun.saveup.R
import com.horshun.saveup.ui.MainActivity
import com.horshun.saveup.ui.splash.SplashFragmentDirections.actionSplashFragmentToOnBoardingFragment
import com.horshun.saveup.ui.splash.SplashFragmentDirections.actionSplashFragmentToWelcomeFragment
import com.horshun.saveup.view_models.SplashViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {

    private val viewModel: SplashViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(3000L)
            withContext(Dispatchers.Main) {
                viewModel.readOnBoardingState().observe(viewLifecycleOwner) { state ->
                    when (state) {
                        UserState.OnBoarding -> findNavController().navigate(
                            actionSplashFragmentToOnBoardingFragment()
                        )
                        UserState.Welcome -> findNavController().navigate(
                            actionSplashFragmentToWelcomeFragment()
                        )
                        UserState.Menu -> {
                            requireActivity().startActivity(
                                Intent(
                                    requireContext(),
                                    MainActivity::class.java
                                )
                            )
                            requireActivity().finish()
                        }
                    }
                }
            }
        }

    }
}