package CinemaJPA.vo;

import java.util.List;

public class OrderVO {
    private Long id;
    private String userName;
    private int status;

    private List<Long> placeIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Long> getPlaceIds() {
        return placeIds;
    }

    public void setPlaceIds(List<Long> placeIds) {
        this.placeIds = placeIds;
    }
}
