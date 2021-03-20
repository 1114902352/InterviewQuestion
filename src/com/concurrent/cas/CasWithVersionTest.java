package com.concurrent.cas;

import java.util.concurrent.atomic.AtomicStampedReference;

public class CasWithVersionTest {

    public static void main(String[] args) {
        AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(1,0);
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        Integer m = money.getReference();
                        if(m >= 20){

                        }
                    }
                }
            });
        }
    }
}
