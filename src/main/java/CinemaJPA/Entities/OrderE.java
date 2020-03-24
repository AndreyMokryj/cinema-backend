package CinemaJPA.Entities;

import CinemaJPA.vo.MovieVO;
import CinemaJPA.vo.OrderVO;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

//@Where(clause = "status = 0")
@Entity(name = "orders")
public class OrderE {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_name")
    private String userName;
    private int status;

    @Column(name="place_ids")
    private String placeIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public static OrderE fromVO(OrderVO orderVO){
        OrderE order = new OrderE();
        order.setId(orderVO.getId());
        order.setUserName(orderVO.getUserName());
        order.setStatus(orderVO.getStatus());
        String ids = "";
        for (Long id : orderVO.getPlaceIds()){
            ids += id + " ";
        }
        order.setPlaceIds(ids);
        return order;
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

    public String getPlaceIds() {
        return placeIds;
    }

    public void setPlaceIds(String placeIds) {
        this.placeIds = placeIds;
    }
}
