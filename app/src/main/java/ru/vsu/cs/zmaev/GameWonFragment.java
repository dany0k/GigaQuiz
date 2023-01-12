//package ru.vsu.cs.zmaev;
//
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.databinding.DataBindingUtil;
//import androidx.fragment.app.Fragment;
//import androidx.navigation.Navigation;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import ru.vsu.cs.zmaev.databinding.FragmentGameWonBinding;
//
//public class GameWonFragment extends Fragment {
//
//    public GameWonFragment() {
//        super(R.layout.fragment_game_won);
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);
//        FragmentGameWonBinding binding = DataBindingUtil.inflate(
//                inflater, R.layout.fragment_game_won, container, false);
//
//        binding.nextMatchButton.setOnClickListener(view -> {
//            Navigation.findNavController(view).navigate(R.id.action_gameWonFragment_to_gameFragment);
//        });
//        return binding.getRoot();
//    }
//}