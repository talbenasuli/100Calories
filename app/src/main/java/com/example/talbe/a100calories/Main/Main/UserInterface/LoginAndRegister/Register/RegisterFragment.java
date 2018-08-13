package com.example.talbe.a100calories.Main.Main.UserInterface.LoginAndRegister.Register;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.talbe.a100calories.Main.Main.Data.UserDetails;
import com.example.talbe.a100calories.Main.Main.UserInterface.Common.ContainerActivity;
import com.example.talbe.a100calories.Main.Main.UserInterface.Views.RegisterTextFields;
import com.example.talbe.a100calories.R;

public class RegisterFragment extends Fragment
        implements RegisterTextFields.RegisterTextFieldsListener, RegisterPresentor.RegisterPresentorListener {

    public static String TAG = "RegisterFragment";
    public static RegisterFragment newInstance() {
        Bundle args = new Bundle();
        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private RegisterFragmentListener activityListener;

    public interface RegisterFragmentListener extends ContainerActivity.ContainerActivityInterface {
        void registerTextFieldsOnBack();
        void moveToHome();
    }

    View registerView;
    RegisterTextFields registerTextFields;
    RegisterPresentor presentor = new RegisterPresentor();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            activityListener = (RegisterFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity " + getActivity().getClass().getName() + " must implement RegisterFragment");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        registerView = inflater.inflate(R.layout.register_fragment, container, false);
        presentor.setListener(this);
        return registerView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerTextFields = view.findViewById(R.id.registerTextFields);
        registerTextFields.setListener(this);
    }

    @Override
    public void registerTextFieldsOnBack() {
        activityListener.registerTextFieldsOnBack();
    }

    @Override
    public void registerTextFieldsOnRegister(UserDetails userDetails, String password) {
        activityListener.showProgressBar();
        presentor.onRegisterTapped(userDetails, password);
    }

    @Override
    public void registerTextFieldOnFail(String message) {
        activityListener.hideProgressBar();
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG);
    }

    @Override
    public void moveToHome() {
        activityListener.hideProgressBar();
        activityListener.moveToHome();
    }
}
