package com.cellstechlimited.myweb.view.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import com.cellstechlimited.myweb.R
import com.cellstechlimited.myweb.databinding.ActivityDashboardBinding
import com.cellstechlimited.myweb.view.fragments.Gallery
import com.cellstechlimited.myweb.view.fragments.GalleryTwo
import com.cellstechlimited.myweb.view.fragments.Home
import com.cellstechlimited.myweb.view.fragments.Login
import com.cellstechlimited.myweb.view.fragments.MarketCap
import com.cellstechlimited.myweb.view.fragments.Wallet
import com.cellstechlimited.myweb.view.view.fragments.More
import com.google.android.material.navigation.NavigationView

class Dashboard : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding:ActivityDashboardBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDashboardBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setBackgroundColor(resources.getColor(R.color.blue))

            insets
        }

        setSupportActionBar(binding.toolbar)
        val toggle=ActionBarDrawerToggle(this,binding.main,binding.toolbar,R.string.open,R.string.close)
        binding.main.addDrawerListener(toggle)


        binding.darawerNavigationView.setNavigationItemSelectedListener(this)




        binding.dashboardBottomNav.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.home ->{
                    loadfragment(Home())
                    binding.toolbar.setTitle("Home")
                    true
                }
                R.id.galler_two ->{
                    loadfragment(GalleryTwo())
                    binding.toolbar.setTitle("Gallery")
                    true
                }
                R.id.wallet ->{
                    loadfragment(Wallet())
                    binding.toolbar.setTitle("WALLET")

                    true
                }
                R.id.more ->{
                    loadfragment(More())
                    binding.toolbar.setTitle("More")
                    true
                }
                else -> false

            }

        }
        loadfragment(Home())



    }


    private fun loadfragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.martktcap -> loadfragment(MarketCap())
        }
        binding.main.closeDrawer(GravityCompat.START)
        return true
    }


}