package com.example.tugas1pam.ui.skills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas1pam.R
import com.example.tugas1pam.Skills
import com.example.tugas1pam.SkillsAdapter
import com.example.tugas1pam.databinding.FragmentSkillsBinding
import com.example.tugas1pam.ui.skill_detail.SkillDetailFragment

class SkillsFragment : Fragment() {
    companion object{
        var EXTRA_VALUE = "extra_value"
    }
    private val listSkills = ArrayList<Skills>()

    private var _binding: FragmentSkillsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val skillsViewModel =
            ViewModelProvider(this).get(SkillsViewModel::class.java)

//        bindingSkills =
        _binding = FragmentSkillsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.rvSkills.setHasFixedSize(true)
        binding.rvSkills.layoutManager = LinearLayoutManager(context)

        listSkills.add(Skills("HTML", "Lorem ipsum dolor sit amet consectetur adipisicing elit. A, adipisci."))
        listSkills.add(Skills("CSS", "Lorem ipsum dolor sit amet consectetur adipisicing elit. A, adipisci."))
        listSkills.add(Skills("PHP", "Lorem ipsum dolor sit amet consectetur adipisicing elit. A, adipisci."))
        listSkills.add(Skills("Laravel", "Lorem ipsum dolor sit amet consectetur adipisicing elit. A, adipisci."))
        listSkills.add(Skills("Python", "Lorem ipsum dolor sit amet consectetur adipisicing elit. A, adipisci."))
        listSkills.add(Skills("C++", "Lorem ipsum dolor sit amet consectetur adipisicing elit. A, adipisci."))
        listSkills.add(Skills("Kotlin", "Lorem ipsum dolor sit amet consectetur adipisicing elit. A, adipisci."))

        val skillsAdapter = SkillsAdapter(listSkills)


        skillsAdapter.setOnClickCallBack(object: SkillsAdapter.onClickCallBack{
            val skillDetail = SkillDetailFragment()
            val bundle = Bundle()

            override fun onItemClicked(data: Skills) {
//                Toast.makeText(requireActivity(), "Bahasa: " + data.name, Toast.LENGTH_SHORT).show()
                val bundle = bundleOf("extra_name" to data.name)
                findNavController().navigate(R.id.action_nav_skills_to_skillDetailFragment,bundle)
            }
        })
        binding.rvSkills.adapter = skillsAdapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}