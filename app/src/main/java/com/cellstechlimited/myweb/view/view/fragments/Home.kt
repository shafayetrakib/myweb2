package com.cellstechlimited.myweb.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import com.cellstechlimited.myweb.R
import com.cellstechlimited.myweb.databinding.FragmentHomeBinding
import com.cellstechlimited.myweb.service.model.marketStatics
import com.cellstechlimited.myweb.view.adapter.tesAdapter
import com.google.android.material.appbar.MaterialToolbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    private lateinit var binding : FragmentHomeBinding
   lateinit var data:ArrayList<marketStatics>
  lateinit var testa:tesAdapter




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater,container,false)
       val layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.reyclerStatics.layoutManager = layoutManager
        //testa= tesAdapter(data)
        val itemList = listOf("Bitcoin", "Litecoin", "Troncoin", "Ton","Bitcoin", "Litecoin", "Troncoin", "Ton")
        val coinIcon = listOf(R.drawable.bitcoin,R.drawable.litecoin,R.drawable.trx,R.drawable.ton,R.drawable.bitcoin,R.drawable.litecoin,R.drawable.trx,R.drawable.ton)
        val price= listOf("64389.18","3172.70","0.13","0.56","64389.18","3172.70","0.13","0.56")
        val pricei= listOf("2%","3%","2%","1%","2%","3%","2%","1%")
        binding.reyclerStatics.adapter = tesAdapter(itemList,coinIcon,price,pricei)

       // apiData
        binding.btnDashboardSend.setOnClickListener {
            loadfragment(Send())

        }
        binding.btnDashboardSwap.setOnClickListener {
            loadfragment(Swap())

        }
        binding.btnDeposit.setOnClickListener {
            loadfragment(Wallet())
        }
        binding.btnFarming.setOnClickListener {
            loadfragment(Farming())
        }
        binding.btnFiniyBuy.setOnClickListener {
            loadfragment(FinyBuy())
        }
        binding.btnFiniyBank.setOnClickListener {
            loadfragment(FCBank())
        }
        binding.btnStutas.setOnClickListener {
            loadfragment(Status())
        }

        //apiData
        return binding.root

    }
    private fun loadfragment(fragment:Fragment){
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit()
    }

   /* val apiData:Unit
        get(){
            val url="https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest"
            val queue= Volley.newRequestQueue(requireActivity())
            val jsonObjectRequest:JsonObjectRequest= @SuppressLint("NotifyDataSetChanged")
            object : JsonObjectRequest(Method.GET,url,null, Response.Listener {
                response ->
                try {
                    val dataArray=response.getJSONArray("data")
                    for( i in 0 until dataArray.length()){
                        val dataobject=dataArray.getJSONObject(i)
                        val symbol=dataobject.getString("symbol")
                        val name=dataobject.getString("name")
                        val quote=dataobject.getJSONObject("quote")
                        val USD=quote.getJSONObject("USD")
                        val price=USD.getDouble("price")

                        data.add(marketStatics(name,symbol,price.toString()))
                    }
                    testa.notifyDataSetChanged()
                }catch (e:Exception){

                }
            },Response.ErrorListener {
                Toast.makeText(requireActivity(),"error",Toast.LENGTH_SHORT).show()
            })
            {
                override fun getHeaders(): MutableMap<String, String> {

                    val header= HashMap<String,String>();
                    header["X-CMC_PRO_API_KEY"]="db612312-8dad-4c50-80ae-2e719fef3c1b"
                    return header
                }

            }

            queue.add(jsonObjectRequest)
        }*/


}