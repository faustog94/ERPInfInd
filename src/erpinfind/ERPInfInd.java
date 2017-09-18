/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpinfind;

import Controllers.ArticuloController;
import Models.Articulo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franco-lxle
 */
public class ERPInfInd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        System.out.println(ArticuloController.getArticuloById(1).getDescripcion());
    }
    
}
