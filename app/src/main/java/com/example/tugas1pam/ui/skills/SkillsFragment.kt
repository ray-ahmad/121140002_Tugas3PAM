package com.example.tugas1pam.ui.skills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
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
import java.util.Locale

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

        listSkills.add(Skills("HTML", "Ini deskripsiHTML."))
        listSkills.add(Skills("CSS", "Kalau ini deskripsiCSS."))
        listSkills.add(Skills("PHP", "Nah ini deskripsiPHP."))
        listSkills.add(Skills("Laravel", "Nah kalau ini deskripsiLaravel."))
        listSkills.add(Skills("Python", "Yang ini deskripsiPython."))
        listSkills.add(Skills("C++", "Yang ini baru deskripsiC++"))
        listSkills.add(Skills("Kotlin", "Nah yang ini deskripsiKotlin."))
        listSkills.add(Skills("Javascript", "Nah kalau yang ini deskripsiJavascript."))
        listSkills.add(Skills("Bootstrap", "Ini baru deskripsiBootstrap."))

        val skillsAdapter = SkillsAdapter(listSkills)

        binding.searchSkills.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    val filteredList = ArrayList<Skills>()
                    for (i in listSkills) {
                        if (i.name?.lowercase(Locale.ROOT)?.contains(newText) == true
                            ||
                            i.desc?.lowercase(Locale.ROOT)?.contains(newText) == true) {
                            filteredList.add(i)
                        }
                    }

                    if (filteredList.isEmpty()) {
                        binding.rvSkills.visibility = View.INVISIBLE
                        binding.noResult.visibility = View.VISIBLE
                        Toast.makeText(requireActivity(), "Tidak ada hasil.", Toast.LENGTH_SHORT).show()
                    } else {
                        skillsAdapter.setFilteredList(filteredList)
                        binding.rvSkills.visibility = View.VISIBLE
                        binding.noResult.visibility = View.INVISIBLE
                    }
                }
                else{
                    binding.rvSkills.visibility = View.VISIBLE
                    binding.noResult.visibility = View.INVISIBLE
                }
                return true
            }

        })

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

    private fun filterList(query: String?) {


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}