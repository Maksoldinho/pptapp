package com.example.pptapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pptapp.R
import com.example.pptapp.databinding.RegisterPageBinding

class RegisterPageActivity : Fragment() {
    private var _binding: RegisterPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegisterPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCreateAccount.setOnClickListener {

            Registration.TryToRegister(username = binding.registerEmailEditText.text.toString(),
            password = binding.confirmPwdEditText.text.toString())
            findNavController().navigate(R.id.action_registerPageActivity_to_entryPageActivity)
        }
    }
}