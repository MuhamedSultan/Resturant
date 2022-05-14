package com.example.register

import android.app.FragmentManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    var mAuth : FirebaseAuth?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        mAuth= FirebaseAuth.getInstance()

        var adapter = PagerAdapter(supportFragmentManager, behavior = 7)
       pager.adapter=adapter
        tabs.setupWithViewPager(pager)
        tabs.getTabAt(0)?.setIcon(R.drawable.ic_baseline_fastfood_24)
        tabs.getTabAt(1)?.setIcon(R.drawable.ic_baseline_food_bank_24)
        tabs.getTabAt(2)?.setIcon(R.drawable.pizzaicon)
        tabs.getTabAt(3)?.setIcon(R.drawable.pastaicon)
        tabs.getTabAt(4)?.setIcon(R.drawable.mealicon)
        tabs.getTabAt(5)?.setIcon(R.drawable.sweaticon)
        tabs.getTabAt(6)?.setIcon(R.drawable.drinksicon)
        tabs.getTabAt(0)?.text="Burger"
        tabs.getTabAt(1)?.text="chicken"
        tabs.getTabAt(2)?.text="Pizza"
        tabs.getTabAt(3)?.text="Pasta"
        tabs.getTabAt(4)?.text="Meals"
        tabs.getTabAt(5)?.text="Sweats"
        tabs.getTabAt(6)?.text="Drinks"



    }
    override fun onStart() {
        super.onStart()
        if (mAuth?.currentUser == null) {
            var intentLogin = Intent(this, LoginActivtiyy::class.java)
            startActivity(intentLogin)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_logout,menu)
        return super.onCreateOptionsMenu(menu)
    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        if (id==R.id.logout){
            FirebaseAuth.getInstance().signOut()
            var intentout = Intent(this,LoginActivtiyy::class.java)
            startActivity(intentout)
        }else{
            var intentcart1 = Intent(this,Cart1::class.java)
            startActivity(intentcart1)
        }
        return super.onOptionsItemSelected(item)
    }



    private inner class PagerAdapter(fm: androidx.fragment.app.FragmentManager, behavior: Int) :
        FragmentPagerAdapter(fm, behavior) {


        override fun getCount(): Int {

            return 7
        }
        override fun getItem(position: Int): Fragment {
            if (position == 0) {
                return BurgerFragment()
            } else if (position == 1) {
                return ChickenFragment()
            } else if (position == 2) {
                return PizzaFragment()
            } else if (position == 3) {
                return PastaFragment()
            } else if (position == 4) {
                return MealsFragment()
            } else if (position == 5) {
                return SweatsFragment()
            } else {
                return DrinksFragment()
            }
        }


    }
}