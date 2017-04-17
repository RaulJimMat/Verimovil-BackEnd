/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raul
 * @param <T>
 */
public class WrapperList<T> {

    private List<T> lista;

    public WrapperList(Class<T> entityclass) {
        lista = new ArrayList<>();
    }
    
    
    
}
