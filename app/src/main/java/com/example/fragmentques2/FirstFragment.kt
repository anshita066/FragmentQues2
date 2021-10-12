package com.example.fragmentques2


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class FirstFragment : Fragment(){

    override fun onCreateView(  inflater: LayoutInflater,
                                container: ViewGroup?,
                                 savedInstanceState: Bundle?
                             ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Observe Lifecycle of Fragment with activity while using Add, Replace, hide, show, remove
    val addFragmentButton = requireView().findViewById<Button>(R.id.addFragmentBtn)
    addFragmentButton.setOnClickListener {

        // create a FragmentManager
        val fragmentManager = fragmentManager

        // create a FragmentTransaction to begin the transaction and add the Fragment
        val fragmentTransaction = fragmentManager!!.beginTransaction()

        // add the Fragment to existing container
        fragmentTransaction.add(R.id.frameLayout, SecondFragment(), "SECOND_FRAGMENT")
        fragmentTransaction.commit()

    }

    val removeFragmentButton = requireView().findViewById<Button>(R.id.removeFragmentBtn)
    removeFragmentButton.setOnClickListener {

        // create a FragmentManager
        val fragmentManager = fragmentManager

        // get reference of the fragment which you
        // want to remove using tag name
        val fragmentToRemove = fragmentManager?.findFragmentByTag("SECOND_FRAGMENT")

        // create a FragmentTransaction to begin the transaction
        val fragmentTransaction = fragmentManager?.beginTransaction()

        // Check if fragment 2 is already added
        // if it is then remove it
        if (fragmentToRemove != null) {
            fragmentTransaction!!.remove(fragmentToRemove)
            fragmentTransaction.commit()
        }
        else {
            Toast.makeText(activity, "Please click on Add Fragment 2 first", Toast.LENGTH_LONG).show()
        }


    }

    val replaceFragmentButton = requireView().findViewById<Button>(R.id.replaceFragmentBtn)
    replaceFragmentButton.setOnClickListener {

        // create a FragmentManager
        val fragmentManager = fragmentManager

        // get reference of the fragment which you
        // want to remove using tag name
        val fragmentToReplace = fragmentManager?.findFragmentByTag("SECOND_FRAGMENT")

        // create a FragmentTransaction to begin the transaction and replace the Fragment
        val fragmentTransaction = fragmentManager?.beginTransaction()

        // Check if fragment 2 is already added
        // if it is then replace it
        if (fragmentToReplace != null) {
            // replace the Fragment to existing fragment container
            fragmentTransaction!!.replace(R.id.frameLayout, FragmentThird(), "THIRD_FRAGMENT")
            fragmentTransaction.commit()
        }
        else {
            Toast.makeText(activity, "Please click on Add Fragment 2 first", Toast.LENGTH_LONG).show()
        }
    }

    val hideFragmentButton = requireView().findViewById<Button>(R.id.hideFragmentBtn)
    hideFragmentButton.setOnClickListener {

        // create a FragmentManager
        val fragmentManager = fragmentManager

        // get reference of the fragment
        val fragmentToHide = fragmentManager?.findFragmentByTag("SECOND_FRAGMENT")

        // create a FragmentTransaction to begin the transaction
        val fragmentTransaction = fragmentManager?.beginTransaction()

        // Check if fragment 2 is already added
        if (fragmentToHide != null) {
            // replace the Fragment to existing fragment container
            fragmentTransaction!!.hide(fragmentToHide)
            fragmentTransaction.commit()
        }
        else {
            Toast.makeText(activity, "Please click on Add Fragment 2 first", Toast.LENGTH_LONG).show()
        }
    }

    val showFragmentButton = requireView().findViewById<Button>(R.id.showFragmentBtn)
    showFragmentButton.setOnClickListener {

        // create a FragmentManager
        val fragmentManager = fragmentManager

        // get reference of the fragment
        val fragmentToShow = fragmentManager?.findFragmentByTag("SECOND_FRAGMENT")

        // create a FragmentTransaction to begin the transaction
        val fragmentTransaction = fragmentManager?.beginTransaction()

        // Check if fragment 2 is already added
        if (fragmentToShow != null && fragmentToShow.isHidden) {
            // replace the Fragment to existing fragment container
            fragmentTransaction!!.show(fragmentToShow)
            fragmentTransaction.commit()
        }
        else {
            Toast.makeText(activity, "Please click on Hide Fragment 2 first", Toast.LENGTH_LONG).show()
        }
    }
}

}