package CinemaJPA.Entities;

import CinemaJPA.vo.PlaceVO;

import javax.persistence.*;

@Entity(name = "places")
public class PlaceE {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_id")
    private Long sessionId;

    @Column(name = "sit_row")
    private int row;

    @Column(name = "sit_column")
    private int column;

    @Column(name = "sit_status")
    private int status;

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static PlaceE fromVO(PlaceVO placeVO){
        PlaceE place = new PlaceE();
        place.setId(placeVO.getId());
        place.setSessionId(placeVO.getSessionId());
        place.setRow(placeVO.getRow());
        place.setColumn(placeVO.getColumn());
        place.setStatus(placeVO.getStatus());
        return place;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
