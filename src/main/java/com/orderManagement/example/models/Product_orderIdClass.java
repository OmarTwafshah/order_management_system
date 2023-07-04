package bzu.order_management.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orderManagement.example.models.order;
import com.orderManagement.example.models.product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product_orderIdClass implements Serializable {

    private static final long serialVersionUID = -3407498632786716502L;

    private product productId;

    private order orderId;

}