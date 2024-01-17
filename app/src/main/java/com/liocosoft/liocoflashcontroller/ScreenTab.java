package com.liocosoft.liocoflashcontroller;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ScreenTab extends Fragment {
    View view;
    private View viewColorDisplay;
    private ScreenLightController screenLightController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_screen_tab, container, false);

        viewColorDisplay=view.findViewById(R.id.viewColorDisplay);
        screenLightController = new ScreenLightController(viewColorDisplay, getActivity().getWindow());

        viewColorDisplay.setOnClickListener(view -> screenLightController.resetColor());

        Button btnWhite = view.findViewById(R.id.btnWhite);
        btnWhite.setOnClickListener(view -> screenLightController.setColor(Color.WHITE));
        Button btnGray = view.findViewById(R.id.btnGray);
        btnGray.setOnClickListener(view -> screenLightController.setColor(Color.GRAY));
        Button btnBlack = view.findViewById(R.id.btnBlack);
        btnBlack.setOnClickListener(view -> screenLightController.setColor(Color.BLACK));
        Button btnBlue = view.findViewById(R.id.btnBlue);
        btnBlue.setOnClickListener(view -> screenLightController.setColor(Color.BLUE));
        Button btnRed = view.findViewById(R.id.btnRed);
        btnRed.setOnClickListener(view -> screenLightController.setColor(Color.RED));
        Button btnGreen = view.findViewById(R.id.btnGreen);
        btnGreen.setOnClickListener(view -> screenLightController.setColor(Color.GREEN));
        Button btnYellow = view.findViewById(R.id.btnYellow);
        btnYellow.setOnClickListener(view -> screenLightController.setColor(Color.YELLOW));
        Button btnMagenta = view.findViewById(R.id.btnMagenta);
        btnMagenta.setOnClickListener(view -> screenLightController.setColor(Color.MAGENTA));
        Button btnCyan = view.findViewById(R.id.btnCyan);
        btnCyan.setOnClickListener(view -> screenLightController.setColor(Color.CYAN));
        Button btnRandom = view.findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(view -> screenLightController.randomBlink());
        Button btnAlt = view.findViewById(R.id.btnAlt);
        btnAlt.setOnClickListener(view -> screenLightController.alternatingBlink());
        Button btnFast = view.findViewById(R.id.btnFast);
        btnFast.setOnClickListener(view -> screenLightController.fastBlink());
        Button btnSlow = view.findViewById(R.id.btnSlow);
        btnSlow.setOnClickListener(view -> screenLightController.slowBlink());
        Button btnDisco = view.findViewById(R.id.btnDisco);
        btnDisco.setOnClickListener(view -> screenLightController.discoEffect());
        Button btnPoliceSiren = view.findViewById(R.id.btnPoliceSiren);
        btnPoliceSiren.setOnClickListener(view -> screenLightController.policeSiren());

        return view;
    }
}