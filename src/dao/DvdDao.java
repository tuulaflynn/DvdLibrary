package dao;

import model.DvdPojo;
import java.util.List;

public interface DvdDao {

    DvdPojo addDvd(DvdPojo newDvd);
    boolean removeDvd(int dvdId);
    DvdPojo editDvd(int dvdId);     // not sure if the parameter should be DvdPojo
    List<DvdPojo> listDvds();
    DvdPojo displayDvd(int dvdId);
    DvdPojo searchDvd(String dvdTitle);
    boolean loadLibrary(String fileName);
    boolean writeLibrary(String fileName);


}
