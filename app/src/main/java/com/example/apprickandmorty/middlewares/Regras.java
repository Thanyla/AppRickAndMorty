package com.example.apprickandmorty.middlewares;

import java.util.Random;

public class Regras {
    private String[] personagens ={"Morty","Rick", "Jerry", "Summer", "Beth"};
    private int[] pesos = {0,0,0,0,0};

    public void addPesoMorty(){
        this.pesos[0]++;
    }

    public void addPesoRick(){
        this.pesos[1]++;
    }

    public void addPesoJerry(){
        this.pesos[2]++;
    }

    public void addPesoSummer(){
        this.pesos[3]++;
    }

    public void addPesoBeth(){
        this.pesos[4]++;
    }

    public String getVencedor(){
        int vencedor = -1;

        for(int i=0; i<5; i++){
            if(vencedor == -1) {
                vencedor = i;
            }else if(pesos[i] > pesos[vencedor]){
                vencedor = i;
            }else if(pesos[i] == pesos[vencedor]){
                int[] random = {i, vencedor};
                vencedor = new Random().nextInt(random.length);
            }
        }

        return personagens[vencedor];
    }


}
