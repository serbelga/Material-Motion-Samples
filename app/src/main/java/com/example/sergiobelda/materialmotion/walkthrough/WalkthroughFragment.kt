package com.example.sergiobelda.materialmotion.walkthrough

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import com.example.sergiobelda.materialmotion.databinding.WalkthroughFragmentBinding

private const val ARG_TITLE = "title"
private const val ARG_BODY = "body"
private const val ARG_DRAWABLE_RES = "drawableRes"

/**
 * A simple [Fragment] subclass.
 * Use the [WalkthroughFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WalkthroughFragment : Fragment() {
    private var title: String? = null
    private var body: String? = null
    private var drawableRes: Int? = null

    private var _binding: WalkthroughFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE)
            body = it.getString(ARG_BODY)
            drawableRes = it.getInt(ARG_DRAWABLE_RES)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WalkthroughFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleTextView.text = title
        binding.bodyTextView.text = body
        drawableRes?.let { binding.imageView.setImageResource(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param body Parameter 1.
         * @param imageRes Parameter 2.
         * @return A new instance of fragment WalkthroughFragment.
         */
        @JvmStatic
        fun newInstance(title: String, body: String, @DrawableRes imageRes: Int) =
            WalkthroughFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_BODY, body)
                    putInt(ARG_DRAWABLE_RES, imageRes)
                }
            }
    }
}
