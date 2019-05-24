package com.example.kphrase.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.example.kphrase.*

class MainFragment : Fragment(), View.OnClickListener {
    private var vId : Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val btn: ImageButton = view.findViewById(R.id.Favorite)
        val btn2: ImageButton = view.findViewById(R.id.Greeting)
        val btn3: ImageButton = view.findViewById(R.id.Direction)
        val btn4: ImageButton = view.findViewById(R.id.Food)
        val btn5: ImageButton = view.findViewById(R.id.Transport)
        val btn6: ImageButton = view.findViewById(R.id.Social)
        val btn7: ImageButton = view.findViewById(R.id.Emergency)
        btn.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.Favorite ->
                vId = 0
            R.id.Greeting ->
                vId = 1
            R.id.Direction ->
                vId = 2
            R.id.Food ->
                vId = 3
            R.id.Transport ->
                vId = 4
            R.id.Social ->
                vId = 5
            R.id.Emergency ->
                vId = 6
        }
        val phrases =  MainFragmentDirections.actionMainFragmentToPhraseListFragment(vId)
        v!!.findNavController().navigate(phrases)
    }

}
