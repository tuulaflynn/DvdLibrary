package dao;

import model.DvdPojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DvdDaoImpl implements DvdDao {
    // create collection to store data in (as we have no used databases yet)
    List<DvdPojo>dvdLibrary = new ArrayList<DvdPojo>();

    public DvdDaoImpl() {
        // constructor to initially load out collection with some dvd data
        LocalDate localDatePojo1 = LocalDate.parse("2001-05-10");
        LocalDate localDatePojo2 = LocalDate.parse("2004-05-19");
        LocalDate localDatePojo3 = LocalDate.parse("2007-05-18");
        LocalDate localDatePojo4 =LocalDate.parse("2010-05-21") ;
        DvdPojo pojo1 = new DvdPojo(1,"Shrek",localDatePojo1,"PG","Andrew Adamson & Vicky Jenson","DreamWorks Animation","");
        DvdPojo pojo2 = new DvdPojo(2,"Shrek 2",localDatePojo2,"PG","Andrew Adamson & Kelly Asbury & Conrad Vernon","DreamWorks Animation", "");
        DvdPojo pojo3 = new DvdPojo(3,"Shrek the Thirds",localDatePojo3,"PG","Chris Miller & Raman Hui","DreamWorks Animation", "");
        DvdPojo pojo4 = new DvdPojo(4,"Shrek Forever After",localDatePojo4,"PG","Mike Mitchell","DreamWorks Animation","");

        dvdLibrary.add(pojo1);
        dvdLibrary.add(pojo2);
        dvdLibrary.add(pojo3);
        dvdLibrary.add(pojo4);
    }

    @Override
    public DvdPojo addDvd(DvdPojo newDvd) {
        // generates dvd id
        if (dvdLibrary.size() == 0) {
            newDvd.setDvdId(1);
        }
        else {
            int lastId = dvdLibrary.get(dvdLibrary.size()-1).getDvdId() + 1;
            newDvd.setDvdId(lastId);
        }

        // adds a copy of the dvd pojo object to database called dvdLibrary
        dvdLibrary.add(newDvd.copyObject());
        return newDvd;
    }

    @Override
    public boolean removeDvd(int dvdId) {
        return false;
    }

    @Override
    public DvdPojo editDvd(int dvdId) {
        return null;
    }

    @Override
    public List<DvdPojo> listDvds() {
        List<DvdPojo> returnedList = new ArrayList<DvdPojo>(dvdLibrary);
        return returnedList;
    }

    @Override
    public DvdPojo displayDvd(int dvdId) {
        for (DvdPojo dvd: dvdLibrary) {
            if (dvd.getDvdId() == dvdId) {
                return dvd;
            }
        }
        return null;
    }

    @Override
    public DvdPojo searchDvd(String dvdTitle) {
        for (DvdPojo dvd: dvdLibrary) {
            if (dvd.getDvdTitle().equals(dvdTitle)) {
                return dvd;
            }
        }
        return null;
    }

    @Override
    public boolean loadLibrary(String fileName) {
        return false;
    }

    @Override
    public boolean writeLibrary(String fileName) {
        return false;
    }
}
