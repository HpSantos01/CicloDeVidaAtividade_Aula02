/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.usjt.cdv_si3an_mca.util;

import android.os.Handler;
import android.widget.TextView;
import java.util.List;

public class Utils {

    private static br.usjt.cdv_si3an_mca.util.StatusTracker mStatusTracker = br.usjt.cdv_si3an_mca.util.StatusTracker.getInstance();

    /**
     * Método auxiliar para imprimir o estado do ciclo de vida de cada atividade.
     * foi envolvido em um manipulador para atrasar a saída devido a sobreposições no estado do ciclo de vida
     * muda como uma atividade lança outra.
     * @link http://developer.android.com/guide/topics/fundamentals/activities.html#CoordinatingActivities
     * @param viewMethods TextView para listar os métodos de ciclo de vida
     * @param viewStatus TextView para listar o status de todas as classes de atividade
     */
    public static void printStatus(final TextView viewMethods, final TextView viewStatus) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Obtenha a pilha de métodos do ciclo de vida da atividade e imprima no TextView
                StringBuilder sbMethods = new StringBuilder();
                List<String> listMethods = mStatusTracker.getMethodList();
                for (String method : listMethods) {
                    sbMethods.insert(0, method + "\r\n");
                }
                if(viewMethods != null) {
                    viewMethods.setText(sbMethods.toString());
                }

                // Obtenha o status de todas as classes de Atividade e imprima no TextView
                StringBuilder sbStatus = new StringBuilder();
                for (String key : mStatusTracker.keySet()) {
                    sbStatus.insert(0,key + ": " + mStatusTracker.getStatus(key) + "\n");
                }
                if(viewStatus != null) {
                    viewStatus.setText(sbStatus.toString());
                }
            }
        }, 750);
    }
}