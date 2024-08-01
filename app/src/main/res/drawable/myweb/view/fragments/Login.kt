package com.cellstechlimited.myweb.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cellstechlimited.myweb.R
import com.cellstechlimited.myweb.databinding.FragmentLoginBinding
import com.cellstechlimited.myweb.databinding.FragmentMarketCapBinding
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Login.newInstance] factory method to
 * create an instance of this fragment.
 */
class Login : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentLoginBinding.inflate(inflater,container,false)

        binding.personalAccount.setOnClickListener {
            binding.companyAccount.setBackgroundColor(resources.getColor(R.color.gray))
            binding.CompnayAccontLayout.visibility=View.GONE
            binding.personalAccontLayout.visibility=View.VISIBLE
            binding.personalAccount.setBackgroundResource(R.drawable.signup_page_background_shape)
            binding.personalAccountText.setTextColor(resources.getColor(R.color.white))
            binding.companyAccountText.setTextColor(resources.getColor(R.color.black))
        }
        binding.companyAccount.setOnClickListener {
            binding.personalAccount.setBackgroundColor(resources.getColor(R.color.gray))
            binding.personalAccontLayout.visibility=View.GONE
            binding.CompnayAccontLayout.visibility=View.VISIBLE
            binding.companyAccount.setBackgroundResource(R.drawable.signup_page_background_shape)
            binding.companyAccountText.setTextColor(resources.getColor(R.color.white))
            binding.personalAccountText.setTextColor(resources.getColor(R.color.black))
        }
        binding.signupButton.setOnClickListener{
            loadfragment(SignIn())
        }
        binding.signupButtonTwo.setOnClickListener {
            loadfragment(SignIn())
        }


     /*   binding.viewPager.adapter = SigupTablayoutAdapter(requireActivity())

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Personal Account"
                    tab.setIcon(R.drawable.login_avatar)
                }
                1 -> {
                    tab.text = "Company Account"

                    tab.setIcon(R.drawable.login_avatar)
                }

            }
        }.attach()*/

        return binding.root
    }

    private fun loadfragment(fragment:Fragment){
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Login.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Login().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}