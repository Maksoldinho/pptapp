package com.example.pptapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pptapp.R
import com.example.pptapp.databinding.EntryPageBinding

class EntryPageActivity : Fragment() {
    private var _binding: EntryPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EntryPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signUpBtn.setOnClickListener {
            findNavController().navigate(R.id.action_entryPageActivity_to_registerPageActivity)
        }

        binding.logInBtn.setOnClickListener {
            Registration.TryToLogin(username = binding.emailEditText.text.toString(),
                password = binding.passwordEditText.text.toString())
            if(Registration.logInDataIsCorrect){
                println("Finally everything is working properly")
               val intent = Intent(context, MainPageActivity::class.java)
                startActivity(intent)
            }

//            if(Registration.TryToLogin(username = binding.emailEditText.text.toString(),
//               password = binding.passwordEditText.text.toString())){
//                println("goood")
//                findNavController().navigate(R.id.action_entryPageActivity_to_mainActivity)
//            }else{
//                println("not good")
//            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}