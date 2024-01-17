package com.liocosoft.liocoflashcontroller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FlashTab extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_flash_tab, container, false);

        FlashLightController flashLight = new FlashLightController(view.getContext());

        FloatingActionButton btnStop = view.findViewById(R.id.btnStop);
        btnStop.setOnClickListener(v -> flashLight.stopLightDance());
        Button btnOn = view.findViewById(R.id.btnOn);
        btnOn.setOnClickListener(v -> flashLight.flashlightOn());
        Button btnOff = view.findViewById(R.id.btnOff);
        btnOff.setOnClickListener(v -> flashLight.flashlightOff());
        Button btnSos = view.findViewById(R.id.btnSos);
        btnSos.setOnClickListener(v -> flashLight.sosSignal());
        Button btnRandom = view.findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(v -> flashLight.randomBlink());
        Button btnAlt = view.findViewById(R.id.btnAlt);
        btnAlt.setOnClickListener(v -> flashLight.alternatingBlink());
        Button btnDouble = view.findViewById(R.id.btnDouble);
        btnDouble.setOnClickListener(v -> flashLight.doubleBlink());
        Button btnFast = view.findViewById(R.id.btnFast);
        btnFast.setOnClickListener(v -> flashLight.fastBlink());
        Button btnSlow = view.findViewById(R.id.btnSlow);
        btnSlow.setOnClickListener(v -> flashLight.slowBlink());
        Button btnHeartBeat = view.findViewById(R.id.btnHeartBeat);
        btnHeartBeat.setOnClickListener(v -> flashLight.heartbeatEffect());
        Button btnWaterfall = view.findViewById(R.id.btnWaterfall);
        btnWaterfall.setOnClickListener(v -> flashLight.waterfallEffect());
        Button btnDisco = view.findViewById(R.id.btnDisco);
        btnDisco.setOnClickListener(v -> flashLight.discoEffect());
        Button btnZigzag = view.findViewById(R.id.btnZigzag);
        btnZigzag.setOnClickListener(v -> flashLight.zigzagEffect());
        Button btnStarWars = view.findViewById(R.id.btnStarWars);
        btnStarWars.setOnClickListener(v -> flashLight.starWarsTheme());
        Button btnTetris = view.findViewById(R.id.btnTetris);
        btnTetris.setOnClickListener(v -> flashLight.tetrisTheme());
        Button btnHarryPotter = view.findViewById(R.id.btnHarryPotter);
        btnHarryPotter.setOnClickListener(v -> flashLight.harryPotterTheme());
        Button btnStarTrek = view.findViewById(R.id.btnStarTrek);
        btnStarTrek.setOnClickListener(v -> flashLight.starTrekTheme());
        Button btnJamesBond = view.findViewById(R.id.btnJamesBond);
        btnJamesBond.setOnClickListener(v -> flashLight.jamesBondTheme());
        Button btnIndianaJones = view.findViewById(R.id.btnIndianaJones);
        btnIndianaJones.setOnClickListener(v -> flashLight.indianaJonesTheme());
        Button btnJurassicPark = view.findViewById(R.id.btnJurassicPark);
        btnJurassicPark.setOnClickListener(v -> flashLight.jurassicParkTheme());
        Button btnLotr = view.findViewById(R.id.btnLotr);
        btnLotr.setOnClickListener(v -> flashLight.lordOfTheRingsTheme());
        Button btnMatrix = view.findViewById(R.id.btnMatrix);
        btnMatrix.setOnClickListener(v -> flashLight.matrixTheme());
        Button btnAvengers = view.findViewById(R.id.btnAvengers);
        btnAvengers.setOnClickListener(v -> flashLight.avengersTheme());
        Button btnPotc = view.findViewById(R.id.btnPotc);
        btnPotc.setOnClickListener(v -> flashLight.piratesOfTheCaribbeanTheme());
        Button btnBtf = view.findViewById(R.id.btnBtf);
        btnBtf.setOnClickListener(v -> flashLight.backToTheFutureTheme());
        Button btnEt = view.findViewById(R.id.btnEt);
        btnEt.setOnClickListener(v -> flashLight.etTheme());
        Button btnGhostBusters = view.findViewById(R.id.btnGhostBusters);
        btnGhostBusters.setOnClickListener(v -> flashLight.ghostBustersTheme());
        Button btnBatman = view.findViewById(R.id.btnBatman);
        btnBatman.setOnClickListener(v -> flashLight.batmanTheme());
        Button btnFrozen = view.findViewById(R.id.btnFrozen);
        btnFrozen.setOnClickListener(v -> flashLight.frozenTheme());
        Button btnLionKing = view.findViewById(R.id.btnLionKing);
        btnLionKing.setOnClickListener(v -> flashLight.lionKingTheme());

        return view;
    }
}