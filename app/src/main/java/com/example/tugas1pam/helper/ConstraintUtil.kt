package com.example.tugas1pam.helper

import androidx.fragment.app.Fragment
import com.example.tugas1pam.R
import com.example.tugas1pam.Skills

object ConstraintUtil {

    fun getSkillsData(fragement: Fragment): ArrayList<Skills> {
        val skillArrayList = ArrayList<Skills>()
        val name = fragement.resources.getStringArray(R.array.string_skills_name_array)
        val desc = fragement.resources.getStringArray(R.array.string_skills_desc_array)

        for (i in name.indices) {
            skillArrayList.add(Skills(name[i], desc[i]))
        }

        return skillArrayList
    }

}