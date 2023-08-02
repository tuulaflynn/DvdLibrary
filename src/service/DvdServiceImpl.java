package service;

import dao.DvdDao;
import dao.DvdDaoImpl;
import model.DvdPojo;

import java.util.List;

public class DvdServiceImpl implements DvdService{

    DvdDao dvdDao;      // I have declared this as a class variable of an dvdDao object so it can be used in all methods

    public DvdServiceImpl() {
        // This service layer is just a pass through, we use the dao object to call methods of the dao layer from within
        // the service methods. Hence, the constructor is just initialising the dao dvd object. It has a
        // reference point to the dao interface, so that the functionality of the object is restricted to the
        // interface actions of the dao layer only. This would make more sense if we had internal methods inside the
        // dao which were only for internal functionality and not to be used outside the class.
        dvdDao = new DvdDaoImpl();
    }


    @Override
    public DvdPojo addDvd(DvdPojo newDvd) {
        return dvdDao.addDvd(newDvd);
    }

    @Override
    public boolean removeDvd(int dvdId) {
        return dvdDao.removeDvd(dvdId);
    }

    @Override
    public DvdPojo editDvd(int dvdId) {
        return dvdDao.editDvd(dvdId);
    }

    @Override
    public List<DvdPojo> listDvds() {
        return dvdDao.listDvds();
    }

    @Override
    public DvdPojo displayDvd(int dvdId) {
        return dvdDao.displayDvd(dvdId);
    }

    @Override
    public DvdPojo searchDvd(String dvdTitle) { return dvdDao.searchDvd(dvdTitle); }

    @Override
    public boolean loadLibrary(String fileName) {
        return dvdDao.loadLibrary(fileName);
    }

    @Override
    public boolean writeLibrary(String fileName) {
        return dvdDao.writeLibrary(fileName);
    }
}
