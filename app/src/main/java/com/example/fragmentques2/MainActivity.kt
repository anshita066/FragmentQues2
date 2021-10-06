package com.example.fragmentques2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = FragmentThird()

        var btn1 = findViewById<View>(R.id.btnFragment1) as Button
        var btn2 = findViewById<View>(R.id.btnFragment2) as Button
        var btn = findViewById<View>(R.id.btn) as Button

        supportFragmentManager.beginTransaction().apply {

            //add method
            add(R.id.flfragment, thirdFragment)
            commit()
        }

        btn1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {


                //show method
                if (firstFragment.isAdded) {
                    show(firstFragment);
                }

                // replace method
                replace(R.id.flfragment, firstFragment)
                addToBackStack(null)

                //hide method
                hide(thirdFragment)
                commit()
            }
        }
        btn2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {


                //show method
                if (secondFragment.isAdded) {
                    show(secondFragment);
                }
                // replace method
                replace(R.id.flfragment, secondFragment)
                addToBackStack(null)

                //remove method
                remove(thirdFragment)
                commit()
            }
        }
        btn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {

                if (firstFragment.isAdded) {
                    hide(firstFragment);
                } else if (secondFragment.isAdded) {
                    hide(secondFragment)
                } else if (thirdFragment.isAdded) {
                    hide(thirdFragment)
                }
                commit()
            }
        }
    }
}