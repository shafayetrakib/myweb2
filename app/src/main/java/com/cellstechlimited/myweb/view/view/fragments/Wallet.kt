package com.cellstechlimited.myweb.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cellstechlimited.myweb.R
import com.cellstechlimited.myweb.databinding.FragmentHomeBinding
import com.cellstechlimited.myweb.databinding.FragmentWalletBinding
import com.cellstechlimited.myweb.service.model.marketStatics
import com.cellstechlimited.myweb.view.adapter.tesAdapter
import com.cellstechlimited.myweb.view.ui.test

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Wallet.newInstance] factory method to
 * create an instance of this fragment.
 */
class Wallet : Fragment() {
    private lateinit var binding:FragmentWalletBinding
    private lateinit var testa2:tesAdapter
    private lateinit var data2:ArrayList<marketStatics>
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
        binding= FragmentWalletBinding.inflate(inflater,container,false)

        val layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.transactionRecycler.layoutManager = layoutManager
        val itemList = listOf("FinyCoin", "Bitcoin", "LiteCoin", "testCoin","Item 1", "Item 2", "Item 3", "Item 4")
        val imageCoin= listOf(R.drawable.coin,R.drawable.coin,R.drawable.coin,R.drawable.coin,
            R.drawable.coin,R.drawable.coin,R.drawable.coin,R.drawable.coin)
        val image= listOf(R.drawable.coin,R.drawable.coin,R.drawable.coin,R.drawable.coin,
            R.drawable.coin,R.drawable.coin,R.drawable.coin,R.drawable.coin)
      //  testa2=tesAdapter(data2)
      // binding.transactionRecycler.adapter = tesAdapter(itemList)

        binding.btnWithdraws.setOnClickListener {
            loadfragment(Withrdraws())
        }
        binding.btnDeposit.setOnClickListener {
            loadfragment(Deposit())
        }
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
         * @return A new instance of fragment Wallet.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Wallet().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}