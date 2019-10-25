package Kelompok1;

import java.util.ArrayList;
import javax.ejb.Stateful;

/**
 *
 * @author MY-PC
 */
@Stateful
public class searchMahasiswa implements searchMahasiswaLocal {
    ArrayList<Mahasiswa> mhs = new ArrayList<Mahasiswa>();
    
    @Override
    public void Data(String nama, String nim){
        mhs.add(new Mahasiswa (nama,nim));
    }
    
    public searchMahasiswa(){
        Data("Ade", "21120116130075");
        Data("Agus", "21120116120008");
        Data("Ali", "21120116130037");
        Data("Satria", "21120116120007");
        Data("Hilmi", "21120116120009");
        Data("Rindhon", "21120116120028");
    }

private String checkNama(String param){
	for (int i = 0; i< mhs.size(); i++) {
		if (param.equals(mhs.get(i).nama)) {
			return "Nama Praktikan : "+mhs.get(i).nama+"("+mhs.get(i).nim+")";
		}
	}
	return null;
}

@Override
    public String checkNim(String param) {
        	for (int i = 0; i< mhs.size(); i++) {
		if (param.equals(mhs.get(i).nim)) {
			return "Nama Praktikan : "+mhs.get(i).nama+"("+mhs.get(i).nim+")";
		}
	}
        return null;
    }

public String search(String param){
    if (checkNama(param) != null){
            return checkNama(param);
        }
	else if (checkNim(param) != null) {
            return checkNim(param);
        }
        else {
            return "No";
    }
};  
}
