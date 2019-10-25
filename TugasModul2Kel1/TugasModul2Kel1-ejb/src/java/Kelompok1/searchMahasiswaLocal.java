/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kelompok1;

import javax.ejb.Local;

/**
 *
 * @author MY-PC
 */
@Local
public interface searchMahasiswaLocal {
    String search(String param);
    void Data(String nama, String nim);

    String checkNim(String param);
}
