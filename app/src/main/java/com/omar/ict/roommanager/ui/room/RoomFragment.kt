package com.omar.ict.roommanager.ui.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.omar.ict.mylearningsummary.databinding.FragmentRoomBinding
import com.omar.ict.roommanager.data.model.room.Room
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomFragment : Fragment() {

    lateinit var binding: FragmentRoomBinding

    private val viewModel by activityViewModels<RoomViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRoomBinding.inflate(inflater)

        // observe the changes in viewmodel liveData
        viewModel.room.observe(viewLifecycleOwner) {
            setupUI(it)
        }
        viewModel.getRoom()

        return binding.root
    }

    private fun setupUI(roomList: Room) {
        binding.roomList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = RoomAdapter(
                roomList
            )
        }
    }
}