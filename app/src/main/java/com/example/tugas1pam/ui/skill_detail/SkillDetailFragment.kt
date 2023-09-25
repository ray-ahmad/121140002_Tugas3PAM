package com.example.tugas1pam.ui.skill_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tugas1pam.databinding.FragmentSkillDetailBinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SkillDetailFragment : Fragment() {
    private lateinit var binding: FragmentSkillDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSkillDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

}