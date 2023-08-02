package model;
import java.time.LocalDate;


public class DvdPojo {
    private int dvdId;
    private String dvdTitle;
    private LocalDate dvdReleaseDate;
    private String dvdMPAARating;
    private String dvdDirector;
    private String dvdStudio;
    private String dvdUserRating;

    public DvdPojo(int dvdId, String dvdTitle, LocalDate dvdReleaseDate, String dvdMPAARating, String dvdDirector,
                   String dvdStudio, String dvdUserRating) {
        this.dvdId = dvdId;
        this.dvdTitle = dvdTitle;
        this.dvdReleaseDate = dvdReleaseDate;
        this.dvdMPAARating = dvdMPAARating;
        this.dvdDirector = dvdDirector;
        this.dvdStudio = dvdStudio;
        this.dvdUserRating = dvdUserRating;
    }

    public int getDvdId() {
        return dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    public String getDvdTitle() {
        return dvdTitle;
    }

    public void setDvdTitle(String dvdTitle) {
        this.dvdTitle = dvdTitle;
    }

    public LocalDate getDvdReleaseDate() {
        return dvdReleaseDate;
    }

    public void setDvdReleaseDate(LocalDate dvdReleaseDate) {
        this.dvdReleaseDate = dvdReleaseDate;
    }

    public String getDvdMPAARating() {
        return dvdMPAARating;
    }

    public void setDvdMPAARating(String dvdMPAARating) {
        this.dvdMPAARating = dvdMPAARating;
    }

    public String getDvdDirector() {
        return dvdDirector;
    }

    public void setDvdDirector(String dvdDirector) {
        this.dvdDirector = dvdDirector;
    }

    public String getDvdStudio() {
        return dvdStudio;
    }

    public void setDvdStudio(String dvdStudio) {
        this.dvdStudio = dvdStudio;
    }

    public String getDvdUserRating() {
        return dvdUserRating;
    }

    public void setDvdUserRating(String dvdUserRating) {
        this.dvdUserRating = dvdUserRating;
    }

    @Override
    public String toString() {
        return "DvdPojo{" +
                "dvdId=" + dvdId +
                ", dvdTitle='" + dvdTitle + '\'' +
                ", dvdReleaseDate=" + dvdReleaseDate +
                ", dvdMPAARating='" + dvdMPAARating + '\'' +
                ", dvdDirector='" + dvdDirector + '\'' +
                ", dvdStudio='" + dvdStudio + '\'' +
                ", dvdUserRating='" + dvdUserRating + '\'' +
                '}';
    }

    public DvdPojo copyObject() {
        // this method creates a copy of an object (to then add to the database) this means that there will only be
        // one reference point which points to this object so it cannot accidently be changed in the presentation or
        // service layer.
        return new DvdPojo(this.dvdId, this.dvdTitle, this.dvdReleaseDate, this.dvdMPAARating,
                this.dvdDirector, this.dvdStudio, this.dvdUserRating);
/*        Above is a more streamlined way as we don't need to store the variable before we return it, the object is
          returned, whether it is saved as copiedObject or is declared as it is returned.

          DvdPojo copiedObject = new DvdPojo(this.dvdId, this.dvdTitle, this.dvdReleaseDate, this.dvdMPAARating,
                  this.dvdDirector, this.dvdStudio, this.dvdUserRating);
          return copiedObject;
*/
    }
}
