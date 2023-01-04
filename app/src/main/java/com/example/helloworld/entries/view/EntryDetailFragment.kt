package com.example.helloworld.entries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.helloworld.databinding.FragmentEntryDetailBinding
import com.example.helloworld.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class EntryDetailFragment : Fragment() {

    val args : EntryDetailFragmentArgs by navArgs()

    private lateinit var viewBinder: FragmentEntryDetailBinding
    private val viewModel: EntryDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinder = FragmentEntryDetailBinding.inflate(layoutInflater)
       getArgsData()

        return viewBinder.root
    }

    private fun getArgsData() {
        if (args.entry!=null){
            try {


                viewBinder.tvDetailTitle.text= args.entry.description.toString()
                viewBinder.imgDetail.loadImage(args.entry.link.toString())


            }catch (e: Exception){
                val msg = e.message.toString()

                Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
            }
        }
    }


}