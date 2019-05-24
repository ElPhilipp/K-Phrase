package com.example.kphrase.Fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.kphrase.Categories
import com.example.kphrase.FirebaseRef

import com.example.kphrase.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.example.kphrase.MainActivity
import java.nio.file.Files.size
import com.google.firebase.database.GenericTypeIndicator

class PhraseListFragment : Fragment() {
    var TAG = "LISTFRAG"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_phrase_list, container, false)

        val arg = arguments?.let { PhraseListFragmentArgs.fromBundle(it) }
        val vId = arg!!.id

        Toast.makeText(context, vId.toString(), Toast.LENGTH_SHORT).show()

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val children = dataSnapshot.children
                children.forEach {
                    Log.d("TEST", it.toString())
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
                // ...
            }
        }
        FirebaseRef.database.addValueEventListener(postListener)

        return view
    }



}
